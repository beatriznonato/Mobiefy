package app.mobiefy.ui.composables

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ButtonDefault(text: String, btnColor: Color, modifier: Modifier, enabled: Boolean? = true, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = btnColor),
        contentPadding = PaddingValues(horizontal = 15.dp, vertical = 8.dp),
        enabled = enabled ?: true,
        modifier = modifier
    ) {
        Text(text = text, fontWeight = FontWeight(700), fontSize = 16.sp, modifier = Modifier.padding(vertical = 10.dp))
    }
}