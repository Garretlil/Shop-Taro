package com.example.shop_taro.Model
import com.example.shop_taro.R
import javax.inject.Singleton

data class Product(
    var id:Int,
    var name:String,
    val description:String,
    val imageResource:Int,
    val price:Int,
    val old_price:Int,
    val amount:Int=0
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
        this.listOfProducts.add(Product(1,"Taro cards", "...",R.drawable.taro,10000,old_price = -1))
        this.listOfProducts.add(Product(2,"Taro circle","...",  R.drawable.taro2,12000,old_price = -1))
        this.listOfProducts.add(Product(3,"SpeedTail", "...", R.drawable.mclarenspeed,13000,old_price = -1))
        this.listOfProducts.add(Product(4,"Lotus",  "...",R.drawable.lotus2,14000,old_price = -1))
        this.listOfProducts.add(Product(5,"Centodieci","...",  R.drawable.bugatti,15000,old_price = -1))
    }

//    fun addProductToCart(product:Product) {
//        this.cart.addProductToCart(product)
//    }

}

