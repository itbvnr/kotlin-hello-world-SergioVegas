package cat.itb.m78.exercices

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cat.itb.m78.exercices.theme.AppTheme

@Composable
internal fun AppButton() = AppTheme {

    Box(Modifier.fillMaxSize()) {
        val text = remember { mutableStateOf("Good ?!") }
        Column(horizontalAlignment = Alignment.CenterHorizontally)
        {   Text(text.value)

            Button( onClick = {text.value = "Good Morning" }) { Text("Morning") }

            Button(onClick = {text.value = "Good Night" }) { Text("Night") }
        }
    }
}

