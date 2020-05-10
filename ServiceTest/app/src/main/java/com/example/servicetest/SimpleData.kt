package com.example.servicetest

class SimpleData<out T>(private var data: T?) {

    fun get(): T? {
        return data
    }
}

open class Person(val name: String, val age: Int)
class Student(name: String, age: Int) : Person(name, age)
class Teacher(name: String, age: Int) : Person(name, age)
interface TransFormer<in T> {
    fun transform(t: T): String
}