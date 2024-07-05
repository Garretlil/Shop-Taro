package com.example.shop_taro.Model



class Auth (db_:IRepository){
    private val db:IRepository=db_
    fun saveDataUser(name:String,email:String){
        this.db.saveData(name,email)
    }
}