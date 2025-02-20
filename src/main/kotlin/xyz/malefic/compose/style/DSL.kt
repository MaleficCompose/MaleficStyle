package xyz.malefic.compose.style

import androidx.compose.ui.Modifier

/**
 * Creates a custom `Modifier` using the provided `ModifierWrapperBuilder` block.
 *
 * @param block A lambda with receiver that configures the `ModifierWrapperBuilder`.
 * @return A `Modifier` configured by the `ModifierWrapperBuilder`.
 */
fun malefic(block: MaleficStyle.() -> Unit): Modifier = MaleficStyle().apply(block).build()
