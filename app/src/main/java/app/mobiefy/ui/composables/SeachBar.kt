package app.mobiefy.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.mobiefy.R
import app.mobiefy.ui.theme.black
import app.mobiefy.ui.theme.secondary
import app.mobiefy.ui.theme.white

@Preview
@Composable
fun CustomSearchBar() {
    var searchText by remember { mutableStateOf("") }
    var isDialogOpen by remember { mutableStateOf(false) }

    val keyboardController = LocalSoftwareKeyboardController.current

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(13.dp))
            .background(white)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.width(23.dp))
            Icon(
                modifier = Modifier.size(20.dp),
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "Search Icon",
            )
            Column {
                TextField(
                    placeholder = { Text(text = "Buscar") },
                    value = searchText,
                    onValueChange = { searchText = it },
                    modifier = Modifier
                        .fillMaxWidth(),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            // Show the dialog when the 'Done' action is triggered (e.g., 'Enter' key)
                            isDialogOpen = true
                            // Hide the keyboard
                            keyboardController?.hide()
                        }
                    ),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = white,
                        unfocusedContainerColor = white,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                )

                if (isDialogOpen) {
                    AlertDialog(
                        onDismissRequest = { isDialogOpen = false },
                        title = { Text("Busca Não Disponível") },
                        text = { Text("Desculpe, esta funcionalidade estará disponível na próxima release do Mobiefy.") },
                        containerColor = white,
                        confirmButton = {
                            Button(
                                modifier = Modifier.fillMaxWidth(),
                                colors = ButtonColors(
                                    containerColor = secondary,
                                    contentColor = white,
                                    disabledContainerColor = white,
                                    disabledContentColor = black
                                ),
                                onClick = {
                                    isDialogOpen = false
                                }
                            ) {
                                Text("OK")
                            }
                        }
                    )
                }
            }
        }
    }
}