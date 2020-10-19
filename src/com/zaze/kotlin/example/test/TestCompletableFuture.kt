package com.zaze.kotlin.example

import java.util.concurrent.CompletableFuture

fun main(args: Array<String>) {
    MyLog.i(DateUtil.timeMillisToString(), "start")
    MyLog.i(DateUtil.timeMillisToString(), "start testCompletableFuture")
    arrayListOf<String>("testCompletableFuture1", "testCompletableFuture2").map {
        testCompletableFuture(it)
    }
//        .map { future ->
//        future.thenAccept {
//            MyLog.i(DateUtil.timeMillisToString(), it)
//        }
//    }
        .let { list ->
            CompletableFuture.allOf(*list.toTypedArray()).thenApply {
                list.map { it.get() }
            }
        }.thenAccept {
            MyLog.i(DateUtil.timeMillisToString(), "$it")
        }
    MyLog.i(DateUtil.timeMillisToString(), "finish")
}

fun testCompletableFuture(test: String): CompletableFuture<String> {
    return CompletableFuture.supplyAsync {
        Thread.sleep(1000L)
        test
    }
}
