package xyz.malefic.compose.style

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlin.test.Test
import kotlin.test.assertTrue

/**
 * Test class for MaleficStyle.
 */
class MaleficStyleTest {
    /**
     * Test function to verify the equality of modifiers.
     */
    @Test
    fun test() {
        val mod =
            malefic {
                padding = 15.dp to 16.dp to 16.dp to 16.dp
                background = Color.Blue to CircleShape
                border = 2.dp to Color.Red to CircleShape
                size {
                    width = 100.dp
                    height = 50.dp
                    fillMaxSize = 1f
                }
            }

        val expectedModifier =
            Modifier
                .padding(15.dp, 16.dp, 16.dp, 16.dp)
                .background(Color.Blue, CircleShape)
                .border(2.dp, Color.Red, CircleShape)
                .width(100.dp)
                .height(50.dp)
                .fillMaxSize(1f)

        assertTrue { areModifiersEqual(mod, expectedModifier) }
    }
}

/**
 * Function to compare two Modifier instances for equality.
 *
 * @param modifier1 The first Modifier to compare.
 * @param modifier2 The second Modifier to compare.
 * @return True if the modifiers are equal, false otherwise.
 */
fun areModifiersEqual(
    modifier1: Modifier,
    modifier2: Modifier,
): Boolean {
    val elements1 =
        modifier1.foldIn(mutableListOf<Modifier>()) { acc, element ->
            acc.apply { add(element) }
        }
    val elements2 =
        modifier2.foldIn(mutableListOf<Modifier>()) { acc, element ->
            acc.apply { add(element) }
        }
    return elements1 == elements2
}
