package app.mobiefy.ui.theme.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.mobiefy.ui.theme.theme.primary
import app.mobiefy.ui.theme.theme.secondary
import app.mobiefy.ui.theme.theme.white

@Composable
fun IconSquare(text: String, icon: ImageVector) {
    var isActive by remember {
        mutableStateOf(false)
    }

    var backgroundColor by remember {
        mutableStateOf(white)
    }

    var iconColor by remember {
        mutableStateOf(primary)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(15.dp))
                .background(backgroundColor)
                .width(65.dp)
                .height(65.dp)
                .clickable {
                    isActive = !isActive
                    backgroundColor = if (isActive) {
                        secondary
                    } else {
                        white
                    }

                    iconColor = if (isActive) {
                        white
                    } else {
                        primary
                    }

                },
            contentAlignment = Alignment.Center,
        ) {
            Icon(imageVector = icon, contentDescription = "Search", tint = iconColor, modifier = Modifier.size(32.dp))
        }
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = text, color = white, fontSize = 18.sp)
    }
}