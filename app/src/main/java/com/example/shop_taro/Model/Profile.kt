package com.example.shop_taro.Model


class Profile(db_:IRepository){
    private val db:IRepository=db_
     var name:String=""
     var email:String=""
     var telephone:String=""
    init{
        name=db.getData()[0]
        email=db.getData()[1]
    }

    fun changeName(name_:String){
        name=name_
    }
    fun changeTelephone(telephone_:String){
        telephone=telephone_
    }
    fun changeNameFromDB(name_:String){
        name=db.getData()[0]
    }
    fun changeEmailFromDB(name_:String){
        email=db.getData()[1]
    }

}