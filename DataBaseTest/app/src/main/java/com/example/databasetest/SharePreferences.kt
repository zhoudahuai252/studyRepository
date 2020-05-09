package com.example.databasetest

import android.content.SharedPreferences

fun SharedPreferences.open(block: SharedPreferences.Editor.() -> Unit): Unit {
    val editor = edit()
    editor.block()
    editor.apply()

}