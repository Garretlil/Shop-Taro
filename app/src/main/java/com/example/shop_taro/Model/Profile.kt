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
    fun changeName(name_:String){
        name=name_
    }
    fun changeTelephone(telephone_:String){
        telephone=telephone_
    }
    fun changeNameFromDB(name_:String){
        //id=db.getData()[0].toInt()
        runBlocking {
            name = db.userDao().getAllUsers().last().name
            email = db.userDao().getAllUsers().last().email
        }
    }
    fun changeEmailFromDB(name_:String){
        runBlocking {
            email = db.userDao().getAllUsers().last().email
        }
    }

}