package com.example.shop_taro.Model

import javax.inject.Singleton


enum class orderStatus(status:String){
    ACCEPTED("оформлен"),DELIVERY("доставка"),OBTAINED("получен")
}

data class Order( val idOrder:Int,
                  var products:MutableList<Product?>,
                  var summa:Int,
                  var status:orderStatus
               )
@Singleton
class Orders(cart_:Cart) {
    private var productsInOrder: MutableList<Product?> = mutableListOf()
    //private val catalog:Catalog=catalog_
    private val listOfOrders: MutableList<Order> = mutableListOf()
    var cart:Cart=cart_
    init{
        getAllOrdersFromDB()
    }
    fun getAllOrders(): MutableList<Order> {
        return listOfOrders
    }
    fun getAllOrdersFromDB() {
        //this.listOfOrders.add(Order(1,products=catalog.cart.listOfProducts,18000,orderStatus.ACCEPTED))
    }
    fun createOrder(){
        var summa:Int=0
        for (i in 0..<this.cart.listOfProducts.count()){
            summa+=this.cart.listOfProducts[i]!!.price
        }
        val orderlist=this.cart.listOfProducts.toMutableList()
        this.listOfOrders.add(Order(1,products=orderlist,summa,orderStatus.ACCEPTED))
        this.cart.listOfProducts.clear()
    }


}