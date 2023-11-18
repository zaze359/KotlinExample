package com.zaze.kotlin.example.flow

import com.zaze.kotlin.example.log
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import java.lang.NullPointerException

private val TAG = "FlowExample"

fun main() = runBlocking {
    var flow = productor()
//    flow = productorAsnc()
//    flow = stateFlow()
    // 验证 flowOn 仅对上游产生效果。
//    flow
////            .flowOn(Dispatchers.IO)
//        .map {
//            log(TAG, "map $it to ${it * 2} in ${currentCoroutineContext()}")
//            it * 2
//        }
////            .flowOn(Dispatchers.Default)
//        .catch { e ->
//            log(TAG, "collect Exception: ${e.message}")
//        }.collect {
//            delay(1000L)
//            log(TAG, "collect $it in ${currentCoroutineContext()}")
//        }

    flow {
        repeat(10) {
            emit(it)
        }
    }.conflate().collect {
        log(TAG, "conflate $it")
        delay(1000L)
        log(TAG, "conflate2 $it")
    }
    flow {
        repeat(10) {
            emit(it)
        }
    }.collectLatest {
        log(TAG, "collectLatest $it")
        delay(1000L)
        log(TAG, "collectLatest2 $it")
    }
    val shardFlow = MutableSharedFlow<Int>()

}

/**
 * 同步非阻塞
 */
suspend fun productor() = flow<Int> {
    for (i in 1..10) {
//        delay(100L)
//        Thread.sleep(100L)
//        log(TAG, "produce $i in ${currentCoroutineContext()}")
        emit(i)
//        if (i == 5) {
//            throw NullPointerException("123123")
//        }
    }
}

/**
 * 异步非阻塞
 */
suspend fun productorAsnc(): Flow<Int> {
    return channelFlow<Int> {
        for (i in 1..10) {
            delay(100L)
            log(TAG, "produce $i in ${currentCoroutineContext()}")
            send(i)
        }
    }
}

suspend fun stateFlow(): StateFlow<Int> {
    val flow = MutableStateFlow(-1)
    for (i in 1..10) {
        delay(100L)
        log(TAG, "produce $i in ${currentCoroutineContext()}")
        flow.emit(i)
    }
    return flow
}