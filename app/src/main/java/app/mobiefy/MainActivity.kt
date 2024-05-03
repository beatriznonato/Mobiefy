package app.mobiefy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.res.painterResource
import app.mobiefy.components.BottomSheet
import app.mobiefy.ui.theme.composables.ButtonWithIcon
import app.mobiefy.ui.theme.screens.mapscreen.MapScreen
import app.mobiefy.ui.theme.theme.MobiefyTheme
import app.mobiefy.ui.theme.theme.primary
import org.w3c.dom.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(
                android.graphics.Color.TRANSPARENT,
                android.graphics.Color.TRANSPARENT
            )
        )
        super.onCreate(savedInstanceState)
        setContent {
            MobiefyTheme {
                BottomSheet(
                    MapScreen()
                )
            }
        }
    }
}