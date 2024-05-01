package app.mobiefy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Shuffle
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.mobiefy.components.ButtonWithIcon
import app.mobiefy.components.IconRound
import app.mobiefy.components.IconSquare
import app.mobiefy.components.RouteListItem
import app.mobiefy.ui.theme.MobiefyTheme
import app.mobiefy.ui.theme.secondary
import app.mobiefy.ui.theme.white

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MobiefyTheme {
                ViewIcons()
            }
        }
    }
}

@Preview
@Composable
private fun ViewIcons() {
    val icon = painterResource(id = R.drawable.ic_money_circle)
    //IconRound(text = "Casa", icon = Icons.Rounded.Home)
   Column {
       IconSquare(text = "Misto", icon = Icons.Rounded.Shuffle)
       Spacer(modifier = Modifier.height(30.dp))
       ButtonWithIcon(text = "Pagar", icon = icon, btnColor = secondary)
       Spacer(modifier = Modifier.height(30.dp))
       RouteListItem()
   }
}