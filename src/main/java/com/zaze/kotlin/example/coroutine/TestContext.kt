package com.zaze.kotlin.example.coroutine

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.*

fun main() = runBlocking {
    var coroutineContext: CoroutineContext = EmptyCoroutineContext
    coroutineContext += CoroutineExceptionHandler {
        println("CoroutineExceptionHandler")
    }
    coroutineContext += CoroutineName("TestContext")

    suspend {
        println("createCoroutine start")
        "start"
    }.createCoroutine(object : Continuation<String> {
        override val context: CoroutineContext
            get() = coroutineContext

        override fun resumeWith(result: Result<String>) {
            println("result: $result")
            println("CoroutineName: ${context[CoroutineName]}}")
            println("CoroutineExceptionHandler: ${context[CoroutineExceptionHandler]}}")
        }

    }).resume(Unit)

}

//class CoroutineName(val name: String) : AbstractCoroutineContextElement(Key) {
//    companion object Key : CoroutineContext.Key<CoroutineName>
//}

class CoroutineExceptionHandler(val onErrorAction: (Throwable) -> Unit) : AbstractCoroutineContextElement(Key) {
    companion object Key : CoroutineContext.Key<CoroutineExceptionHandler>

    fun onError(error: Throwable) {
        error.printStackTrace()
        onErrorAction(error)
    }
}