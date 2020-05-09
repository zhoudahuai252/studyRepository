package com.example.contactstest

import kotlin.reflect.KProperty

class Later<T>(val block: () -> T) {
    var value: Any? = null
    operator fun getValue(any: Any?, prop: KProperty<*>): T {
        if (value == null) {
            value = block()
        }
        return value as T
    }


}

/**
 * 懒加载原理就是 委托属性。通过by关键字实现属性委托，然后在getvalue中执行lambda函数块，
 */
fun <T> later(block: () -> T) = Later(block)

fun main() {
    val p: String by later {

        ""
    }
}