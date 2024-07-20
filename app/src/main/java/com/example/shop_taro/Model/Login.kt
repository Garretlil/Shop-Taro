package com.example.shop_taro.Model

import kotlinx.coroutines.runBlocking


class Login (db_: AppDatabase, remoteDB_:IRepository){
    val db: AppDatabase =db_
    private val remoteDB:IRepository=remoteDB_
    fun checkLogin(name:String, email:String): Boolean {
        //val isRegistered:Int=this.remoteDB.checkLogin(name,email)
        val isRegistered:Int
        runBlocking {
            isRegistered= db.userDao().checkLogin(name,email)
        }
        return isRegistered==1
    }

}