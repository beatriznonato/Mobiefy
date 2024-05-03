package app.mobiefy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import app.mobiefy.ui.composables.BottomSheet
import app.mobiefy.ui.screens.mapscreen.MapScreen
import app.mobiefy.ui.theme.MobiefyTheme

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