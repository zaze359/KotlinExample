package com.zaze.kotlin.example.channel

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel

/**
 * 发送默认会挂起当前协程, 可以通过指定capacity和onBufferOverflow修改行为。
 * 接收数据会挂起当前协程
 */

fun main() = runBlocking {
    var channel = Channel<Int>()
    // 默认RENDEZVOUS send会挂起，必须等待接收
    // CONFLATED 不挂起，但是仅保留最新的一个。
//    channel = Channel<Int>(onBufferOverflow = BufferOverflow.DROP_OLDEST) // 效果等同 capacity = Channel.CONFLATED
    channel = Channel(capacity = Channel.CONFLATED,  onUndeliveredElement = { i ->
        println("channel onUndeliveredElement $i")
    })
//    channel = Channel(capacity = Channel.UNLIMITED)
//    channel = Channel(capacity = Channel.BUFFERED)
//    channel = Channel(capacity = Channel.BUFFERED, onBufferOverflow = BufferOverflow.DROP_OLDEST)
    val job = launch {
        for (i in 0..200) {
            println("channel send $i")
            channel.send(i)
            delay(50)
        }
    }
    delay(5000)
    // receive()会挂起当前协程
    repeat(10) {
        println("channel repeat received: ${channel.receive()}")
        delay(100)
    }
    // channel支持遍历
    for (i in channel) {
        // 从10开始打印，0~9 已被消费
        println("channel foreach received: $i")
        delay(100)
        // 若不主动close()，将一直等待接收新数据
//        if (i >= 100) {
//            channel.close()
//            job.cancel()
//        }
    }
    println("Done!")
}
