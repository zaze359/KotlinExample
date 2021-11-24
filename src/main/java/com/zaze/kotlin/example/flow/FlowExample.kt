package com.zaze.kotlin.example.flow

import com.zaze.kotlin.example.log
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import java.lang.NullPointerException

fun simple(): Sequence<Int> =
    sequence { // 序列构建器
        for (i in 1..3) {
            Thread.sleep(1000) // 假装我们正在计算
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

    simple().forEach {
        log(TAG, "Sequence : $it")
    }


    val flow = productor()
//        .catch {
//            log(TAG, "collect catch: ${it.message}")
//        }
//        .flatMapConcat {
//            flow<Int> {
//                emit(it)
//            }
//        }

//    withContext(Dispatchers.IO) {
//        flow.collect {
//            delay(100L)
//            log(TAG, "collect 1: $it")
//        }
//        log(TAG, "collect: 123123123")
//    }

//    try {
//        flow.collect {
//            delay(100L)
//            log(TAG, "collect: $it")
//        }
//    } catch (e: Exception) {
//        log(TAG, "collect Exception: ${e.message}")
//    }
//    withContext(Dispatchers.Default) {
//        flow.collect {
//            delay(100L)
//            log(TAG, "collect2: $it")
//        }
//    }
//
//    productor()
//        .shareIn(this, replay = 1, started = SharingStarted.WhileSubscribed())
//        .collect {
//            delay(10L)
//            log(TAG, "collect: $it")
//        }
//
//    productorAsnc().stateIn(this)
//        .collect {
//            delay(10L)
//            log(TAG, "collect: $it")
//        }
}

private val TAG = "FlowExample"

/**
 * 同步非阻塞
 */
suspend fun productor() = flow<Int> {
    for (i in 1..10) {
//        delay(100L)
        Thread.sleep(100L)
        log(TAG, "produce: $i")
        emit(i)
        if (i == 5) {
            throw NullPointerException("123123")
        }
    }
}

/**
 * 异步非阻塞
 */
suspend fun productorAsnc() = channelFlow<Int> {
    for (i in 1..10) {
        delay(100L)
        log(TAG, "produce: $i")
        send(i)

    }
}