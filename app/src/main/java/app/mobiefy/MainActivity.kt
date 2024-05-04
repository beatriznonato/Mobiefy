package app.mobiefy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import app.mobiefy.data.Routes
import app.mobiefy.ui.composables.BottomSheet
import app.mobiefy.ui.composables.CustomSearchBar
import app.mobiefy.ui.screens.loginscreen.LoginScreen
import app.mobiefy.ui.screens.mapscreen.MapScreen
import app.mobiefy.ui.screens.welcomescreen.WelcomeScreen
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
//                val navController = rememberNavController()
//                NavHost(
//                    navController = navController,
//                    startDestination = Routes.WelcomeScreen.route
//                ) {
//                    composable(
//                        Routes.WelcomeScreen.route
//                    ) { WelcomeScreen(navController = navController) }
//                    composable(Routes.LoginScreen.route) {
//                        LoginScreen(navController = navController)
//                    }
//                }
            }
        }
    }
}