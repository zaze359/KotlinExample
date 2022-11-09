package com.zaze.kotlin.example.async

import com.zaze.kotlin.example.DateUtil
import com.zaze.kotlin.example.MyLog
import kotlinx.coroutines.delay
import java.util.concurrent.CompletableFuture

/**
 *  CompletableFuture 测试
 */
fun main() {
    MyLog.i(DateUtil.timeMillisToString(), "------ start")
    arrayListOf("1", "2")
        .map {
            testCompletableFuture(it)
        }
        .let { list -> // 整合结果
            CompletableFuture.allOf(*list.toTypedArray())
                .thenApply {
                    list.map { it.get() }
                }
        }.thenAccept {
            MyLog.i(DateUtil.timeMillisToString(), "$it Accept")
        }
    MyLog.i(DateUtil.timeMillisToString(), "------ main sleeping")
    // 保证主线程或者，不然获取不到结果
    Thread.sleep(3000L)
    MyLog.i(DateUtil.timeMillisToString(), "------ finish")
}

fun testCompletableFuture(test: String): CompletableFuture<String> {
    MyLog.i(DateUtil.timeMillisToString(), "testCompletableFuture $test")
    return CompletableFuture.supplyAsync {
        MyLog.i(DateUtil.timeMillisToString(), "$test sleeping")
        Thread.sleep(1000L)
        MyLog.i(DateUtil.timeMillisToString(), "$test wakeup")
        test
    }
}
