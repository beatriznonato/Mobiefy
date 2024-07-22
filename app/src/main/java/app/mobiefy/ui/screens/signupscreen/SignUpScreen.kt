package app.mobiefy.ui.screens.signupscreen

import android.util.Patterns
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import app.mobiefy.R
import app.mobiefy.navigation.Routes
import app.mobiefy.ui.composables.ButtonDefault
import app.mobiefy.ui.theme.primary
import app.mobiefy.ui.theme.secondary
import app.mobiefy.ui.theme.tertiary

@Composable
fun SignUpScreen(
    uiState: SignUpState,
    navController: NavController,
    onSignUpClick: () -> Unit,
) {

    var name by remember { mutableStateOf("") }
    var surname by remember { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(false) }

    LazyColumn() {
        item {
            Column(modifier = Modifier.padding(horizontal = 27.dp)) {
                Spacer(modifier = Modifier.height(80.dp))
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
                            value = name,
                            placeholder = { Text(text = "Maria") },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                            onValueChange = { name = it },
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
                        AnimatedVisibility(visible = name.isEmpty()) {
                            uiState.error?.let {
                                Text(
                                    text = "Campo obrigatório.",
                                    color = Color.Red,
                                    fontSize = 14.sp,
                                )
                            }

                        }
                    }
                    Spacer(modifier = Modifier.height(30.dp))
                    Column {
                        Text(text = "Sobrenome", fontSize = 16.sp)
                        Spacer(modifier = Modifier.height(10.dp))
                        TextField(
                            value = surname,
                            placeholder = { Text(text = "Silva") },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                            onValueChange = { surname = it },
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
                        AnimatedVisibility(visible = surname.isEmpty()) {
                            uiState.error?.let {
                                Text(
                                    text = "Campo obrigatório.",
                                    color = Color.Red,
                                    fontSize = 14.sp,
                                )
                            }

                        }
                    }
                    Spacer(modifier = Modifier.height(30.dp))
                    Column {
                        Text(text = "E-mail", fontSize = 16.sp)
                        Spacer(modifier = Modifier.height(10.dp))
                        TextField(
                            value = uiState.email,
                            onValueChange = uiState.onEmailChange,
                            placeholder = { Text(text = "email@exemplo.com") },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
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
                        EmailErrorMessage(uiState = uiState)
                    }
                    Spacer(modifier = Modifier.height(30.dp))
                    Column {
                        Text(text = "Senha", fontSize = 16.sp)
                        Spacer(modifier = Modifier.height(10.dp))
                        TextField(
                            value = uiState.password,
                            onValueChange = uiState.onPasswordChange,
                            placeholder = { Text(text = "uma senha forte") },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(18.dp)),
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = tertiary,
                                unfocusedContainerColor = tertiary,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent
                            ),
                            trailingIcon = {
                                IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                                    Icon(
                                        imageVector = if (isPasswordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                                        contentDescription = "Toggle password visibility"
                                    )
                                }
                            },
                            visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation()
                        )
                        PasswordErrorMessage(uiState = uiState)
                    }
                    Spacer(modifier = Modifier.height(30.dp))

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        if (uiState.loading) {
                            CircularProgressIndicator(
                                color = primary,
                                modifier = Modifier.size(56.dp),
                                strokeWidth = 6.dp
                            )
                        } else {
                            ButtonDefault(
                                text = "Cadastrar",
                                btnColor = primary,
                                textColor = secondary,
                                modifier = Modifier.fillMaxWidth(),
                                enabled = name.isNotEmpty() && surname.isNotEmpty(),
                                onClick = onSignUpClick
                            )
                        }

                        if (uiState.success) {
                            navController.navigate(Routes.Login.route)
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                    }
                }
            }
        }
    }
    Column() {
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
    }
}

fun isEmailValid(email: String): Boolean {
    return Patterns.EMAIL_ADDRESS.matcher(email).matches()
}

fun isPasswordValid(password: String): Any {
    // Check if password is at least 8 characters long
    if (password.length < 8) {
        return "length"
    }

    // Check if password contains at least one uppercase letter
    if (!password.any { it.isUpperCase() }) {
        return "uppercase"
    }

    // Check if password contains at least one lowercase letter
    if (!password.any { it.isLowerCase() }) {
        return "lowercase"
    }

    // Check if password contains at least one digit
    if (!password.any { it.isDigit() }) {
        return "digit"
    }

    // Check if password contains at least one special character (symbol)
    val specialCharacters = setOf(
        '!',
        '@',
        '#',
        '$',
        '%',
        '^',
        '&',
        '*',
        '(',
        ')',
        '-',
        '_',
        '=',
        '+',
        '[',
        ']',
        '{',
        '}',
        '|',
        '\\',
        ';',
        ':',
        '\'',
        '"',
        '<',
        '>',
        ',',
        '.',
        '/',
        '?'
    )
    if (!password.any { specialCharacters.contains(it) }) {
        return "character"
    }

    // If all checks pass, return true
    return "correct"
}

@Composable
fun EmailErrorMessage(uiState: SignUpState) {
    var message by remember { mutableStateOf("") }
    var visible by remember { mutableStateOf(false) }

    if (!isEmailValid(uiState.email)) {
        message = "E-mail inválido."
        visible = true
    } else {
        visible = false
        message = ""
    }

    AnimatedVisibility(visible = visible) {
        uiState.error?.let {
            Text(
                text = message,
                color = Color.Red,
                fontSize = 14.sp,
            )
        }

    }
}

@Composable
fun PasswordErrorMessage(uiState: SignUpState) {
    var message by remember { mutableStateOf("") }
    var visible by remember { mutableStateOf(false) }

    if (isPasswordValid(uiState.password) === "length") {
        message = "Sua senha deve conter no mínimo 8 caracteres."
        visible = true
    } else if (isPasswordValid(uiState.password) === "uppercase") {
        message = "Sua senha deve conter no mínimo uma letra maiúscula."
        visible = true
    } else if (isPasswordValid(uiState.password) === "lowercase") {
        message = "Sua senha deve conter no mínimo uma letra minúscula."
        visible = true
    } else if (isPasswordValid(uiState.password) === "digit") {
        message = "Sua senha deve conter no mínimo um número."
        visible = true
    } else if (isPasswordValid(uiState.password) === "character") {
        message = "Sua senha deve conter no mínimo um caractere especial."
        visible = true
    } else {
        visible = false
        message = ""
    }

    AnimatedVisibility(visible = visible) {
        uiState.error?.let {
            Text(
                text = message,
                color = Color.Red,
                fontSize = 14.sp,
            )
        }
    }
}