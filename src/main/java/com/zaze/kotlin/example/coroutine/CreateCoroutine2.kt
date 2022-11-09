package com.zaze.kotlin.example.coroutine

import com.zaze.kotlin.example.MyLog
import kotlin.coroutines.*


fun main() {
    launchCoroutine(ProducerScope<Int>()) {
        MyLog.i("CreateCoroutine2", "launchCoroutine 11111111")
    }
}

// ------------------------------

fun <R, T> launchCoroutine(receiver: R, block: suspend R.() -> T) {
    block.startCoroutine(receiver, object : Continuation<T> {
        override val context: CoroutineContext
            get() = EmptyCoroutineContext

        override fun resumeWith(result: Result<T>) {
            MyLog.i(TAG, "launchCoroutine End: $result")
        }
    })
}

class ProducerScope<T> {
    suspend fun produce(value: T) {
        MyLog.i(TAG, "ProducerScope produce $value")
    }
}
