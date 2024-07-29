package app.mobiefy.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.mobiefy.ui.theme.black
import app.mobiefy.ui.theme.primary
import app.mobiefy.ui.theme.white

@Composable
fun IconRound(text: String, icon: Painter) {
    var isDialogOpen by remember { mutableStateOf(false) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { isDialogOpen = true },
            colors = ButtonColors(
                containerColor = Color.Transparent,
                contentColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
                disabledContentColor = Color.Transparent
            ),
            contentPadding = PaddingValues(0.dp)
        ) {
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(primary)
                    .width(55.dp)
                    .height(55.dp),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = icon,
                    contentDescription = text,
                    tint = white,
                    modifier = Modifier.size(25.dp)
                )
            }
        }
        Text(text = text, color = black, fontSize = 14.sp)
    }

    if (isDialogOpen) {
        AlertDialog(
            onDismissRequest = { isDialogOpen = false },
            title = { Text("Funcionalidade Não Disponível") },
            text = { Text("Desculpe, esta funcionalidade estará disponível na próxima release do Mobiefy.") },
            containerColor = white,
            confirmButton = {
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonColors(
                        containerColor = primary,
                        contentColor = white,
                        disabledContainerColor = white,
                        disabledContentColor = black
                    ),
                    onClick = {
                        isDialogOpen = false
                    }
                ) {
                    Text("OK")
                }
            }
        )
    }
}