package com.example.shop_taro

import android.app.Application
import androidx.room.Room.databaseBuilder
//import com.example.shop_taro.Model.dagger.DaggerOrdersComponent

import com.example.shop_taro.Repository.AppDatabase
import dagger.hilt.android.HiltAndroidApp
//import com.example.shop_taro.Model.dagger.OrdersComponent

@HiltAndroidApp
class Taro_market: Application() {



//    fun getCatalogComponent(): OrdersComponent {
//        return catalogComponent
//    }
//    fun getDatabase(): AppDatabase {
//        return database
//    }
}
//@HiltAndroidApp
//class Taro_market: Application() {
//    lateinit var database: AppDatabase // Добавлено объявление database
//
//    override fun onCreate() {
//        super.onCreate()
//        database = databaseBuilder(this, AppDatabase::class.java, "app-database")
//            .build() // Инициализация базы данных
//        val t = 5
//    }
//}
