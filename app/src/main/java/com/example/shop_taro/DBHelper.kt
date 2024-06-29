package com.example.shop_taro

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
    override fun getData()  {
        val db = this.readableDatabase
        val sqlCREATEDataCalc=" CREATE TABLE if not exists DataCalc ( " +
                "id     INTEGER   PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT(10) , " +
                "email  TEXT(10) , isLogined INTEGER)"
        db.execSQL(sqlCREATEDataCalc)
        val sqlstr1=" SELECT * FROM  DataCalc"
        val cursor = db.rawQuery(sqlstr1, null)
        val valueColumnIndex=cursor.getColumnIndex("name")
        val typeColumnIndex=cursor.getColumnIndex("email")
        val IsLogined=cursor.getColumnIndex("isLogined")


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
    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "CalcDB"
        private const val DataCalc = "DataCalc"
        //---------------
        private const val KEY_ID = "id"
        private const val KEY_EXPRESSION = "expression"
    }


}

