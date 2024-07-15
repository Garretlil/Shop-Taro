package com.example.shop_taro.Model

import com.example.shop_taro.Repository.User
import com.example.shop_taro.ViewModels.TSViewModel


class Auth (db_:IRepository,remoteDB_:IRepository){
    private val db:IRepository=db_
    private val remoteDB:IRepository=remoteDB_

    fun saveDataUser(name:String,email:String){
        //var id:Int?=this.remoteDB.saveAccount(name,email)
        this.db.saveData(name,email)

    }
}