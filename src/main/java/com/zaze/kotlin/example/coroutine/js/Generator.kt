package com.zaze.kotlin.example.coroutine.js

import com.zaze.kotlin.example.MyLog
import kotlin.coroutines.*


interface Generator<T> {
    operator fun iterator(): Iterator<T>
}

class GeneratorImpl<T>(
    private val block: suspend GeneratorScope<T>.(T) -> Unit,
    private val parameter: T
) : Generator<T> {
    override fun iterator(): Iterator<T> {
        return GeneratorIterator(block, parameter)
    }
}

sealed class State {
    class NotReady(val continuation: Continuation<Unit>) : State()
    class Ready<T>(val continuation: Continuation<Unit>, val nextValue: T) :
        State()

    object Done : State()
}

class GeneratorIterator<T>(
    private val block: suspend GeneratorScope<T>.(T) -> Unit,
    private val parameter: T
) : GeneratorScope<T>, Iterator<T>, Continuation<Any?> {
    override val context: CoroutineContext = EmptyCoroutineContext

    private var state: State

    init {
        val coroutineBlock: suspend GeneratorScope<T>.() -> Unit =
            { block(parameter) }

        // 将 completion 设置 为this，协程执行获得结果后，将继续循环调用自身，并将上一次的结果作为 新一次调用的入参。
        val start = coroutineBlock.createCoroutine(this, this)
        state = State.NotReady(start)
    }

    override suspend fun yield(value: T) {
        MyLog.i("Generator", "suspend start : $value ${state}")
        // 此处挂起后，下次 continuation.resume 从这 恢复。
        suspendCoroutine<Unit> { continuation ->
            state = when (state) {
                // 保存了 continuation 用于下次恢复
                is State.NotReady -> State.Ready(continuation, value)
                is State.Ready<*> -> throw IllegalStateException("Cannot yield a value while ready.")
                State.Done -> throw IllegalStateException("Cannot yield a value while done.")
            }
            // block 执行完毕， 之后 suspendCoroutine 内部会调用 continuation.getOrThrow()，然后挂起。
        }
        // 已经被挂起，恢复后才能执行，
        MyLog.i("Generator", "suspend end: $value ${state}")
        // 返回 执行结果 Unit
    }


    private fun resume() {
        MyLog.i("Generator", "resume 1")
        when (val currentState = state) {
            is State.NotReady -> currentState.continuation.resume(Unit)
            else -> {}
        }
        MyLog.i("Generator","resume 2")
    }

    override fun hasNext(): Boolean {
        resume()
        return state != State.Done
    }

    override fun next(): T {
        return when (val currentState = state) {
            is State.NotReady -> {
                resume()
                MyLog.i("Generator", "state: $state")
                return next()
            }
            is State.Ready<*> -> {
                state = State.NotReady(currentState.continuation)
                (currentState as State.Ready<T>).nextValue
            }
            State.Done -> throw IndexOutOfBoundsException("No value left.")
        }
    }

    override fun resumeWith(result: Result<Any?>) {
        MyLog.i("Generator", "resumeWith 1")
        state = State.Done
        result.getOrThrow()
        MyLog.i("Generator", "resumeWith 2")
    }

}

interface GeneratorScope<T> {
    suspend fun yield(value: T)
}

fun <T> generator(block: suspend GeneratorScope<T>.(T) -> Unit): (T) -> Generator<T> {
    return { parameter: T ->
        GeneratorImpl(block, parameter)
    }
}

fun main() {
    val nums = generator { start: Int ->
        for (i in 0..5) {
            MyLog.i("Generator", "yield 1: $i")
            val r = yield(start + i)
            MyLog.i("Generator", "yield 2: $i ; $r")
        }
    }

//    "".let(::a)

    val seq = nums(10)

    for (j in seq) {
        MyLog.i("Generator", "seq : $j")
        MyLog.i("Generator", "-------------------")
    }

//// ---------------------

//    val sequence = sequence {
//        yield(1)
//        yield(2)
//        yield(3)
//        yield(4)
//        yieldAll(listOf(1, 2, 3, 4))
//    }
//
//    for (element in sequence) {
//        println(element)
//    }

// ---------------------
//    val fibonacci = sequence {
//        yield(1L) // first Fibonacci number
//        var current = 1L
//        var next = 1L
//        while (true) {
//            yield(next) // next Fibonacci number
//            next += current
//            current = next - current
//        }
//    }
//
//    fibonacci.take(10).forEach(::println)
}

fun <T> a(t:T) :Unit {}