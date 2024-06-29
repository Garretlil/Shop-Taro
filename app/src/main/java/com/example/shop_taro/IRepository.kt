package com.example.shop_taro


interface IRepository {
    fun getData():MutableList<String>
    fun saveData(s1:String,s2:String)
    fun delDB()
}