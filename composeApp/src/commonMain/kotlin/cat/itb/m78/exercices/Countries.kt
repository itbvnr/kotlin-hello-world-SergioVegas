package cat.itb.m78.exercices

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class Country(
    val abbreviation: String,val capital: String, val currency: String, val name: String, val phone : String, val population: Int?= null,val media : Media,  val id: Int
)
@Serializable
data class Media(
    val flag : String, val emblem: String,val orthographic : String
)

object CountryApi{
    val url = "https://api.sampleapis.com/countries/countries"
    val client = HttpClient(){
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }
    suspend fun list() = client.get(url).body<List<Country>>()
}
class CountriesViewModel() : ViewModel(){
    val countries = mutableStateOf<List<Country>>(emptyList())

    init{
        viewModelScope.launch(Dispatchers.Default){
            val allCountries = CountryApi.list()
            countries.value = allCountries
        }
    }
}

@Composable
fun CountriesScreen(){
    val viewModel = viewModel { CountriesViewModel() }
    val country = viewModel.countries.value
    CountriesScreen(country)
}
@Composable
fun CountriesScreen(country: List<Country>){
LazyColumn {
    items(country) { countryItem ->
        if (countryItem != null) {

                    Text(countryItem.name)
                    Text(countryItem.capital)
                    AsyncImage(
                        model = countryItem.media.flag,
                        contentDescription = null,
                        modifier = Modifier.size(100.dp)
                    )
                } else {
                    CircularProgressIndicator()
                }
            }
        }
    }
