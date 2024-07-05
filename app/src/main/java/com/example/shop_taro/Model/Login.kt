package com.example.shop_taro.Model



class Login (db_:IRepository){
    private val db:IRepository=db_
    fun checkLogin(name:String,email:String): Boolean {
        val isRegistered:Int=this.db.check(name,email)
        return isRegistered==1
    }

}