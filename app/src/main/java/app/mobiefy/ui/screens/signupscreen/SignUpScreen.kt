package app.mobiefy.ui.screens.signupscreen

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import app.mobiefy.R
import app.mobiefy.navigation.Routes
import app.mobiefy.ui.composables.ButtonDefault
import app.mobiefy.ui.theme.black
import app.mobiefy.ui.theme.primary
import app.mobiefy.ui.theme.secondary
import app.mobiefy.ui.theme.tertiary
import app.mobiefy.ui.theme.white
import kotlinx.coroutines.launch

@Composable
fun SignUpScreen(
    navController: NavController,
    viewModel: SignUpViewModel = hiltViewModel()
) {
    var nome by rememberSaveable { mutableStateOf("") }
    var sobrenome by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val state = viewModel.signUpState.collectAsState(initial = null)
    var isDialogOpen by remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(horizontal = 27.dp)) {
        Spacer(modifier = Modifier.height(100.dp))
        Text(
            text = "Mobiefy",
            fontSize = 37.sp,
            fontFamily = FontFamily(Font(R.font.righteous)),
            color = primary
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(text = "Cadastre-se para desbloquear rotas inteligentes!", fontSize = 16.sp)
        Spacer(modifier = Modifier.height(35.dp))
        Column {
            Column {
                Text(text = "Nome", fontSize = 16.sp)
                Spacer(modifier = Modifier.height(10.dp))
                TextField(
                    value = nome,
                    placeholder = {Text(text = "Maria")},
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    onValueChange = { nome = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(18.dp)),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = tertiary,
                        unfocusedContainerColor = tertiary,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                )
            }
            Spacer(modifier = Modifier.height(30.dp))
            Column {
                Text(text = "Sobrenome", fontSize = 16.sp)
                Spacer(modifier = Modifier.height(10.dp))
                TextField(
                    value = sobrenome,
                    placeholder = {Text(text = "Silva")},
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    onValueChange = { sobrenome = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(18.dp)),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = tertiary,
                        unfocusedContainerColor = tertiary,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                )
            }
            Spacer(modifier = Modifier.height(30.dp))
            Column {
                Text(text = "E-mail", fontSize = 16.sp)
                Spacer(modifier = Modifier.height(10.dp))
                TextField(
                    value = email,
                    placeholder = {Text(text = "email@exemplo.com")},
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    onValueChange = { email = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(18.dp)),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = tertiary,
                        unfocusedContainerColor = tertiary,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                )
            }
            Spacer(modifier = Modifier.height(30.dp))
            Column {
                Text(text = "Senha", fontSize = 16.sp)
                Spacer(modifier = Modifier.height(10.dp))
                TextField(
                    value = password,
                    placeholder = {Text(text = "Entre 8 e 20 caracteres")},
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    visualTransformation =  PasswordVisualTransformation(),
                    onValueChange = { password = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(18.dp)),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = tertiary,
                        unfocusedContainerColor = tertiary,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                )
            }
            Spacer(modifier = Modifier.height(30.dp))
            ButtonDefault(
                text = "Cadastrar",
                btnColor = primary,
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    isDialogOpen = true
//                    scope.launch {
//                        viewModel.signUpUser(email, password)
//                    }
                }
            )
            Row(modifier = Modifier.fillMaxWidth()) {
                if (state.value?.isLoading == true) {
                    CircularProgressIndicator()
                }
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "Já tem uma conta?", fontSize = 16.sp)
            Spacer(modifier = Modifier.width(5.dp))
            ClickableText(
                text = AnnotatedString("Faça login"), onClick = {
                    navController.navigate(Routes.Login.route)
                },
                style = TextStyle(
                    fontSize = 16.sp,
                    color = primary,
                    fontWeight = FontWeight(700)
                )
            )
        }
        Spacer(modifier = Modifier.height(65.dp))
        LaunchedEffect(key1 = state.value?.isSuccess) {
            scope.launch {
                if (state.value?.isSuccess?.isNotEmpty() == true) {
                    val success = state.value?.isSuccess
                    Toast.makeText(context,"${success}", Toast.LENGTH_LONG).show()
                }
            }
        }

        LaunchedEffect(key1 = state.value?.isError) {
            scope.launch {
                if (state.value?.isError?.isNotEmpty() == true) {
                    val error = state.value?.isError
                    Toast.makeText(context,"${error}", Toast.LENGTH_LONG).show()
                }
            }
        }

        if (isDialogOpen) {
            AlertDialog(
                onDismissRequest = { isDialogOpen = false },
                title = { Text("Cadastro Não Disponível") },
                text = { Text("Desculpe, esta funcionalidade estará disponível na próxima release do Mobiefy. \n\nVocê será redirecionado para a tela de login para acessar o app usando as credenciais disponibilizadas.") },

                containerColor = white,
                confirmButton = {
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonColors(
                            containerColor = primary,
                            contentColor = white,
                            disabledContainerColor = white,
                            disabledContentColor = black
                        ),
                        onClick = {
                            isDialogOpen = false
                            navController.navigate(Routes.Login.route)
                        }
                    ) {
                        Text("OK")
                    }
                }
            )
        }
    }
}