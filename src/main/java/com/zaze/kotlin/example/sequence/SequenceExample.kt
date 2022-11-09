package com.zaze.kotlin.example.sequence

import com.zaze.kotlin.example.log
import kotlinx.coroutines.*

fun createSequence(): Sequence<Int> =
        sequence { // 序列构建器
            for (i in 1..30) {
                Thread.sleep(100) // 假装我们正在计算
                yield(i) // 产生下一个值
            }
        }

fun main() = runBlocking {
    launch {
        for (k in 1..10) {
            println("I'm not blocked $k")
            delay(100)
        }
    }
    createSequence().forEach {
        log("sequence", "Sequence is blocked: $it")
    }
}