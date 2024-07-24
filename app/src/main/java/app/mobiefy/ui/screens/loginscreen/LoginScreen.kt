package app.mobiefy.ui.screens.loginscreen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import app.mobiefy.R
import app.mobiefy.navigation.Routes
import app.mobiefy.ui.composables.ButtonDefault
import app.mobiefy.ui.theme.primary
import app.mobiefy.ui.theme.white

@Composable
fun LoginScreen(
    uiState: LoginState,
    navController: NavController,
    onLoginClick: () -> Unit,
) {
    Column(modifier = Modifier.padding(horizontal = 27.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.fillMaxHeight(0.075f),)
        Image(
            painter = painterResource(id = R.drawable.login),
            contentDescription = "Welcome background screen",

            modifier = Modifier
                .widthIn(max = 155.dp)
        )
        Spacer(modifier = Modifier.height(60.dp))
        Text(
            text = "Bem-vindo de volta!",
            fontSize = 32.sp,
            fontFamily = FontFamily(Font(R.font.righteous)),
            lineHeight = 41.sp,
            letterSpacing = 0.29.sp,
            color = primary
        )
        Spacer(modifier = Modifier.height(15.dp))
        Column {
            Column {
                Text(text = "E-mail", fontSize = 17.sp)
                Spacer(modifier = Modifier.height(10.dp))
                TextField(
                    value = uiState.email,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    onValueChange = uiState.onEmailChange,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(18.dp)),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color(0x17322E53),
                        unfocusedContainerColor = Color(0x17322E53),
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                )
            }
            Spacer(modifier = Modifier.height(27.dp))
            Column {
                Text(text = "Senha", fontSize = 17.sp)
                Spacer(modifier = Modifier.height(10.dp))
                TextField(
                    value = uiState.password,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    visualTransformation =  PasswordVisualTransformation(),
                    onValueChange = uiState.onPasswordChange,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(18.dp)),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color(0x17322E53),
                        unfocusedContainerColor = Color(0x17322E53),
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                )
            }
            uiState.error?.let {
                // Show an error message if authentication fails
                AnimatedVisibility(visible = true) {
                    Text(
                        text = "E-mail ou senha inválidos.",
                        color = Color.Red,
                        fontSize = 14.sp,
                    )
                }
            }
            Spacer(modifier = Modifier.weight(1f))
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
                        text = "Entrar",
                        btnColor = primary,
                        textColor = white,
                        modifier = Modifier.fillMaxWidth(),
                        onClick = onLoginClick
                    )
                }
                if (uiState.success) {
                    navController.navigate(Routes.Home.route)
                }
            }
            Spacer(modifier = Modifier.height(15.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "Não tem uma conta?", fontSize = 16.sp)
                Spacer(modifier = Modifier.width(5.dp))
                ClickableText(
                    text = AnnotatedString("Cadastre-se"), onClick = {
                        navController.navigate(Routes.SignUp.route)
                    },
                    style = TextStyle(
                        fontSize = 17.sp,
                        color = primary,
                        fontWeight = FontWeight(700)
                    )
                )
            }
            Spacer(modifier = Modifier.height(65.dp))
        }
    }
}