package app.mobiefy.data

sealed class Routes(val route: String) {
    object Welcome : Routes("welcome")
    object Login : Routes("login")
}