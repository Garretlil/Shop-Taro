package com.example.shop_taro.Model

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class DatabaseHelper(context: Context) : IRepository, SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TABLE = "CREATE TABLE  DataCalc (id Integer PRIMARY KEY, name TEXT, email TEXT,isLogined INTEGER)"
        db?.execSQL(CREATE_TABLE)
    }
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onCreate(db)
    }
    override fun getData(): MutableList<String> {
        val db = this.readableDatabase
        // Создание таблицы (если она еще не существует)
        val sqlCREATEDataCalc = "CREATE TABLE IF NOT EXISTS DataCalc ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT, " +
                "email TEXT, " +
                "isLogined INTEGER)"
        db.execSQL(sqlCREATEDataCalc)
        // Запрос для получения данных
        val sqlstr = "SELECT name, email FROM DataCalc"
        val cursor = db.rawQuery(sqlstr, null)
        // Создание списка для хранения данных
        val data: MutableList<String> = mutableListOf()
        // Проверка, есть ли данные
        if (cursor.moveToLast()) {
            val nameColumnIndex = cursor.getColumnIndex("name")
            val emailColumnIndex = cursor.getColumnIndex("email")
            val name = cursor.getString(nameColumnIndex)
            val email = cursor.getString(emailColumnIndex)
            // Добавление данных в список
            data.add(name)
            data.add(email)
        }
        // Закрытие курсора
        cursor.close()
        return data
    }

    override fun saveData(s1: String, s2: String) {
        val db = this.writableDatabase
        val sqlCREATEDataCalc = " CREATE TABLE IF NOT EXISTS DataCalc ( " +
                "id     INTEGER   PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT , " +
                "email  TEXT , isLogined INTEGER)"
        db.execSQL(sqlCREATEDataCalc)
        // Используйте строковый интерполятор для вставки значений
        val insertQuery = "INSERT INTO DataCalc (name, email, isLogined) VALUES ('$s1', '$s2', 1)"
        db.execSQL(insertQuery)
        //db.execSQL("DELETE FROM DataCalc")
    }
    override fun check(name: String, email: String): Int {
        val db = this.readableDatabase
        val sqlCheck = "SELECT COUNT(*) AS count \n" +
                "FROM DataCalc\n" +
                "WHERE name ='$name'  AND email = '$email'"
        val cursor = db.rawQuery(sqlCheck, null)
        var countAccount = 0
        if (cursor.moveToLast()) {
            val countColumnIndex = cursor.getColumnIndex("count")
            countAccount = cursor.getInt(countColumnIndex)
        }
        cursor.close()
        return countAccount
    }

    override fun delDB(){
        val db = this.writableDatabase
        db.execSQL("DELETE FROM DataCalc")
    }
    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "CalcDB"
        private const val DataCalc = "DataCalc"
        //---------------
        private const val KEY_ID = "id"
        private const val KEY_EXPRESSION = "expression"
    }

}

