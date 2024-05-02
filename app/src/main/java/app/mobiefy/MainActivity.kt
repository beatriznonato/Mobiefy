package app.mobiefy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.res.painterResource
import app.mobiefy.components.BottomSheet
import app.mobiefy.components.ButtonWithIcon
import app.mobiefy.ui.theme.MobiefyTheme
import app.mobiefy.ui.theme.primary
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
                    ButtonWithIcon(
                        text = "Button",
                        icon = painterResource(id = R.drawable.ic_money_circle),
                        btnColor = primary
                    )
                )
            }
        }
    }
}