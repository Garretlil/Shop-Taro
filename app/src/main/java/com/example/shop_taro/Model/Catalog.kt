package com.example.shop_taro.Model
import com.example.shop_taro.R
import javax.inject.Singleton

data class Product(
    var name:String,
    var price:String,
    val imageResource:Int,
    val id:Int
    )
@Singleton
class Catalog(var cart:Cart) {
    private val listOfProducts: MutableList<Product> = mutableListOf()
    init{
        getAllProductsFromDB()
    }
    fun getAllProducts(): MutableList<Product> {
        return listOfProducts
    }
    fun getAllProductsFromDB() {
        this.listOfProducts.add(Product("Taro1", "10 000 ₽", R.drawable.taro,1))
        this.listOfProducts.add(Product("Taro2", "12 000 ₽", R.drawable.taro,2))
        this.listOfProducts.add(Product("Taro3", "13 000 ₽", R.drawable.taro,3))
        this.listOfProducts.add(Product("Taro4", "14 000 ₽", R.drawable.taro,4))
        this.listOfProducts.add(Product("Taro5", "15 000 ₽", R.drawable.taro,5))
    }

    fun addProductToCart(product:Product) {
        this.cart.addProductToCart(product)
    }

}

