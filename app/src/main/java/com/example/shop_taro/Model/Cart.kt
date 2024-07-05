package com.example.shop_taro.Model


class Cart() {
    private val listOfProducts: MutableList<Product?> = mutableListOf()
    fun getListOfProducts(): MutableList<Product?> {
        return listOfProducts
    }
    fun addProductToCart(product: Product?){
        this.listOfProducts.add(product)
    }
}