package com.example.databasetest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val databaseHelper = MyDatabaseHelper(this, "BookStore", 2)
        createButton.setOnClickListener {
            databaseHelper.writableDatabase
        }
    }
}
