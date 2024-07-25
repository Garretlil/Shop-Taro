package com.example.shop_taro.Model


class Cart() {
     val listOfProducts: MutableList<Product> = mutableListOf()
    fun getListOfProductsFromCart(): MutableList<Product> {
        return listOfProducts
    }
    fun addProductToCart(product: Product){
        listOfProducts.add(product)
    }
}


