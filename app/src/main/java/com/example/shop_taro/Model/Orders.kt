package com.example.shop_taro.Model

import javax.inject.Singleton


enum class orderStatus(status:String){
    ACCEPTED("оформлен"),DELIVERY("доставка"),OBTAINED("получен")
}

data class Order(var idOrder:Int?=null,
                 var products:MutableList<Product?>,
                 var summa:Int,
                 var status:orderStatus
               )
@Singleton
class Orders(remoteDB_:IRepository,cart_:Cart) {
    private val db:IRepository=remoteDB_
    private var productsInOrder: MutableList<Product?> = mutableListOf()
    //private val catalog:Catalog=catalog_
    private val listOfOrders: MutableList<Order> = mutableListOf()
    var cart:Cart=cart_
    var remoteDB:IRepository=remoteDB_
    init{
        getAllOrdersFromDB()
    }
    fun getAllOrders(): MutableList<Order> {
        return listOfOrders
    }
    fun getAllOrdersFromDB() {
        //this.listOfOrders=db.getOrders(id_customer)
    }
    fun createOrder(){
        var summa:Int=0
        val id:Int=1
        for (i in 0..<this.cart.listOfProducts.count()){
            summa+=this.cart.listOfProducts[i]!!.price
        }
        //получение id заказа
            //...
        val orderList=this.cart.listOfProducts.toMutableList()
        this.listOfOrders.add(Order(-1,products=orderList,summa,orderStatus.ACCEPTED))
        //this.listOfOrders.last().idOrder=remoteDB.make_order(this.listOfOrders.last())
        this.cart.listOfProducts.clear()
    }

}
