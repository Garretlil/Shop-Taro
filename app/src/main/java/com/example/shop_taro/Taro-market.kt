package com.example.shop_taro

import android.app.Application
import com.example.shop_taro.Model.dagger.CatalogComponent
import com.example.shop_taro.Model.dagger.DaggerCatalogComponent


class Taro_market: Application() {

    private lateinit var catalogComponent: CatalogComponent

    override fun onCreate() {
        super.onCreate()
        catalogComponent = DaggerCatalogComponent.create()
    }

    fun getCatalogComponent(): CatalogComponent {
        return catalogComponent
    }
}
