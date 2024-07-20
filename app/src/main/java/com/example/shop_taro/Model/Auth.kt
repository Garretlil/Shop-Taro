package com.example.shop_taro.Model


import kotlinx.coroutines.runBlocking


class Auth (db_: AppDatabase, remoteDB_:IRepository){
    private val db: AppDatabase =db_
    private val remoteDB:IRepository=remoteDB_

    fun saveDataUser(name:String,email:String){
        //var id:Int?=this.remoteDB.saveAccount(name,email)
        runBlocking { db.userDao().insertUser(User(0,name,email)) }
    }
}