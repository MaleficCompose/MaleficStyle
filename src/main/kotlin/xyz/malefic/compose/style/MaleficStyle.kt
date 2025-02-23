package xyz.malefic.compose.style

import androidx.compose.ui.Modifier

/**
 * A class that defines various styles to be applied to a Compose UI element.
 *
 * This class includes properties for padding, background, border, clickable actions, size, and more,
 * each of which can be customized and applied to a `Modifier`.
 */
class MaleficStyle {
    /**
     * Modifier to be applied to the element.
     */
    var modifier: Modifier = Modifier

    /**
     * Size values to be applied to the element.
     *
     * The size can be defined using the [SizeStyle] class.
     */
    var size: SizeStyle = SizeStyle()

    /**
     * Applies the given block to the `SizeStyle` and updates the `modifier` accordingly.
     *
     * @param block The block of code to apply to the `SizeStyle`.
     */
    operator fun SizeStyle.invoke(block: SizeStyle.() -> Unit) {
        this@MaleficStyle.apply {
            size.block()
            modifier = modifier.then(this@invoke.modifier)
        }
    }

    /**
     * Appearance values to be applied to the element.
     *
     * The appearance can be defined using the [AppearanceStyle] class.
     */
    var appearance: AppearanceStyle = AppearanceStyle()

    /**
     * Applies the given block to the `AppearanceStyle` and updates the `modifier` accordingly.
     *
     * @param block The block of code to apply to the `AppearanceStyle`.
     */
    operator fun AppearanceStyle.invoke(block: AppearanceStyle.() -> Unit) {
        this@MaleficStyle.apply {
            appearance.block()
            modifier = modifier.then(this@invoke.modifier)
        }
    }

    /**
     * Interaction values to be applied to the element.
     *
     * The interaction can be defined using the [InteractStyle] class.
     */
    var interact: InteractStyle = InteractStyle()

    /**
     * Applies the given block to the `InteractStyle` and updates the `modifier` accordingly.
     *
     * @param block The block of code to apply to the `InteractStyle`.
     */
    operator fun InteractStyle.invoke(block: InteractStyle.() -> Unit) {
        this@MaleficStyle.apply {
            interact.block()
            modifier = modifier.then(this@invoke.modifier)
        }
    }
}
