package cat.itb.m78.exercices

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cat.itb.m78.exercices.theme.AppTheme
import m78exercices.composeapp.generated.resources.MyImage
import m78exercices.composeapp.generated.resources.Res
import m78exercices.composeapp.generated.resources.tapestry
import m78exercices.composeapp.generated.resources.title
import m78exercices.composeapp.generated.resources.dice_1
import m78exercices.composeapp.generated.resources.dice_2
import m78exercices.composeapp.generated.resources.dice_3
import m78exercices.composeapp.generated.resources.dice_4
import m78exercices.composeapp.generated.resources.dice_5
import m78exercices.composeapp.generated.resources.dice_6

import org.jetbrains.compose.resources.painterResource
import kotlin.random.Random

@Composable
internal fun AppDiceRoller() = AppTheme {

    Box(Modifier.fillMaxSize().background(Color.Black)) {
        var text = remember { mutableStateOf("")}
        var Dice1 by remember{ mutableStateOf (Random.nextInt(0, 6)) }
        var Dice2 by remember{ mutableStateOf (Random.nextInt(0, 6)) }
        val imageDices = listOf(Res.drawable.dice_1, Res.drawable.dice_2, Res.drawable.dice_3, Res.drawable.dice_4, Res.drawable.dice_5,Res.drawable.dice_6)
        Box(Modifier.width(600.dp).height(1000.dp).align(Alignment.Center)) {
            Image(
                painter = painterResource(Res.drawable.tapestry),
                modifier = Modifier.fillMaxSize(),
                contentDescription = null)
            Column(Modifier.align(Alignment.Center), verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally)
            {
                Image(
                    painter = painterResource(Res.drawable.title),
                    modifier = Modifier.width(200.dp).height(200.dp),
                    contentDescription = null)
                Button(onClick =
                {
                    Dice1 = Random.nextInt(0,6)
                    Dice2 = Random.nextInt(0,6)
                }
                )
                { Text("Roll the dice")}

                Row(horizontalArrangement = Arrangement.Center)
                {
                    Image(
                        painter = painterResource(imageDices[Dice1]),
                        modifier = Modifier.width(200.dp).height(200.dp),
                        contentDescription = null
                    )
                    Image(
                        painter = painterResource(imageDices[Dice2]),
                        modifier = Modifier.width(200.dp).height(200.dp),
                        contentDescription = null
                    )
                }
            }
        }
    }

}