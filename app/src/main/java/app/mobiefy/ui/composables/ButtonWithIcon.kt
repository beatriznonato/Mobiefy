package app.mobiefy.ui.composables

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

@Composable
fun ButtonWithIcon(text: String, icon: Painter, btnColor: Color) {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(containerColor = btnColor),
        contentPadding = PaddingValues(horizontal = 15.dp, vertical = 8.dp)
    ) {
        Icon(
            painter = icon,
            contentDescription = "Money",
            modifier = Modifier.size(14.dp),
        )
        Spacer(modifier = Modifier.width(7.dp))
        Text(text = text)
    }
}