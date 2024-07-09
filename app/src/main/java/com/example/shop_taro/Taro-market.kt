package com.example.shop_taro

import android.app.Application
import androidx.room.Room
import com.example.shop_taro.Model.dagger.DaggerOrdersComponent

import com.example.shop_taro.Model.dagger.OrdersComponent
import com.example.shop_taro.Repository.AppDatabase


class Taro_market: Application() {

    private lateinit var catalogComponent: OrdersComponent
    companion object {
        lateinit var database: AppDatabase
    }
    override fun onCreate() {
        super.onCreate()
        catalogComponent = DaggerOrdersComponent.create()
        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "DataBase"
        ).build()
    }

    fun getCatalogComponent(): OrdersComponent {
        return catalogComponent
    }
}
