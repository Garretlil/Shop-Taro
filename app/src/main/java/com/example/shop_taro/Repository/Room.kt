package com.example.shop_taro.Repository

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase

@Entity(tableName = "DataCalc")
data class User(
    //@PrimaryKey(autoGenerate = true) val id: Long=0,
    @PrimaryKey
    val username: String,
    val email: String
)
@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     suspend fun insertUser(user: User)

    @Query("SELECT username,email FROM DataCalc")
     fun getAllUsers(): List<User>
}
@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}

