package com.zaze.kotlin.example.coroutine

import kotlinx.coroutines.*


/**
 * 协程的基础使用
 */
fun main() = runBlocking {
    // this: CoroutineScope
    launch {
        delay(200L)
        println("Task from runBlocking")
    }
    coroutineScope { // 创建一个协程作用域
        launch {
            doWork("Task from nested launch", 500L) // 提取
        }
        delay(100L)
        println("Task from coroutine scope") // 这一行会在内嵌 launch 之前输出
    }
    println("Coroutine scope is over") // 这一行在内嵌 launch 执行完毕后才输出」
}

/**
 * 提取函数重构
 */
suspend fun doWork(message: String, delay: Long) {
    delay(delay)
    println(message)
}