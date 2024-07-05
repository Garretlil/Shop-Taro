package com.example.shop_taro.ViewModels

import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import com.example.shop_taro.Model.Auth
import com.example.shop_taro.Model.Cart
import com.example.shop_taro.Model.Catalog
import com.example.shop_taro.Model.DatabaseHelper
import com.example.shop_taro.Model.IRepository
import com.example.shop_taro.Model.Login
import com.example.shop_taro.Model.Product

class TSViewModel(application: Application): AndroidViewModel(application){

    var db: IRepository = DatabaseHelper(application)

    private var login:Login=Login(db)
    private var auth:Auth=Auth(db)

    var cart: Cart =Cart()
    var catalog = Catalog(cart)

    var currentProduct: Product?=null


    fun onLogin(name:String,email:String):Boolean {
        return login.checkLogin(name,email)
    }

    fun onAuth(name:String,email:String){
        auth.saveDataUser(name,email)
    }
    fun updateCurrentProduct(product:Product?){
        currentProduct=product
    }
    fun addToCart(product:Product?){
        cart.addProductToCart(product)
    }



}