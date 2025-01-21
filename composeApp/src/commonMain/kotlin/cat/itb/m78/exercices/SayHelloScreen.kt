package cat.itb.m78.exercices

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.sp
import m78exercices.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.painterResource

@Composable
internal fun AppScreen() = AppTheme {

    Box(Modifier.fillMaxSize().background(Color.Black)) {
        val showDialog = remember { mutableStateOf(false)}
        val text = remember { mutableStateOf(TextFieldValue("")) }

        Box(Modifier.width(400.dp).height(350.dp).background(Color.White).align(Alignment.Center)) {
            Column(Modifier.align(Alignment.Center), verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally)
            {
                Box(Modifier.width(300.dp).height(60.dp).align(Alignment.CenterHorizontally).border(2.dp, Color.Black, RoundedCornerShape(percent = 10)).padding(10.dp))
                {
                    TextField(text.value, onValueChange = {
                        text.value = it
                    })
                }
                Button( onClick = {showDialog.value = true }) { Text("Say Hello") }
            }
            if(showDialog.value) {
                AlertDialog(
                    onDismissRequest={showDialog.value = false},
                    confirmButton ={},
                    text =
                    {
                        Text("HELLO" + text.value)
                    })

            }
        }
    }
}