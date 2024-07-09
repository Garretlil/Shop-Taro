package com.example.shop_taro.Model


interface IRepository {
    fun getData():MutableList<String>
    fun saveData(s1:String,s2:String)
    fun delDB()
    fun checkLogin(name:String, email:String):Int//name,email ->   <-(1/0) @GET
    fun saveAccount(name:String, email:String):Int// name,email->   <-id_customer @GET
    fun getCatalog():MutableList<Product?>                      // <-listOfProductsFromDB @GET
    fun getOrders(id:Int): MutableList<Order>                    // <-listOfOrders @GET
    fun getCart(){}                       //<-listOfProductsInCart @GET
    fun getNameEmail(){}                     //?
    fun saveCart(){}                          //->listOfProductsInCart @PUT
}
