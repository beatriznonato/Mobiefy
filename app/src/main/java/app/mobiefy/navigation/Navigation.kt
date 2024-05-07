package app.mobiefy.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import app.mobiefy.ui.screens.homescreen.HomeScreen
import app.mobiefy.ui.screens.loginscreen.LoginScreen
import app.mobiefy.ui.screens.signupscreen.SignUpScreen
import app.mobiefy.ui.screens.signupscreen.SignUpViewModel
import app.mobiefy.ui.screens.welcomescreen.WelcomeScreen
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val keyboardController = LocalSoftwareKeyboardController.current

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
            val viewModel = koinViewModel<SignUpViewModel>()
            val uiState by viewModel.uiState.collectAsState()
            val scope = rememberCoroutineScope()

            SignUpScreen(
                uiState = uiState,
                navController = navController,
                onSignUpClick = {
                    keyboardController?.hide()
                    scope.launch {
                        viewModel.signUp()
                    }
                }
            )
        }
        composable(Routes.Home.route) {
            HomeScreen(navController = navController)
        }
    }
}