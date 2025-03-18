package cat.itb.m78.exercices

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class Joke(
    val id: Int,val type: String, val setup: String, val punchline: String
)

object JokesApi{
    val url = "https://api.sampleapis.com/jokes/goodJokes"
    val client = HttpClient(){
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }
    suspend fun list() = client.get(url).body<List<Joke>>()
}

class JokesViewModel() : ViewModel(){
    val joke = mutableStateOf<Joke?>(null)

    init{
        viewModelScope.launch(Dispatchers.Default){
            joke.value = JokesApi.list().random()
        }
    }
}

@Composable
fun JokesScreen(){
    val viewModel = viewModel { JokesViewModel() }
    val joke = viewModel.joke.value
    JokesScreen(joke)
}

@Composable
fun JokesScreen(joke: Joke?){

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        if(joke!=null){
            Text(joke.setup)
            Text(joke.punchline)
        } else {
            CircularProgressIndicator()
        }

    }

}