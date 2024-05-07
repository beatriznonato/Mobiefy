package app.mobiefy.di

import app.mobiefy.authentication.FirebaseAuthRepository
import app.mobiefy.ui.screens.signupscreen.SignUpViewModel
import app.mobiefy.ui.screens.loginscreen.LoginViewModel
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val appModule = module {
    viewModelOf(::SignUpViewModel)
    viewModelOf(::LoginViewModel)
}

val storageModule = module {
    singleOf(::FirebaseAuthRepository)
}

val firebaseModule = module {
    single { Firebase.auth }
}