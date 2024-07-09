package com.example.shop_taro.Model.dagger

import com.example.shop_taro.Model.Cart
import com.example.shop_taro.Model.Orders
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
    fun provideOrders(cart: Cart): Orders {
        return Orders(cart)
    }

    @Provides
    fun provideCart(): Cart {
        return Cart()
    }
}

