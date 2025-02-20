package xyz.malefic.compose.style

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlin.test.Test
import kotlin.test.assertEquals

class MaleficStyleTest {
    @Test
    fun test() {
        val mod =
            malefic {
                padding = 15.dp to 16.dp to 16.dp to 16.dp
                background = Color.Blue to CircleShape
                border = 2.dp to Color.Red
                width = 100.dp
                height = 50.dp
            }
        val expectedModifier =
            Modifier
                .padding(15.dp, 16.dp, 16.dp, 16.dp)
                .background(Color.Blue, CircleShape)
                .border(2.dp, Color.Red)
                .width(100.dp)
                .height(50.dp)

        assertEquals(expectedModifier, mod)
    }
}
