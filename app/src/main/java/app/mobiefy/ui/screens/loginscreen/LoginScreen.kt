package app.mobiefy.ui.screens.loginscreen

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
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import app.mobiefy.R
import app.mobiefy.data.Routes
import app.mobiefy.ui.composables.ButtonDefault
import app.mobiefy.ui.theme.primary
import app.mobiefy.ui.theme.tertiary

@Composable
fun LoginScreen(navController: NavController) {
    var email by rememberSaveable { mutableStateOf("") }
    var senha by rememberSaveable { mutableStateOf("") }

    Column(modifier = Modifier.padding(horizontal = 27.dp)) {
        Spacer(modifier = Modifier.height(135.dp))
        Text(
            text = "Mobiefy",
            fontSize = 37.sp,
            fontFamily = FontFamily(Font(R.font.righteous)),
            color = primary
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(text = "Bem vindo de volta!", fontSize = 16.sp)
        Spacer(modifier = Modifier.height(80.dp))
        Column {
            Column {
                Text(text = "E-mail", fontSize = 16.sp)
                Spacer(modifier = Modifier.height(10.dp))
                TextField(
                    value = email,
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
                    value = senha,
                    onValueChange = { senha = it },
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
                text = "Entrar",
                btnColor = primary,
                modifier = Modifier.fillMaxWidth(),
                onClick = {})
        }
        Spacer(modifier = Modifier.weight(1f))
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
                    fontSize = 16.sp,
                    color = primary,
                    fontWeight = FontWeight(700)
                )
            )
        }
        Spacer(modifier = Modifier.height(65.dp))
    }
}