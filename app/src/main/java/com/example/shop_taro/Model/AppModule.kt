package com.example.shop_taro.Model

import android.app.Application
import androidx.room.Room
import com.example.shop_taro.Model.IRepository
import com.example.shop_taro.Model.RetrofitHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRepository(remoteDB: RetrofitHelper): IRepository {
        return remoteDB
    }

    @Singleton
    @Provides
    fun provideYourDatabase(app:Application): AppDatabase {
        return Room.databaseBuilder(
            app, AppDatabase::class.java,"inf.db").fallbackToDestructiveMigration()
            .build()
    }
}

