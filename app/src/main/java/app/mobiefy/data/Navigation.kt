package app.mobiefy.data

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import app.mobiefy.ui.screens.loginscreen.LoginScreen
import app.mobiefy.ui.screens.welcomescreen.WelcomeScreen

//@Composable
//fun Navigation(){
//    val navController = rememberNavController()
//    NavHost(navController = navController, startDestination = Routes.Splash.route) {
//        composable(Routes.WelcomeScreen.route) {
//            WelcomeScreen(navController = navController)
//        }
//        composable(Routes.LoginScreen.route) {
//            LoginScreen(navController = navController)
//        }
//
//    }
//}

//@Composable
//fun Navigation(
//    modifier: Modifier = Modifier,
//    navController: NavHostController,
//    startDestination: String = Routes.Splash.route
//) {
//    NavHost(
//        modifier = modifier,
//        navController = navController,
//        startDestination = startDestination
//    ) {
//        composable(Routes.Splash.route) {
//            SplashScreen(navController)
//        }
//        composable(Routes.Login.route) {
//            LoginScreen(navController)
//        }
//    }
//}