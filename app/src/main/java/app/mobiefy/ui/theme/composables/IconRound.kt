package app.mobiefy.ui.theme.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.mobiefy.ui.theme.theme.black
import app.mobiefy.ui.theme.theme.primary
import app.mobiefy.ui.theme.theme.tertiary

@Composable
fun IconRound(text: String, icon: Painter) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .background(tertiary)
                .width(55.dp)
                .height(55.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(painter = icon, contentDescription = text, tint = primary, modifier = Modifier.size(32.dp))
        }
        Text(text = text, color = black, fontSize = 18.sp)
    }
}