package app.mobiefy.ui.screens.signupscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Text
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import app.mobiefy.R
import app.mobiefy.ui.composables.ButtonDefault
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.ui.Alignment
import app.mobiefy.navigation.Routes
import app.mobiefy.ui.theme.primary
import app.mobiefy.ui.theme.white

@Composable
fun SuccessScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .padding(38.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(41.dp)
    ){
        Spacer(modifier = Modifier.fillMaxHeight(0.071f),)
        Image(
            painter = painterResource(id = R.drawable.success),
            contentDescription = "Success background screen",

            modifier = Modifier
                .widthIn(max = 300.dp)
        )
        Text(
            text = "Cadastro realizado com sucesso!",
            fontSize = 47.sp,
            lineHeight = 41.sp,
            textAlign = TextAlign.Center,
            letterSpacing = 0.47.sp,
            fontFamily = FontFamily(Font(R.font.righteous)),
            color = primary
        )
        ButtonDefault(
            text = "Fazer login",
            btnColor = primary,
            textColor = white,
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                navController.navigate(Routes.Login.route)
            }
        )
        Spacer(modifier = Modifier.height(65.dp))
    }
}