package com.example.shop_taro.Model.dagger

import android.app.Application
import com.example.shop_taro.Model.Cart
import com.example.shop_taro.Model.DatabaseHelper
import com.example.shop_taro.Model.IRepository
import com.example.shop_taro.Model.Orders
import com.example.shop_taro.Model.RetrofitHelper
import dagger.Component
import dagger.Module
import dagger.Provides

@Component(modules = [OrdersModule::class])
interface OrdersComponent {
    val orders: Orders
}

@Module
class OrdersModule {
    @Provides
    fun provideOrders(db:IRepository, remoteDB:IRepository, cart: Cart): Orders {
        return Orders(remoteDB,cart)
    }
    @Provides
    fun provideRemoteDB():IRepository{
        return RetrofitHelper()
    }

    @Provides
    fun provideCart(): Cart {
        return Cart()
    }
}

