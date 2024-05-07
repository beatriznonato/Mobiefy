package app.mobiefy.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowRight
import androidx.compose.material.icons.rounded.DirectionsBus
import androidx.compose.material.icons.rounded.DirectionsWalk
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.mobiefy.R
import app.mobiefy.ui.theme.black
import app.mobiefy.ui.theme.divider
import app.mobiefy.ui.theme.primary
import app.mobiefy.ui.theme.secondary
import app.mobiefy.ui.theme.white

@Preview
@Composable
fun RouteListItem() {
    Box(modifier = Modifier.fillMaxWidth()) {
        Column {
Spacer(modifier = Modifier.height(20.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Row(verticalAlignment = Alignment.Bottom) {
                    Icon(
                        imageVector = Icons.Rounded.DirectionsWalk,
                        contentDescription = "Walk",
                        tint = primary,
                        modifier = Modifier.size(30.dp)
                    )
                    Text(
                        text = "3",
                        color = primary,
                        fontSize = 15.sp,
                    )
                }
                Icon(
                    imageVector = Icons.Rounded.ArrowRight,
                    contentDescription = "ArrowRight",
                    tint = primary,
                    modifier = Modifier.size(30.dp)
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                        .background(primary)
                        .padding(horizontal = 4.dp, vertical = 2.dp)
                ) {
                    Icon(
                        imageVector = Icons.Rounded.DirectionsBus,
                        contentDescription = "Bus",
                        tint = white,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "6262-10", color = white, fontSize = 18.sp)
                    Spacer(modifier = Modifier.width(2.dp))
                }

            }
            Spacer(modifier = Modifier.height(7.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Row(verticalAlignment = Alignment.Bottom) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_signal),
                        contentDescription = "Signal",
                        modifier = Modifier.padding(bottom = 3.dp),
                        tint = secondary
                    )
                    Spacer(modifier = Modifier.width(7.dp))
                    Text(
                        text = "Em 6, 26, 46 min de Getúlio Vargas C/...",
                        color = black,
                        fontSize = 15.sp
                    )
                }
            }
            Divider(thickness = 1.dp, color = divider, modifier = Modifier.padding(top = 20.dp))
        }
    }
}















