package com.zaze.kotlin.example.coroutine

import kotlin.coroutines.Continuation
import kotlin.coroutines.ContinuationInterceptor
import kotlin.coroutines.CoroutineContext

class LogInterceptor : ContinuationInterceptor {
    override val key: CoroutineContext.Key<*>
        get() = ContinuationInterceptor


    override fun <T> interceptContinuation(continuation: Continuation<T>): Continuation<T> {
        return LogContinuation(continuation)
    }
}

class LogContinuation<T>(private val continuation : Continuation<T>) : Continuation<T> by continuation {

    override fun resumeWith(result: Result<T>) {
        println("before resumeWith: $result")
        continuation.resumeWith(result)
        println("after resumeWith.")
    }
}