package com.example.shop_taro

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.example.shop_taro.Model.AppDatabase
import com.example.shop_taro.Model.Auth
import com.example.shop_taro.Model.Cart
import com.example.shop_taro.Model.Catalog
import com.example.shop_taro.Model.IRepository
import com.example.shop_taro.Model.Login
import com.example.shop_taro.Model.Orders
import com.example.shop_taro.Model.Product
import com.example.shop_taro.Model.Profile
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class TSViewModel @Inject constructor (
    application: Application,
    //val wiFiManager: WiFiManager,
    val dbRoom: AppDatabase,
    val remoteDB: IRepository

): AndroidViewModel(application) {
    var cart:Cart= Cart()
    var orders:Orders=Orders(cart)
    var catalog: Catalog = Catalog()

    private var login: Login = Login(dbRoom,remoteDB)
    private var auth: Auth = Auth(dbRoom,remoteDB)

    var currentProduct: Product?=null
    var profile: Profile = Profile(dbRoom)
    init {
        Log.d("MyLog","Start")
    }
    fun onLogin(name:String, email:String):Boolean {
        return login.checkLogin(name,email)
    }
    fun onAuth(name:String, email:String){
        auth.saveDataUser(name,email)
    }
    fun updateCurrentProduct(product: Product?){
        currentProduct=product
    }
    fun addToCart(product: Product?){
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