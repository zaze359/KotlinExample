package com.zaze.kotlin.example.async

import com.zaze.kotlin.example.DateUtil
import com.zaze.kotlin.example.MyLog
import java.util.concurrent.Callable
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.Future

/**
 * Future 测试
 */
fun main() {
    MyLog.i(DateUtil.timeMillisToString(), "------ start")
    arrayListOf("1", "2").map {
        testFuture(it)
    }.map {
        it.get()
    }
    MyLog.i(DateUtil.timeMillisToString(), "------ finish")
}

val executors: ExecutorService = Executors.newSingleThreadExecutor()

fun testFuture(test: String): Future<String> {
    MyLog.i(DateUtil.timeMillisToString(), "testFuture $test")
    return executors.submit(Callable {
        MyLog.i(DateUtil.timeMillisToString(), "$test sleeping")
        Thread.sleep(1000L)
        MyLog.i(DateUtil.timeMillisToString(), "$test wakeup")
        test
    })
}
