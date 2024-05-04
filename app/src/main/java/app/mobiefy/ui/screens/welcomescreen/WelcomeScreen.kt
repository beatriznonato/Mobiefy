package app.mobiefy.ui.screens.welcomescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import app.mobiefy.R
import app.mobiefy.data.Routes
import app.mobiefy.ui.composables.ButtonDefault
import app.mobiefy.ui.theme.primary
import app.mobiefy.ui.theme.white

@Composable
fun WelcomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .background(white)
            .fillMaxHeight()
    ) {
        Image(
            painter = painterResource(id = R.drawable.bk_welcome_screen),
            contentDescription = "Welcome background screen",
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(46.dp))
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(horizontal = 27.dp), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Bem vindo ao",
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.righteous)),
                    color = primary
                )
                Text(
                    text = "Mobiefy",
                    fontSize = 36.sp,
                    fontFamily = FontFamily(Font(R.font.righteous)),
                    color = primary
                )
            }
            Spacer(modifier = Modifier.height(38.dp))
            Text(
                text = "Desbloqueando viagens inteligentes com seu passaporte de mobilidade eficiente!",
                fontSize = 16.sp,
                color = primary,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.weight(1f))
            ButtonDefault(
                text = "Começar",
                btnColor = primary,
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    navController.navigate(Routes.Login.route)
                }
            )
            Spacer(modifier = Modifier.height(53.dp))
        }
    }
}