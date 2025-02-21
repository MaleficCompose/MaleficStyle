package xyz.malefic.compose.style

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

/**
 * A class that defines size-related styles for a component.
 *
 * @property modifier The modifier to apply the size styling to.
 */
@Suppress("unused")
class SizeStyle(
    override var modifier: Modifier = Modifier,
) : Style<SizeStyle> {
    /**
     * The width of the component.
     */
    var width: Dp? = null
        set(value) {
            field = value
            modifier = modifier.width(value!!)
        }

    /**
     * The height of the component.
     */
    var height: Dp? = null
        set(value) {
            field = value
            modifier = modifier.height(value!!)
        }

    /**
     * The maximum height of the component as a fraction of the parent's height.
     */
    var fillMaxHeight: Float? = null
        set(value) {
            field = value
            modifier = modifier.fillMaxHeight(value!!)
        }

    /**
     * The maximum width of the component as a fraction of the parent's width.
     */
    var fillMaxWidth: Float? = null
        set(value) {
            field = value
            modifier = modifier.fillMaxWidth(value!!)
        }

    /**
     * The maximum size of the component as a fraction of the parent's size.
     */
    var fillMaxSize: Float? = null
        set(value) {
            field = value
            modifier = modifier.fillMaxSize(value!!)
        }

    /**
     * Applies the given block to the current instance of SizeStyle.
     *
     * @param block A lambda block to initialize the size properties.
     */
    override fun update(block: SizeStyle.() -> Unit) {
        this.apply(block)
    }

    /**
     * Sets the maximum height to 100% of the parent's height.
     */
    fun fillMaxHeight() = apply { fillMaxHeight = 1f }

    /**
     * Sets the maximum width to 100% of the parent's width.
     */
    fun fillMaxWidth() = apply { fillMaxWidth = 1f }

    /**
     * Sets the maximum size to 100% of the parent's size.
     */
    fun fillMaxSize() = apply { fillMaxSize = 1f }
}

/**
 * Extension function to build a Modifier with the given SizeStyle.
 *
 * @param style The SizeStyle to apply to the Modifier.
 * @return The modified Modifier.
 */
fun Modifier.build(style: SizeStyle): Modifier = this then style.modifier
