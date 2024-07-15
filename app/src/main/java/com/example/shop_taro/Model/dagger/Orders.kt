package com.example.shop_taro.Model.dagger

import android.app.Application
import android.content.Context

import androidx.room.Room
//import com.example.shop_taro.Model.AppDatabase
import com.example.shop_taro.Model.Cart
import com.example.shop_taro.Model.DatabaseHelper
import com.example.shop_taro.Model.IRepository
import com.example.shop_taro.Model.Orders
import com.example.shop_taro.Model.RetrofitHelper
import com.example.shop_taro.Taro_market
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

//@Module
//@InstallIn(SingletonComponent::class)
//object RoomModule {
//    @Provides
//    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
//        return Room.databaseBuilder(
//            context,
//            AppDatabase::class.java,
//            "app-database"
//        ).build()
//    }
//}

// OrdersModule.kt
@Module
@InstallIn(SingletonComponent::class)
class OrdersModule {
    @Provides
    fun provideOrders(
        //db: AppDatabase,
        remoteDB: IRepository,
        cart: Cart
    ): Orders {
        return Orders(remoteDB, cart)
    }

    @Provides
    fun provideRemoteDB(): IRepository {
        return RetrofitHelper()
    }

    @Provides
    fun provideCart(): Cart {
        return Cart()
    }
}

// OrdersComponent.kt

//@Module
//class OrdersModule {
//    @Provides
//    fun provideOrders(db:IRepository, remoteDB:IRepository, cart: Cart): Orders {
//        return Orders(remoteDB,cart)
//    }
//    @Provides
//    fun provideRemoteDB():IRepository{
//        return RetrofitHelper()
//    }
//
//    @Provides
//    fun provideCart(): Cart {
//        return Cart()
//    }
//}

