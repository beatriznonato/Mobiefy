package app.mobiefy.ui.screens.loginscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.mobiefy.data.AuthRepository
import app.mobiefy.shared.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: AuthRepository
): ViewModel() {
    val _loginState = Channel<LoginState>()
    val loginState = _loginState.receiveAsFlow()

    fun loginUser(email: String, password: String) = viewModelScope.launch {
        repository.loginUser(email, password).collect{result ->
            when(result) {
                is Resource.Success ->{
                    _loginState.send(LoginState(isSuccess = "Login foi realizado!"))
                }
                is Resource.Loading->{
                    _loginState.send(LoginState(isLoading = true))
                }
                is Resource.Error ->{
                    _loginState.send(LoginState(isError = result.message))
                }
            }
        }
    }
}