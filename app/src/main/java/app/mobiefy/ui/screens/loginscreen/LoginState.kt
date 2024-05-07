package app.mobiefy.ui.screens.loginscreen

data class LoginState(
    val loading: Boolean = false,
    val error: String? = null,
    val success: Boolean = false,
    val emailError: String? = null,
    val email: String = "",
    val password: String = "",
    val onEmailChange: (String) -> Unit = {},
    val onPasswordChange: (String) -> Unit = {},
)
