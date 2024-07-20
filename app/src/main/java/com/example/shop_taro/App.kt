package com.example.shop_taro

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class App:Application(){
    fun deleteDatabase(context: Context, dbName: String) {
        context.deleteDatabase(dbName)
    }
}