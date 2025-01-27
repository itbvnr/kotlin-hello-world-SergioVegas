package cat.itb.m78.exercices

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cat.itb.m78.exercices.theme.AppTheme

@Composable
internal fun AppSecretNumber() = AppTheme {

    Box(Modifier.fillMaxSize().background(Color.Black)) {
        //variable que indica si aparece el dialogo
        val showText = remember { mutableStateOf(false)}
        //variable que almacena valor introducido
        val text = remember { mutableStateOf("") }
        //valor a adivinar
        val textoRespuesta = remember { mutableStateOf("") }

        val secretNumber = remember{(0..100).random()}
        // contador de intentos
        val intentos = remember { mutableStateOf(0) }

        Box(Modifier.width(400.dp).height(350.dp).background(Color.White).align(Alignment.Center)) {
            Column(Modifier.align(Alignment.Center), verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally)
            {
                Text("Endevina el número secret")
                Box(
                    Modifier.width(300.dp).height(80.dp).align(Alignment.CenterHorizontally)
                        .border(2.dp, Color.Black, RoundedCornerShape(percent = 10)).padding(10.dp)
                )
                {
                    TextField(value = text.value,
                        onValueChange = {  //cambia el texto que habia al nuevo introducido
                            text.value = it
                        })
                }
        Button(onClick = {
            showText.value = true
            intentos.value = intentos.value + 1
            //******
            if (showText.value) {
                if (text.value.toIntOrNull() == null) {
                    textoRespuesta.value = "Intodueix un numero"
                } else if (text.value.toInt() == secretNumber) {
                    textoRespuesta.value = "Has encertat!"
                } else if (text.value.toInt() > secretNumber) {
                    textoRespuesta.value = "El número que busques és més petit"
                } else {
                    textoRespuesta.value = "El número que busques és més gran"
                }
            }
            //******
            }) {
            Text("Validar")}

        Text("Intents: " + intentos.value.toString())
        Text(textoRespuesta.value)

                }

            }
        }
    }


