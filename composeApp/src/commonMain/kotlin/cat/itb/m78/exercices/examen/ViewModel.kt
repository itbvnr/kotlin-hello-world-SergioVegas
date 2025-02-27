package cat.itb.m78.exercices.examen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ShopViewModel() : ViewModel() {
    var savedNumber by mutableStateOf(0)
    var savedNumberIva by mutableStateOf(0)
    val priceSmall = mutableStateOf(10)
    val priceMedium = mutableStateOf(15)
    val priceLarge = mutableStateOf(20)


     fun priceSmallOperation(userInput: Int) {
       savedNumber = userInput * priceSmall.value
    }

     fun priceMediumOperations(userInput: Int) {
        savedNumber = userInput * priceMedium.value
    }

     fun priceLargeOperations(userInput: Int) {
        savedNumber = userInput * priceLarge.value
    }
    fun priceIva(userInput: Int) {
        savedNumberIva = savedNumber*21
    }

}
