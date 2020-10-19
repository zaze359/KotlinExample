package com.zaze.kotlin.example

import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.Future

fun main(args: Array<String>) {
    MyLog.i(DateUtil.timeMillisToString(), "start")
    MyLog.i(DateUtil.timeMillisToString(), "start testFuture")
    arrayListOf<String>("testFuture1", "testFuture2").map {
        testFuture(it)
    }.map {
        it.get()
    }
    MyLog.i(DateUtil.timeMillisToString(), "finish")
}

fun testFuture(test: String): Future<String> {
    return Executors.newSingleThreadExecutor().submit(Callable {
        Thread.sleep(1000L)
        MyLog.i(DateUtil.timeMillisToString(), test)
        test
    })
}
