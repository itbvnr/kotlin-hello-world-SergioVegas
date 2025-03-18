
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import cat.itb.m78.exercices.CountriesScreen
import cat.itb.m78.exercices.JokesScreen
import cat.itb.m78.exercices.RememberMyNameScreen
import cat.itb.m78.exercices.examen.Shop
import java.awt.Dimension
import org.jetbrains.compose.reload.DevelopmentEntryPoint

fun main() = application {
    Window(
        title = "M78Exercices",
        state = rememberWindowState(width = 450.dp, height = 800.dp),
        onCloseRequest = ::exitApplication,
    ) {
        window.minimumSize = Dimension(350, 600)
        DevelopmentEntryPoint {
            CountriesScreen()
        }
    }
}

