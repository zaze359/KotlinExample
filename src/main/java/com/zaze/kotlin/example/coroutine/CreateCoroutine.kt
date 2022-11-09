package com.zaze.kotlin.example.coroutine

import com.zaze.kotlin.example.MyLog
import kotlinx.coroutines.delay
import kotlin.coroutines.*

const val TAG = "CreateCoroutine"

/**
 * 创建协程体: createCoroutine
 * 需要调用 resume启动
 */
val continuation = suspend {  // 协程体
    MyLog.i(TAG, "In Coroutine 1")
    fun1()
    fun2()
    1
}.createCoroutine(object : Continuation<Int> {
    override val context: CoroutineContext
        get() = LogInterceptor()

    override fun resumeWith(result: Result<Int>) {
        // 协程结束后的回调
        MyLog.i(TAG, "Coroutine End: $result")
    }
})

fun main() {
    // 调用resume()启动协程
    continuation.resume(Unit)
    // 等同上方，实际 resume 就是调用的这个方法。
//    continuation.resumeWith(Result.success(Unit))
}



suspend fun fun1() {
    MyLog.i(TAG, "fun1")
}

suspend fun fun2() {
    MyLog.i(TAG, "fun2")
}


///**
// * 创建并立即执行 : startCoroutine
// */
////val continuation2 = suspend {
////    MyLog.i(TAG, "In Coroutine 2")
////    2
////}.startCoroutine(object : Continuation<Int> {
////    override val context: CoroutineContext
////        get() = EmptyCoroutineContext
////
////    override fun resumeWith(result: Result<Int>) {
////        MyLog.i(TAG, "Coroutine End: $result")
////    }
////})

