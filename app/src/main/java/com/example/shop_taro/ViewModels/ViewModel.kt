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
import com.example.shop_taro.Model.Orders
import com.example.shop_taro.Model.Product
import com.example.shop_taro.Model.Profile
import com.example.shop_taro.Model.RetrofitHelper
import com.example.shop_taro.Taro_market
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TSViewModel @Inject constructor(
    application: Application,
     val orders: Orders,
     val remoteDB: IRepository,
     val db: IRepository,
     val catalog: Catalog,
     val profile: Profile
) : AndroidViewModel(application) {

    private val login = Login(remoteDB, db)
    private val auth = Auth(remoteDB, db)
    var currentProduct: Product? = null
    //функции обработчики
    fun onLogin(name:String,email:String):Boolean {
        return login.checkLogin(name,email)
    }
    fun onAuth(name:String, email:String){
        auth.saveDataUser(name,email)
    }
    fun updateCurrentProduct(product:Product?){
        currentProduct=product
    }
    fun addToCart(product:Product?){
        orders.cart.addProductToCart(product)
    }
    fun onChangeName(name:String){
        profile.changeName(name)
    }
    fun onChangeTelephone(telephone:String){
        profile.changeTelephone(telephone)
    }
    fun setProfileData(name:String,email:String){
        profile.changeNameFromDB(name)
    }
    fun createOrder(){
        orders.createOrder()
    }

}











//var cart:Cart=Cart()
//var catalog:Catalog=Catalog(cart)