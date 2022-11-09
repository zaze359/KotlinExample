package com.zaze.kotlin.example.coroutine

import kotlinx.coroutines.runBlocking
import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

fun main() = runBlocking {
    var coroutineContext: CoroutineContext = EmptyCoroutineContext
    coroutineContext += CoroutineName("")
    coroutineContext += CoroutineName("")

}
class CoroutineName(val name: String) : AbstractCoroutineContextElement(Key) {
    companion object Key : CoroutineContext.Key<CoroutineName>
}

class CoroutineExceptionHandler(val onerrorAction: (Throwable) -> Unit) : AbstractCoroutineContextElement(Key) {
    companion object Key : CoroutineContext.Key<CoroutineExceptionHandler>

    fun onError(error: Throwable) {
        error.printStackTrace()
        onerrorAction(error)
    }
}