package app.mobiefy.data

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import app.mobiefy.ui.screens.loginscreen.LoginScreen
import app.mobiefy.ui.screens.signupscreen.SignUpScreen
import app.mobiefy.ui.screens.welcomescreen.WelcomeScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.Welcome.route
    ) {
        composable(Routes.Welcome.route) {
            WelcomeScreen(navController = navController)
        }
        composable(Routes.Login.route) {
            LoginScreen(navController = navController)
        }
        composable(Routes.SignUp.route) {
            SignUpScreen(navController = navController)
        }
    }
}