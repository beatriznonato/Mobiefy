package app.mobiefy.data

//sealed class Routes(val route: String) {
//    object WelcomeScreen : Routes("welcome")
//    object LoginScreen : Routes("login")
//}

enum class Screen {
    WELCOME,
    LOGIN,
}
sealed class Routes(val route: String) {
    object Welcome : Routes(Screen.WELCOME.name)
    object Login : Routes(Screen.LOGIN.name)
}