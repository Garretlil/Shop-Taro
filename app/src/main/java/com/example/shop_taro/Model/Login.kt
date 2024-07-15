package com.example.shop_taro.Model

import com.example.shop_taro.ViewModels.TSViewModel


class Login (db_:IRepository,remoteDB_:IRepository){
    private val db:IRepository=db_
    private val remoteDB:IRepository=remoteDB_
    fun checkLogin(name:String,email:String): Boolean {
        //val isRegistered:Int=this.remoteDB.checkLogin(name,email)
        val isRegistered:Int=this.db.checkLogin(name,email)
        return isRegistered==1
    }

}