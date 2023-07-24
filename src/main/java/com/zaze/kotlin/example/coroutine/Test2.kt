package com.zaze.kotlin.example.coroutine

import kotlinx.coroutines.*

/**
 * 取消协程
 * 协程的取消协作，但必须是协作状态才能取消。（发起取消后并且对应协程检测之后才能取消）
 *
 * 取消的方式
 * 1. 调用了挂起函数(例如delay);
 * 2. 显示的检测了状态isActive;
 *
 */
fun main() = runBlocking {
    println("--------------- fun a start ------------------")
    a(this)
    println("--------------- fun a end ------------------")
    println("--------------- fun b start ------------------")
    b(this)
    println("--------------- fun b end ------------------")
    println("--------------- fun cancelFailed start ------------------")
    cancelFailed(this)
    println("--------------- fun cancelFailed end ------------------")
    println("--------------- fun checkCancel start ------------------")
    checkCancel(this)
    println("--------------- fun checkCancel end ------------------")
}

/**
 * job.cancel()
 * job.join()
 */
suspend fun a(coroutineScope: CoroutineScope) {
    val job =
        coroutineScope.launch {
            repeat(1000) { i ->
                println("job: I'm sleeping $i ...")
                delay(500L)
            }
        }
    delay(1300L) // 延迟一段时间

    println("main: I'm tired of waiting!")
    job.cancel() // 取消该作业
    job.join() // 等待作业执行结束
    println("main: Now I can quit.")
}

/**
 * job.cancelAndJoin()
 */
suspend fun b(coroutineScope: CoroutineScope) {
    val job = coroutineScope.launch() {
        try {
            repeat(1000) { i ->
                println("job: I'm sleeping $i ...")
                delay(500L)
            }
        } catch (e: Exception) {
            println("job: I'm Exception: $e")
        } finally {
            println("job: I'm running finally")
        }
    }
    delay(1300L) // 延迟一段时间
    println("c main: I'm tired of waiting!")
    job.cancelAndJoin() // 取消该作业并且等待它结束
    println("c main: Now I can quit.")
}


/**
 * 协程内正在执行计算且没有检测取消，此时协程不会停止
 * job: I'm sleeping 0 ...
 * job: I'm sleeping 1 ...
 * job: I'm sleeping 2 ...
 * main: I'm tired of waiting!
 * job: I'm sleeping 3 ...
 * job: I'm sleeping 4 ...
 * main: Now I can quit.
 */
suspend fun cancelFailed(coroutineScope: CoroutineScope) {
    val startTime = System.currentTimeMillis()
    val job = coroutineScope.launch(Dispatchers.Default) {
        var nextPrintTime = startTime
        var i = 0
        while (i < 5) {
            // 一个执行计算的循环,只是为了占用 CPU
            // 每秒打印消息两次
            if (System.currentTimeMillis() >= nextPrintTime) {
                println("job: I'm sleeping ${i++} ...")
                nextPrintTime += 500L
            }
        }
    }
    delay(1300L)
    // 等待一段时间
    println("main: I'm tired of waiting!")
    job.cancelAndJoin()
    // 取消一个作业并且等待它结束
    println("main: Now I can quit.")
}


/**
 * 显示的检测了取消状态, 成功取消了协程
 */
suspend fun checkCancel(coroutineScope: CoroutineScope) {
    val startTime = System.currentTimeMillis()
    val job = coroutineScope.launch(Dispatchers.Default) {
        var nextPrintTime = startTime
        var i = 0
        while (i < 5 && isActive) {
            // 一个执行计算的循环,只是为了占用 CPU
            // 每秒打印消息两次
            if (System.currentTimeMillis() >= nextPrintTime) {
                println("job: I'm sleeping ${i++} ...")
                nextPrintTime += 500L
            }
        }
    }
    delay(1300L)
    // 等待一段时间
    println("main: I'm tired of waiting!")
    job.cancelAndJoin()
    // 取消一个作业并且等待它结束
    println("main: Now I can quit.")
}
