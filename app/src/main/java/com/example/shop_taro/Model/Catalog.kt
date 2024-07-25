package com.example.shop_taro.Model

data class Product(
    var Id:Int,
    var Name:String,
    val Description:String,
    val ImageResource:String,
    val Price:Int,
    val Old_price:Int,
    val Amount:Int=0
    )

class Catalog(remoteDB_: IRepository) {
    val remoteDB:IRepository=remoteDB_
    private var listOfProducts: MutableList<Product> = mutableListOf()
    init{
        getAllProductsFromDB()
    }
    fun getAllProducts(): MutableList<Product> {
        return listOfProducts
    }
    private fun getAllProductsFromDB() {

        this.listOfProducts=remoteDB.getCatalog().toMutableList()
        //this.listOfProducts=remoteDB.getCatalog()
        this.listOfProducts.add(Product(1,"Taro cards", "...",
            "https://klev.club/uploads/posts/2023-10/1697623509_klev-club-p-risunki-karti-taro-ueita-17.png",10000,Old_price = -1))
        this.listOfProducts.add(Product(2,"Taro circle","...",
            "https://klev.club/uploads/posts/2023-10/1697623509_klev-club-p-risunki-karti-taro-ueita-17.png",12000,Old_price = -1))
        this.listOfProducts.add(Product(3,"SpeedTail", "...",
            "https://i.pinimg.com/736x/a0/89/d5/a089d553e7748100de222ee426374b90.jpg",13000,Old_price = -1))
        this.listOfProducts.add(Product(4,"Lotus",  "...",
            "https://static.abw.by/photos/news_photos/2021/12/03/Lotus%20Evija%202.jpg",14000,Old_price = -1))
        this.listOfProducts.add(Product(5,"Koenigsegg","...",
            "https://i.pinimg.com/originals/e3/30/a1/e330a1117568810668978bb2f8793a84.jpg",15000,Old_price = -1))
    }
//    fun addProductToCart(product:Product) {
//        this.cart.addProductToCart(product)
//    }

}

