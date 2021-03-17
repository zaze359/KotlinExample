package com.zaze.kotlin.example.coroutine

import com.zaze.kotlin.example.MyLog
import kotlin.coroutines.*

const val TAG = "CreateCoroutine"

/**
 * 创建协程体: createCoroutine
 * 调用resume执行
 * 创建并立即执行 : startCoroutine
 */
val continuation = suspend {
    MyLog.i(TAG, "In Coroutine")
    5
}.createCoroutine(object : Continuation<Int> {
    override val context: CoroutineContext
        get() = EmptyCoroutineContext

    override fun resumeWith(result: Result<Int>) {
        MyLog.i(TAG, "Coroutine End: $result")
    }
})

fun main() {
    continuation.resume(Unit)
}