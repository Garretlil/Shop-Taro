package com.example.shop_taro

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

 data class Card(
    var name:String,
    var price:String,
    val imageResource:Int,
     val id:Int
    )

class ListCards() {
    private val listOfCards: MutableList<Card> = mutableListOf()

    init {
        listOfCards.add(Card("Taro1", "10 000 ₽", R.drawable.taro,1))
        listOfCards.add(Card("Taro2", "12 000 ₽", R.drawable.taro,2))
        listOfCards.add(Card("Taro3", "13 000 ₽", R.drawable.taro,3))
        listOfCards.add(Card("Taro4", "14 000 ₽", R.drawable.taro,4))
        listOfCards.add(Card("Taro5", "15 000 ₽", R.drawable.taro,5))
    }
    fun getListOfCards(): MutableList<Card> {
        return listOfCards
    }
}
class Busket() {
    private val listOfCards: MutableList<Card> = mutableListOf()
    init{
        val t=5
    }
    fun getListOfCards(): MutableList<Card> {
        return listOfCards
    }
    fun adds(card:Card){
        this.listOfCards.add(card)
    }
}