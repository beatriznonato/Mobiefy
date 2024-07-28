package app.mobiefy.navigation

sealed class Routes(val route: String) {
    object Welcome : Routes("welcome")
    object Login : Routes("login")
    object SignUp : Routes("signup")
    object Home : Routes("home")
    object Success : Routes("success")
}