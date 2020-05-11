package com.example.coroutinestest

import kotlinx.coroutines.*

fun main() {
    /*GlobalScope.launch {
        println("codes run in coroutine scope")
        delay(1500)
        println("codes run in coroutine scope finished")
    }*/
    /*  runBlocking {
          launch {
              println("launch1")
              delay(1000)
              println("launch1 finished")
          }
          launch {
              println("launch2")
              delay(1500)
              println("launch2 finished")
          }
          launch {
              println("launch3")
              delay(500)
              println("launch3 finished")
          }

      }*/
    /*val start = System.currentTimeMillis()
    runBlocking {
        repeat(100000) {

            launch {

                println("$it.---> ${System.currentTimeMillis()}")
            }
        }
    }
    val end = System.currentTimeMillis()
    println(end - start)*/

    /*runBlocking {
        coroutineScope {
            launch {
                for (i in 1..10) {
                    println("launch1---->$i")
                    delay(1000)
                }
            }

        }
       // println("coroutineScope finished")
        launch {
            for (i in 1..1000) {
                println("launch2--->$i")
            }
        }
    }
    println("runBlocking finished")*/


    /*runBlocking {
        val start = System.currentTimeMillis()
        val result1 = async {
            delay(1000)
            5 + 5
        }.await()

        val result2 = async {
            delay(1000)
            4 + 6
        }.await()
        println("result1 is $result1 result2 is$result2")
        val end = System.currentTimeMillis()
        println("cost ${end - start} ms")
    }*/
   /* runBlocking {
        val start = System.currentTimeMillis()
        val result1 = async {
            delay(1000)
            5 + 5
        }

        val result2 = async {
            delay(1000)
            4 + 6
        }
        println("result1 is ${result1.await()} result2 is${result2.await()}")
        val end = System.currentTimeMillis()
        println("cost ${end - start} ms")
    }*/
    runBlocking {
        val result = withContext(Dispatchers.Default) {
            5 + 5
        }
        println(result)
    }
}