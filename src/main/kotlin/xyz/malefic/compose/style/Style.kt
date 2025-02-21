package xyz.malefic.compose.style

import androidx.compose.ui.Modifier

/**
 * Interface representing a style that can be applied to a Compose `Modifier`.
 *
 * @param T The type of the style that implements this interface.
 */
interface Style<T : Style<T>> {
    /**
     * The modifier to which the style will be applied.
     */
    var modifier: Modifier

    /**
     * Applies the given block of code to the style.
     *
     * @param block A lambda with receiver of type `T` that defines the style properties.
     */
    fun update(block: T.() -> Unit)
}
