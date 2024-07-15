package com.example.shop_taro.Model

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase


//@Entity(tableName = "userss")
//class User
//    (var name: String?, var email: String?) {
//
//    @PrimaryKey(autoGenerate = false)
//    var primaryKey: String="" // Добавлено поле для первичного ключа
//
//    init {
//        this.primaryKey = name + "_" + email
//    }
//
//    // (Или использовать метод getPrimaryKey())
////    fun getPrimaryKey(): String {
////        return name + "_" + email
////    }
//}
//@Dao
//interface UserDao {
//    @Insert
//    fun insertUser(user: User)
//
//    @get:Query("SELECT * FROM userss")
//    val allUsers: List<User>
//}
//
//@Database(entities = [User::class], version = 1, exportSchema = false)
//abstract class AppDatabase : RoomDatabase() {
//    abstract fun userDao(): UserDao?
//}
