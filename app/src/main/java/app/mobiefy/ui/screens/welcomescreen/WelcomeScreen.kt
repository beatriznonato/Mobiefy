package app.mobiefy.ui.screens.welcomescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import app.mobiefy.R
import app.mobiefy.navigation.Routes
import app.mobiefy.ui.composables.ButtonDefault
import app.mobiefy.ui.theme.primary
import app.mobiefy.ui.theme.secondary
import app.mobiefy.ui.theme.white

@Composable
fun WelcomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .background(primary)
            .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.fillMaxHeight(0.075f),)
        Image(
            painter = painterResource(id = R.drawable.welcome),
            contentDescription = "Welcome background screen",

            modifier = Modifier
//                .fillMaxWidth()
                .widthIn(max = 300.dp)
        )
        Spacer(modifier = Modifier.height(46.dp))
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(horizontal = 27.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy((-15).dp)) {
                Text(
                    text = "Bem vindo",
                    fontSize = 47.sp,
                    textAlign = TextAlign.Center,
                    letterSpacing = 0.47.sp,
                    fontFamily = FontFamily(Font(R.font.righteous)),
                    color = white
                )
                Row {
                    Text(
                        text = "ao",
                        fontSize = 47.sp,
                        textAlign = TextAlign.Center,
                        letterSpacing = 0.47.sp,
                        fontFamily = FontFamily(Font(R.font.righteous)),
                        color = white
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "Mobiefy",
                        fontSize = 47.sp,
                        textAlign = TextAlign.Center,
                        letterSpacing = 0.47.sp,
                        fontFamily = FontFamily(Font(R.font.righteous)),
                        color = secondary
                    )
                }
            }
            Spacer(modifier = Modifier.height(38.dp))
            Text(
                text = "Desbloqueando viagens inteligentes com seu passaporte de mobilidade eficiente!",
                fontSize = 17.sp,
                color = white,
                textAlign = TextAlign.Center,
                modifier = Modifier.widthIn(max = 330.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            ButtonDefault(
                text = "Começar",
                btnColor = secondary,
                textColor = primary,
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    navController.navigate(Routes.SignUp.route)
                }
            )
            Spacer(modifier = Modifier.height(15.dp))
            Row {
                Text(
                    text = "Já tem uma conta?",
                    fontSize = 17.sp,
                    textAlign = TextAlign.Center,
                    letterSpacing = 0.47.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_regular)),
                    color = white
                )
                Spacer(modifier = Modifier.width(5.dp))
                ClickableText(
                    text = AnnotatedString("Faça login"),
                    style = TextStyle(
                        fontSize = 17.sp,
                        textAlign = TextAlign.Center,
                        letterSpacing = 0.47.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_bold)),
                        color = secondary,
                    ),
                    onClick = {
                        navController.navigate(Routes.Login.route)
                    }
                )
            }
            Spacer(modifier = Modifier.height(85.dp))
        }
    }
}