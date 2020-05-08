package com.example.databasetest

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val databaseHelper = MyDatabaseHelper(this, "BookStore", 2)
        createButton.setOnClickListener {
            databaseHelper.writableDatabase
        }
        addData.setOnClickListener {
            val db = databaseHelper.writableDatabase
            val values = ContentValues().apply {
                //组装第一条数据
                put("name", "The Da Vinci Code")
                put("author", "Dan Brown")
                put("pages", 454)
                put("price", 16.96)
            }
            db.insert("Book", null, values)
            val values2 = ContentValues().apply {
                //组装第二条数据
                put("name", "The Lost Symbol")
                put("author", "Dan Brown")
                put("pages", 510)
                put("price", 19.95)
            }
            db.insert("Book", null, values2)
        }
        updateData.setOnClickListener {
            val db = databaseHelper.writableDatabase
            val values = ContentValues()
            values.put("price", 10.99)
            db.update("Book", values, "name=?", arrayOf("The Da Vinci Code"))
        }
        deleteData.setOnClickListener {
            val db = databaseHelper.writableDatabase
            db.delete("Book", "pages>?", arrayOf("500"))
        }
        queryData.setOnClickListener {
            Log.d("MainActivity", "------------------start-----------------")
            val db = databaseHelper.writableDatabase
            val cursor = db.query("Book", null, null, null, null, null, null)
            if (cursor.moveToFirst()) {
                do {
                    //遍历cursor
                    val id = cursor.getInt(cursor.getColumnIndex("id"))
                    val name = cursor.getString(cursor.getColumnIndex("name"))
                    val author = cursor.getString(cursor.getColumnIndex("author"))
                    val pages = cursor.getInt(cursor.getColumnIndex("pages"))
                    val price = cursor.getDouble(cursor.getColumnIndex("price"))
                    Log.d("MainActivity", "book id is $id")
                    Log.d("MainActivity", "book name is $name")
                    Log.d("MainActivity", "book author is $author")
                    Log.d("MainActivity", "book pages is $pages")
                    Log.d("MainActivity", "book price is $price")
                } while (cursor.moveToNext())
            }
            cursor.close()
            Log.d("MainActivity", "------------------end-----------------")
        }
    }
}
