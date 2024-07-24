package com.example.shop_taro.Model

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val email: String
)

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User) // Изменяем на User

    @Query("SELECT * FROM users")
    suspend fun getAllUsers(): List<User>

    @Query("SELECT COUNT(*) AS count FROM users WHERE name = :name AND email = :email")
    suspend fun checkLogin(name: String, email: String): Int

    @Query("DELETE FROM users")
    suspend fun deleteAllData()

    @Query("UPDATE users SET name=:name")
    suspend fun changeName(name:String)

    @Query("UPDATE users SET email=:email")
    suspend fun changeEmail(email:String)
}

@Database(entities = [User::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}