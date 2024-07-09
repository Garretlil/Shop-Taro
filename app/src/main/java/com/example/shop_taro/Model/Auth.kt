package com.example.shop_taro.Model

import com.example.shop_taro.Repository.User
import com.example.shop_taro.ViewModels.TSViewModel


class Auth (db_:IRepository){
    private val db:IRepository=db_

    fun saveDataUser(name:String,email:String){
        val newUser = User(username = name, email = email)
        this.db.saveData(name,email)

    }
}