package com.example.servicetest

fun main() {
    val result1 = getGenericType<String>()
    val result2 = getGenericType<Int>()
    println("result1 is $result1")
    println("result2 is $result2")

    val student = Student("Tom", 19)
    val data = SimpleData<Student>(student)
    handleSimpleData(data)
    val studentData = data.get()

    val trans = object : TransFormer<Person> {
        override fun transform(t: Person): String {
            return "${t.name}  ${t.age}"
        }
    }
    handleTransformer(trans)
}

fun handleTransformer(trans: TransFormer<Student>): Unit {
    val student = Student("Tom", 19)
    val result = trans.transform(student)
}

fun handleSimpleData(data: SimpleData<Person>): Unit {
    val personData = data.get()
}

/**
 * 获取泛型实际类型，泛型实化
 */
inline fun <reified T> getGenericType() = T::class.java