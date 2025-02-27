package cat.itb.m78.exercices

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class Cuadrado (val altura: Double, val ancho: Double )

fun main(){
    val rectangulo = Cuadrado(10.0, 15.2)
    val serializer = Json{
        ignoreUnknownKeys = true
    }
    val rectanlge =serializer.decodeFromString<Cuadrado>("""{"altura":10.0, "ancho":15.0}""")
    val json =Json.encodeToString(rectangulo)
    val json2 = Json.decodeFromString<Cuadrado>(json)

    println("json: $json")
}