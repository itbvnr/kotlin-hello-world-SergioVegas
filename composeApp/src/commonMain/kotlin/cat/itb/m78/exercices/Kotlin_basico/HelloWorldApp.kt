package cat.itb.m78.exercices.Kotlin_basico

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color

@Composable
fun HelloWorldApp() {
    Text("Hello World", color = Color.Red, fontSize = 20.sp)
}
