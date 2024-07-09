package com.example.shop_taro.Model
import com.example.shop_taro.R
import javax.inject.Singleton

data class Product(
    var name:String,
    var price:Int,
    val imageResource:Int,
    val id:Int
    )

class Catalog() {
    private val listOfProducts: MutableList<Product> = mutableListOf()
    init{
        getAllProductsFromDB()
    }
    fun getAllProducts(): MutableList<Product> {
        return listOfProducts
    }
    fun getAllProductsFromDB() {
        this.listOfProducts.add(Product("Taro cards", 10000, R.drawable.taro,1))
        this.listOfProducts.add(Product("Taro circle", 12000, R.drawable.taro2,2))
        this.listOfProducts.add(Product("SpeedTail", 13000, R.drawable.mclarenspeed,3))
        this.listOfProducts.add(Product("Lotus", 14000, R.drawable.lotus2,4))
        this.listOfProducts.add(Product("Centodieci", 15000, R.drawable.bugatti,5))
    }

//    fun addProductToCart(product:Product) {
//        this.cart.addProductToCart(product)
//    }

}

