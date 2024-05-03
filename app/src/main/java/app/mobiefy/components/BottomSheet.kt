package app.mobiefy.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import app.mobiefy.R
import app.mobiefy.data.FavouriteLocation
import app.mobiefy.ui.theme.composables.IconRound
import app.mobiefy.ui.theme.theme.primary
import app.mobiefy.ui.theme.theme.secondary
import app.mobiefy.ui.theme.theme.white

val favLocations = listOf(
    FavouriteLocation(
        title = "Casa",
        icon = R.drawable.ic_home
    ),
    FavouriteLocation(
        title = "Trabalho",
        icon = R.drawable.ic_work
    ),
    FavouriteLocation(
        title = "Vó",
        icon = R.drawable.ic_heart
    ),
    FavouriteLocation(
        title = "Adicionar",
        icon = R.drawable.ic_plus
    )
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(pageContent: Unit) {
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberBottomSheetScaffoldState()

    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetPeekHeight = 150.dp,
        sheetContainerColor = primary,
        sheetDragHandle = { DragBar() },
        sheetContent = {
            BottomSheetContent()
        }) {
        pageContent
    }
}

@Composable
fun BottomSheetContent() {
    Column(modifier = Modifier.padding(horizontal = 23.dp)) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .background(white)
        ) {
            Row {
                Spacer(modifier = Modifier.width(10.dp))
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                    //.padding(horizontal = 23.dp, vertical = 15.dp)
                ) {
                    items(favLocations.size) { index ->
                        FavLocationsBox(index)
                    }
                }
                Spacer(modifier = Modifier.width(10.dp))
            }
        }
        Spacer(modifier = Modifier.height(80.dp))
    }
}

@Composable
fun FavLocationsBox(index: Int) {
    val location = favLocations[index]
    Column {
        Spacer(modifier = Modifier.height(18.dp))
        Box(
            modifier = Modifier
                .padding(horizontal = 10.dp)
        ) {
            IconRound(text = location.title, icon = painterResource(id = location.icon))
        }
        Spacer(modifier = Modifier.height(13.dp))
    }

}

@Composable
fun DragBar() {
    Icon(
        painter = painterResource(id = R.drawable.drag_bar),
        contentDescription = "Drag bar",
        tint = secondary,
        modifier = Modifier
            .padding(vertical = 15.dp)
            .width(80.dp)
            .height(7.dp)
    )
}
