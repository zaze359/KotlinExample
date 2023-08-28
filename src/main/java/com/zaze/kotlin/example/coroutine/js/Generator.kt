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

/**
 * 作用域，定义了 yield 挂起函数
 */
interface GeneratorScope<T> {
    suspend fun yield(value: T)
}

// 构造迭代器
class GeneratorIterator<T>(
    private val block: suspend GeneratorScope<T>.(T) -> Unit,
    private val parameter: T
) : GeneratorScope<T>, Iterator<T>, Continuation<Any?> {
    override val context: CoroutineContext = EmptyCoroutineContext

    private var state: State

    init {
        // 协程体
        val coroutineBlock: suspend GeneratorScope<T>.() -> Unit =
            { block(parameter) }
        // 将 completion 设置 为this，协程执行获得结果后，将继续循环调用自身，并将上一次的结果作为 新一次调用的入参。
        // 利用 receiver 参数扩展协程体
        val start = coroutineBlock.createCoroutine(this, this)
        state = State.NotReady(start)
    }

    /**
     * 挂起
     */
    override suspend fun yield(value: T) {
        MyLog.i("Generator", "suspend start : $value ${state}")
        //  block 执行完毕， 之后 suspendCoroutine 内部会调用 continuation.getOrThrow()，然后挂起。
        val ret = suspendCoroutine<Unit> { continuation ->
            // 更新 状态，
            state = when (state) {
                // 保存continuation 用于下次恢复
                is State.NotReady -> State.Ready(continuation, value)
                is State.Ready<*> -> throw IllegalStateException("Cannot yield a value while ready.")
                State.Done -> throw IllegalStateException("Cannot yield a value while done.")
            }
        }
        MyLog.i("Generator", "suspend value: $value; ret: ${ret}")
        // 这里被挂起，下次 continuation.resume 从这恢复，恢复后才能执行。
        MyLog.i("Generator", "suspend end: ${state}")
        // 返回 执行结果 Unit
    }


    private fun resume() {
        MyLog.i("Generator", "resume 1")
        when (val currentState = state) { // 恢复协程
            is State.NotReady -> currentState.continuation.resume(Unit)
            else -> {}
        }
        // 需要注意，这里是不会被挂起的，只有挂起函数才会挂起。
        //
        MyLog.i("Generator","resume 2")
    }


    override fun resumeWith(result: Result<Any?>) {
        MyLog.i("Generator", "resumeWith 1")
        state = State.Done
        result.getOrThrow()
        MyLog.i("Generator", "resumeWith 2")
    }

    //  Iterator
    override fun hasNext(): Boolean {
        resume()
        return state != State.Done
    }

    override fun next(): T {
        MyLog.i("Generator", "next: $state")
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
}

fun <T> generator(block: suspend GeneratorScope<T>.(T) -> Unit): (T) -> Generator<T> {
    return { parameter: T ->
        GeneratorImpl(block, parameter)
    }
}

fun main() {
//    val aaaa = fun GeneratorScope<Int>.(a:Int) {
//    }
//    generator(aaaa)
    // 构造器
    val numGenerator = generator { start: Int ->
        for (i in 0..5) {
            MyLog.i("Generator", "yield 1: $i")
            val r = yield(start + i) // 挂起
            MyLog.i("Generator", "yield 2: $i ; $r")
        }
    }

    // 创建协程
    val seq = numGenerator(10)

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


//    "".let(::a)

}

fun <T> a(t:T) :Unit {}