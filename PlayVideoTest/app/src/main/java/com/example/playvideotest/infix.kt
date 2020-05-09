package com.example.playvideotest

infix fun String.beginWith(prefix: String) = startsWith(prefix)
infix fun <T> Collection<T>.has(element: T) = contains(element)

infix fun <A, B> A.with(that: B): Pair<A, B> = Pair(this, that)
fun main() {
    if ("hello kotlin" beginWith "hello") {
        println("----------true----------")
    }
    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
    if (list has "Pear") {
        println("-------------true-------")
    }
}