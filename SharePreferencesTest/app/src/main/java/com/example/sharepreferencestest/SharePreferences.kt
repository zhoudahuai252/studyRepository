package com.example.sharepreferencestest

import android.content.SharedPreferences

fun SharedPreferences.open(block: SharedPreferences.Editor.() -> Unit): Unit {
    val editor = edit()
    block(editor)
   // editor.block()
    editor.apply()

}