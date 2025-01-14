package cat.itb.m78.exercices


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cat.itb.m78.exercices.theme.AppTheme
import androidx.compose.ui.graphics.Color
import org.jetbrains.compose.reload.DevelopmentEntryPoint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import m78exercices.composeapp.generated.resources.MyImage
import m78exercices.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.painterResource



@Composable
internal fun App() = AppTheme {
    Box(Modifier.fillMaxSize()){

        Column(modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
        ){
            Image(
            painter = painterResource(Res.drawable.MyImage),
            modifier = Modifier.size(100.dp).clip(CircleShape),
            contentDescription = null
            )
            Text("Marta Casserres", fontSize = 35.sp, fontWeight = FontWeight.Bold)

            Box(Modifier.background(Color.LightGray, RoundedCornerShape(percent = 10)).padding(20.dp)) {
                Column(modifier = Modifier.align(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text("marta@example.com")
                    Text("934578484")
                }

            }
        }

    }

}
