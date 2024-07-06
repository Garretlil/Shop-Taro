package com.example.shop_taro.Model


enum class orderStatus{
    ACCEPTED,DELIVERY,OBTAINED
}

data class Order( val idOrder:Int,
                  var products:MutableList<Product?>,
                  var summa:Int,
                  var status:orderStatus
               )

class Orders(cart_:Cart) {
    private val cart:Cart=cart_
    private val listOfOrders: MutableList<Order> = mutableListOf()
    init{
        getAllOrdersFromDB()
    }
    fun getAllOrders(): MutableList<Order> {
        return listOfOrders
    }
    fun getAllOrdersFromDB() {
        this.listOfOrders.add(Order(1,products=cart.listOfProducts,10000,orderStatus.ACCEPTED))
        this.listOfOrders.add(Order(2,products=cart.listOfProducts,21000 ,orderStatus.DELIVERY))
        this.listOfOrders.add(Order(3,products=cart.listOfProducts,22000 ,orderStatus.DELIVERY))
        this.listOfOrders.add(Order(4,products=cart.listOfProducts,23000,orderStatus.OBTAINED))
        this.listOfOrders.add(Order(5,products=cart.listOfProducts,24000 ,orderStatus.OBTAINED))
    }
    fun showOrder(){

    }

}