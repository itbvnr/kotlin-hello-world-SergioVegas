package cat.itb.m78.exercices

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
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


/* 1. Necessitarem un classe de dades, per gestionar els acudits *
[{"id":1,"type":"general","setup":"What did the fish say when it hit the wall?","punchline":"Dam."}]
* Conceptes: * Json * Serializable * Classes data */
@Serializable
data class Tree(
    val latitud: Double,val nom_cientific: String, val codi: String, val espai_verd: String, val adreca : String,val catalogacio : String,
)

/*  2. Farem servir un viewModel */
class TreeViewModel() : ViewModel(){ val tree = mutableStateOf<Tree?>(null)

    //3. Actualitzarem el nostre objecte fent servir laAPI
// !!! se ha de lanzar en un hilo a parte
    init{
        viewModelScope.launch(Dispatchers.Default){
            tree.value = TreeApi.list().random()
        }
    }

    fun getAJoke(){viewModelScope.launch(Dispatchers.Default){tree.value = TreeApi.list().random() } }}

/*4. Aquesta és la classe que faservir l'API Conceptes: model OSI/TCP http (get/post) Altres: connect, delete, head, options, put Request/Response http (veure mode programador) del navegdor 1XX Informatiu 2XX Satisfactori 200 ok 3XX Redirecció 301 Moved permanently 4XX Error del client 404 not found 5XX Error delservidor 500 Internal server error */
object TreeApi{
    /* * Atributs */ //Endpoint jokes/goodJockes a https://api.sampleapis.com/
    val url = "https://fp.mateuyabar.com/DAM-M03/UF3/exercicis/files/OD_Arbrat_Zona_BCN.json"
    /* JokesApi embolcalla al client http: client Recordem el model OSI / TCP - Aplicació / Aplicació FTP/IMAP/DNS/HTTP <----Estem aquí - presentació / Aplicació - sessió / Aplicació - transport / Transport TCP/UDP - xarxa / Internet paquets IP - enllaç / Accès 'Tramas' Ethernet - física / Accès UTP-rj45*/
    val client = HttpClient() {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true })
        }
    }

    /* * Funcions */
    /* * Funció list: * crida el màtode get del client passantli la url, y al body de la response * que retorna una llista de Joke * La classe Joke ha decoincidir amb el Json que retornla el servei */
    suspend fun list() = client.get(url).body<List<Joke>>()
}

@Composable
fun TreeCountScreen() {
    val viewModel = viewModel { TreeViewModel() }
    val joke = viewModel.tree.value
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        if (joke != null) {
            Text(joke.setup)
            Text(joke.punchline)

            Button(onClick={viewModel.getAJoke()}){ Text("Get a joke") } } else {
            CircularProgressIndicator()
        }
    }
}