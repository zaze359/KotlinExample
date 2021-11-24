package com.zaze.kotlin.example.channel

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.internal.ChannelFlow

fun main() = runBlocking {
    launch {
        for (k in 1..100) {
            println("I'm not blocked $k")
            delay(100)
        }
    }

    val channel = Channel<Int>()



    val job = launch {
        // 这里可能是消耗大量 CPU 运算的异步逻辑,我们将仅仅做 5 次整数的平方并发送
        for (x in 1..6) {
            channel.send(x * x)
            delay(500)
        }
    }
    // 这里我们打印了 5 次被接收的整数:

    try {
        for (i in channel) {
            println("------------------------------ channel: $i")
            if(i >= 20) {
                job.cancel()
                channel.close()
            }
        }
    } finally {
        println("Done!")
    }
    println("------------------------------ last")
}