package com.example.shop_taro.Model
import com.example.shop_taro.R
import javax.inject.Singleton

data class Product(
    var id:Int,
    var name:String,
    val description:String,
    val imageResource:String,
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
    private fun getAllProductsFromDB() {
        //this.listOfProducts=db.getCatalog().catalogList
        this.listOfProducts.add(Product(1,"Taro cards", "...",
            "https://klev.club/uploads/posts/2023-10/1697623509_klev-club-p-risunki-karti-taro-ueita-17.png",10000,old_price = -1))
        this.listOfProducts.add(Product(2,"Taro circle","...",
            "https://klev.club/uploads/posts/2023-10/1697623509_klev-club-p-risunki-karti-taro-ueita-17.png",12000,old_price = -1))
        this.listOfProducts.add(Product(3,"SpeedTail", "...",
            "https://i.pinimg.com/736x/a0/89/d5/a089d553e7748100de222ee426374b90.jpg",13000,old_price = -1))
        this.listOfProducts.add(Product(4,"Lotus",  "...",
            "https://static.abw.by/photos/news_photos/2021/12/03/Lotus%20Evija%202.jpg",14000,old_price = -1))
        this.listOfProducts.add(Product(5,"Koenigsegg","...",
            "https://i.pinimg.com/originals/e3/30/a1/e330a1117568810668978bb2f8793a84.jpg",15000,old_price = -1))
    }
//    fun addProductToCart(product:Product) {
//        this.cart.addProductToCart(product)
//    }

}

