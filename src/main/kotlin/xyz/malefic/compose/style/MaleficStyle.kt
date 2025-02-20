package xyz.malefic.compose.style

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp

@Suppress("MemberVisibilityCanBePrivate")
class MaleficStyle {
    /**
     * Padding values to be applied to the element.
     *
     * The padding can be:
     * - `PaddingValues` for custom padding values
     * - `Dp` for uniform padding on all sides
     * - `Pair<Dp, Dp>` for horizontal and vertical padding
     * - `Pair<Pair<Dp, Dp>, Dp>` for start, top, end, bottom padding
     */
    var padding: Any? = null

    /**
     * Applies the padding values defined in the `MaleficStyle` to the `Modifier`.
     *
     * @receiver The `Modifier` to which the padding values will be applied.
     * @return A `Modifier` with the applied padding values.
     */
    private fun Modifier.buildPadding(): Modifier =
        when (val paddingValue = padding) {
            is PaddingValues -> padding(paddingValue)
            is Dp -> padding(paddingValue)
            is Pair<*, *> -> {
                when (paddingValue.first) {
                    is Dp -> {
                        val (horizontal, vertical) = paddingValue
                        padding(horizontal as Dp, vertical as Dp)
                    }
                    is Pair<*, *> -> {
                        val pvp = paddingValue as Pair<Pair<Pair<Dp, Dp>, Dp>, Dp>
                        padding(pvp.first(), pvp.second, pvp.third(), pvp.fourth())
                    }
                    else -> this
                }
            }
            else -> this
        }

    /**
     * Background color and potentially shape to be applied to the element.
     *
     * The background can be:
     * - `Color` for solid color background
     * - `Pair<Color, Shape>` for shaped color background
     */
    var background: Any? = null

    /**
     * Applies the background defined in the `MaleficStyle` to the `Modifier`.
     *
     * @receiver The `Modifier` to which the background will be applied.
     * @return A `Modifier` with the applied background.
     */
    private fun Modifier.buildBackground(): Modifier =
        when (val bg = background) {
            is Color -> background(bg)
            is Pair<*, *> -> {
                val (color, shape) = bg
                background(color as Color, shape as Shape)
            }
            else -> this
        }

    /**
     * Border values to be applied to the element.
     *
     * The border can be:
     * - `BorderStroke` for basic border
     * - `Pair<Dp, Color>` for width and color
     * - `Pair<BorderStroke, Shape>` for shaped border
     * - `Pair<Pair<Dp, Color|Brush>, Shape>` for width, color/brush, and shape
     */
    var border: Any? = null

    /**
     * Applies the border values defined in the `MaleficStyle` to the `Modifier`.
     *
     * @receiver The `Modifier` to which the border values will be applied.
     * @return A `Modifier` with the applied border values.
     */
    private fun Modifier.buildBorder(): Modifier =
        when (val borderValue = border) {
            is BorderStroke -> border(borderValue)
            is Pair<*, *> -> {
                val (first, second) = borderValue
                when (first) {
                    is Dp -> border(first, second as Color)
                    is BorderStroke -> border(first, second as Shape)
                    is Pair<*, *> -> {
                        val (width, fillOrBrush) = first
                        when (fillOrBrush) {
                            is Color -> border(width as Dp, fillOrBrush, second as Shape)
                            is Brush -> border(width as Dp, fillOrBrush, second as Shape)
                            else -> this
                        }
                    }
                    else -> this
                }
            }
            else -> this
        }

    /**
     * Clickable action to be applied to the element.
     */
    var onClick: (() -> Unit)? = null

    /**
     * Applies the clickable action defined in the `MaleficStyle` to the `Modifier`.
     *
     * @receiver The `Modifier` to which the clickable action will be applied.
     * @return A `Modifier` with the applied clickable action.
     */
    private fun Modifier.buildClickable(): Modifier = onClick?.let { clickable(onClick = it) } ?: this

    /**
     * Width to be applied to the element.
     */
    var width: Dp? = null

    /**
     * Height to be applied to the element.
     */
    var height: Dp? = null

    /**
     * Applies the width and height defined in the `MaleficStyle` to the `Modifier`.
     *
     * @receiver The `Modifier` to which the size will be applied.
     * @return A `Modifier` with the applied size.
     */
    private fun Modifier.buildSize(): Modifier =
        this.let { base ->
            base
                .run { width?.let { width(it) } ?: this }
                .run { height?.let { height(it) } ?: this }
        }

    /**
     * Builds the final Modifier by applying all defined styles in order:
     * padding -> background -> border -> clickable -> size
     */
    fun build(): Modifier =
        Modifier
            .buildPadding()
            .buildBackground()
            .buildBorder()
            .buildClickable()
            .buildSize()
}

fun Pair<Pair<Pair<Dp, Dp>, Dp>, Dp>.first(): Dp = first.first.first

fun Pair<Pair<Pair<Dp, Dp>, Dp>, Dp>.second(): Dp = first.first.second

fun Pair<Pair<Pair<Dp, Dp>, Dp>, Dp>.third(): Dp = first.second

fun Pair<Pair<Pair<Dp, Dp>, Dp>, Dp>.fourth(): Dp = second
