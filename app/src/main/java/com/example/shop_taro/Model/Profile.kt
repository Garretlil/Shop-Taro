package com.example.shop_taro.Model


import kotlinx.coroutines.runBlocking


class Profile(db_: AppDatabase){
    private val db: AppDatabase =db_
     var id:Int?=null
     var name:String=""
     var email:String=""
     var telephone:String=""
     lateinit var list:List<User>
    init{
        runBlocking {
             list= db.userDao().getAllUsers()
             if(list.isNotEmpty()){
                 name = list.last().name
                 email = list.last().email
            }
        }
    }
    fun changeTelephone(telephone_:String){
        telephone=telephone_
    }

    fun changeName(name:String){
        runBlocking { db.userDao().changeName(name) }
    }
    fun changeEmail(email:String){
        runBlocking { db.userDao().changeEmail(email) }
    }

}