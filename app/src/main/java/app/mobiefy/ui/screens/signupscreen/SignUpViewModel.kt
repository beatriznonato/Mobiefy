package app.mobiefy.ui.screens.signupscreen

import android.util.Log
import androidx.lifecycle.ViewModel
import app.mobiefy.authentication.FirebaseAuthRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SignUpViewModel(
    private val firebaseAuthRepository: FirebaseAuthRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(SignUpState())
    val uiState = _uiState.asStateFlow()

    private val _signUpIsSuccessful = MutableSharedFlow<Boolean>()
    val signUpIsSuccessful = _signUpIsSuccessful.asSharedFlow()

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

    suspend fun signUp() {
        try {
            _uiState.update { it.copy(loading = true) }
            firebaseAuthRepository
                .signUp(
                    _uiState.value.email,
                    _uiState.value.password
                )
            _signUpIsSuccessful.emit(true)
            _uiState.update { it.copy(success = true) }
        } catch (e: Exception) {
            Log.e("SignUpViewModel", "signUp: ", e)
            _uiState.update {
                it.copy(
                    error = "Erro ao cadastrar usuario",
                    success = false
                )
            }
        } finally {
            _uiState.update { it.copy(loading = false) }
        }
    }
}