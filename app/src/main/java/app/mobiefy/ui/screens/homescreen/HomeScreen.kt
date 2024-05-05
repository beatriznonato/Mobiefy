package app.mobiefy.ui.screens.homescreen

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import app.mobiefy.ui.composables.BottomSheet
import app.mobiefy.ui.screens.mapscreen.MapScreen

@Composable
fun HomeScreen(navController: NavController){
   BottomSheet(pageContent = MapScreen())
}