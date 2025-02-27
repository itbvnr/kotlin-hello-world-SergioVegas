package cat.itb.m78.exercices.examen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp

val buttonDefaultColor = Color(0xFF74AB7D)

@Composable
fun ShopScreen(navigateToResultatScreen: () -> Unit, viewModel: ShopViewModel){
    ShopScreenView(navigateToResultatScreen, viewModel)
}

@Composable
fun ShopScreenView(navigateToResultatScreen: () -> Unit,viewModel: ShopViewModel){
    var userInput by remember { mutableStateOf("")
    }
    val radioOptions = listOf("Petita(10.0)", "Mitjana(15.0)", "Gran(20.0)")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[0]) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize().background(brush)
    ) {
        TextField(
            value = userInput,
            onValueChange = { userInput = it }
        )

        Spacer(modifier = Modifier.padding(10.dp))

            Column(horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,) {
                    Row(
                        Modifier
                            .height(56.dp)
                            .selectable(
                                selected = (radioOptions[0] == selectedOption),
                                onClick = { onOptionSelected(radioOptions[0]) },
                                role = Role.RadioButton
                            )
                            .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = (radioOptions[0] == selectedOption),
                            onClick = {   viewModel.priceSmallOperation(userInput.toInt())}

                        )
                        Text(
                            text = radioOptions[0],
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.padding(start = 16.dp)
                        )

                    }
            }
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,) {
            Row(
                Modifier
                    .height(56.dp)
                    .selectable(
                        selected = (radioOptions[1] == selectedOption),
                        onClick = { onOptionSelected(radioOptions[1]) },
                        role = Role.RadioButton
                    )
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = (radioOptions[1] == selectedOption),
                    onClick = {   viewModel.priceMediumOperations(userInput.toInt()) },

                )
                Text(
                    text = radioOptions[1],
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(start = 16.dp)
                )

            }
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,) {
            Row(
                Modifier
                    .height(56.dp)
                    .selectable(
                        selected = (radioOptions[2] == selectedOption),
                        onClick = { onOptionSelected(radioOptions[2]) },
                        role = Role.RadioButton
                    )
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = (radioOptions[2] == selectedOption),
                    onClick = {   viewModel.priceLargeOperations(userInput.toInt()) },

                )
                Text(
                    text = radioOptions[2],
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(start = 16.dp)
                )

            }
        }
        Text(
            text = "Numero de samarretes " + userInput,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(start = 16.dp)
        )
        Text(
            text = "Preu de les samarretas " + viewModel.savedNumber,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(start = 16.dp)
        )
        Text(
            text = "Talla seleccionada " + selectedOption,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(start = 16.dp)
        )




                Button(
                    onClick = { navigateToResultatScreen()},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = buttonDefaultColor,
                        contentColor = Color.Black
                    )
                ){
                    Text("Comanda")
                }
        }

    }


