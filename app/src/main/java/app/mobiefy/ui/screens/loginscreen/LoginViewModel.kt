package app.mobiefy.ui.screens.loginscreen

import android.util.Log
import androidx.lifecycle.ViewModel
import app.mobiefy.authentication.FirebaseAuthRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel(
    private val firebaseAuthRepository: FirebaseAuthRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(LoginState())
    val uiState = _uiState.asStateFlow()

    private val _signInIsSuccessful = MutableSharedFlow<Boolean>()

    init {
        _uiState.update { currentState ->
            currentState.copy(
                onEmailChange = { email ->
                    _uiState.update {
                        it.copy(email = email)
                    }
                },
                onPasswordChange = { password ->
                    _uiState.update {
                        it.copy(password = password)
                    }
                }
            )
        }
    }

    suspend fun login() {
        try {
            _uiState.update { it.copy(loading = true) }
            firebaseAuthRepository
                .login(
                    _uiState.value.email,
                    _uiState.value.password
                )
            _signInIsSuccessful.emit(true)
            _uiState.update { it.copy(success = true) }
        } catch (e: Exception) {
            Log.e("LoginViewModel", "login: ", e)
            _uiState.update {
                it.copy(
                    error = "Falha na autenticação",
                    success = false
                )
            }
        } finally {
            _uiState.update { it.copy(loading = false) }
        }
    }
}