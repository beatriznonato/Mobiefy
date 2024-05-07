package app.mobiefy.di

import app.mobiefy.authentication.FirebaseAuthRepository
import app.mobiefy.ui.screens.signupscreen.SignUpViewModel
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val appModule = module {
//    viewModelOf(::TaskFormViewModel)
//    viewModelOf(::TasksListViewModel)
//    viewModelOf(::SignInViewModel)
    viewModelOf(::SignUpViewModel)
}

val storageModule = module {
//    singleOf(::TasksRepository)
//    singleOf(::UsersRepository)
//    single {
//        Room.databaseBuilder(
//            androidContext(),
//            MinhasTarefasDatabase::class.java, "minhas-tarefas.db"
//        ).build()
//    }
//    single {
//        get<MinhasTarefasDatabase>().taskDao()
//    }
    singleOf(::FirebaseAuthRepository)
}

val firebaseModule = module {
    single { Firebase.auth }
}