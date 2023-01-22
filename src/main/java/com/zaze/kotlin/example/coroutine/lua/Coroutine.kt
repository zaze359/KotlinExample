package com.zaze.kotlin.example.coroutine.lua

import java.util.concurrent.Executor
import java.util.concurrent.Executors
import java.util.concurrent.atomic.AtomicReference
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import kotlin.coroutines.*
import kotlin.coroutines.intrinsics.suspendCoroutineUninterceptedOrReturn

sealed class Status {
    class Created(val continuation: Continuation<Unit>) : Status()
    class Yielded<P>(val continuation: Continuation<P>) : Status()
    class Resumed<R>(val continuation: Continuation<R>) : Status()
    object Dead : Status()
}

/**
 * 上下文
 */
interface CoroutineScope<P, R> {
    val parameter: P?

    /**
     * 获取返回值 并 挂起协程
     * [value]： 作为上一次 resume() 时的返回值
     * @return P 为下次恢复协程时 resume(v) 中传入的参数 v 。
     */
    suspend fun yield(value: R): P
}


/**
 * 生成器
 * Continuation
 */
class Coroutine<P, R>(
    override val context: CoroutineContext = EmptyCoroutineContext,
    private val block: suspend CoroutineScope<P, R>.(P) -> R
) : Continuation<R> {

    companion object {
        fun <P, R> create(
            context: CoroutineContext = EmptyCoroutineContext,
            block: suspend CoroutineScope<P, R>.(P) -> R
        ): Coroutine<P, R> {
            return Coroutine(context, block)
        }
    }

    private val scope = object : CoroutineScope<P, R> {
        override var parameter: P? = null


        // 此处挂起点的 P 为下次恢复协程时 resume(value) 中传入的值 value。
        // value 是 上一次 挂起点的返回值。
        override suspend fun yield(value: R): P = suspendCoroutine2<P> { continuation ->
            println("---------------- yield suspendCoroutine 1: $value, $continuation")
            val previousStatus = status.getAndUpdate {
                when (it) {
                    is Status.Created -> throw IllegalStateException("Never started!")
                    is Status.Yielded<*> -> throw IllegalStateException("Already yielded!")
                    is Status.Resumed<*> -> Status.Yielded(continuation)
                    Status.Dead -> throw IllegalStateException("Already dead!")
                }
            }
            var v = value
            if(v is Int) {
                v = -1 as R
            }
            // 恢复 resume() 状态的协程，并将 value 返回给之前挂起低地方
            (previousStatus as? Status.Resumed<R>)?.continuation?.resume(v)
            println("---------------- yield suspendCoroutine 2 resume: $v")
        }
    }

    private val status: AtomicReference<Status>

    val isActive: Boolean
        get() = status.get() != Status.Dead

    init {
        val coroutineBlock: suspend CoroutineScope<P, R>.() -> R = {
            block(parameter!!)
        }
        val start = coroutineBlock.createCoroutine(scope, this)
        status = AtomicReference(Status.Created(start))
    }

    override fun resumeWith(result: Result<R>) {
        val previousStatus = status.getAndUpdate {
            when (it) {
                is Status.Created -> throw IllegalStateException("Never started!")
                is Status.Yielded<*> -> throw IllegalStateException("Already yielded!")
                is Status.Resumed<*> -> {
                    Status.Dead
                }
                Status.Dead -> throw IllegalStateException("Already dead!")
            }
        }
        println("resumeWith: ${result}")
        (previousStatus as? Status.Resumed<R>)?.continuation?.resumeWith(result)
    }

    // 调用，挂起当前协程，并通过 continuation.resume(value) 恢复之前协程，并将参数value 也传递过去, (此处是传给 yield())
    suspend fun resume2(value: P): R = suspendCoroutine2 { continuation ->
        println("resume2: $value")

        val previousStatus = status.getAndUpdate {
            when (it) {
                is Status.Created -> {
                    scope.parameter = value
                    Status.Resumed(continuation)
                }
                is Status.Yielded<*> -> {
                    Status.Resumed(continuation)
                }
                is Status.Resumed<*> -> throw IllegalStateException("Already resumed!")
                Status.Dead -> throw IllegalStateException("Already dead!")
            }
        }

        when (previousStatus) {
            is Status.Created -> {
                println("previousStatus Status.Created 1")
                // 启动协程，执行协程体
                val r = previousStatus.continuation.resume(Unit)
                println("previousStatus Status.Created 2: $r")
            }
            is Status.Yielded<*> -> {
                println("previousStatus Status.Yielded 1: ${value} ")
                (previousStatus as Status.Yielded<P>).continuation.resume(value)
                println("previousStatus Status.Yielded 2: ${value} ")
            }
        }
    }

    suspend fun <SymT> SymCoroutine<SymT>.yield(value: R): P {
        return scope.yield(value)
    }
}

class Dispatcher : ContinuationInterceptor {

    override val key = ContinuationInterceptor

    private val executor = Executors.newSingleThreadExecutor()

    override fun <T> interceptContinuation(continuation: Continuation<T>): Continuation<T> {
        return DispatcherContinuation(continuation, executor)
    }
}

class DispatcherContinuation<T>(val continuation: Continuation<T>, val executor: Executor) :
    Continuation<T> by continuation {

    override fun resumeWith(result: Result<T>) {
        println("DispatcherContinuation resumeWith 1")
        executor.execute {
            println("DispatcherContinuation execute 1")
            continuation.resumeWith(result)
            println("DispatcherContinuation execute 2")
        }
        println("DispatcherContinuation resumeWith 2")
    }
}
// suspend fun main() 其实是一个协程体。Kotlin 编译器会帮我们生成真正的 main() 函数，并创建协程执行 suspend main()。
suspend fun main() {
    val producer = Coroutine.create<String, Int>(Dispatcher()) {
        for (i in 0..3) {
            println("send $i")
            yield(i)
        }
        200
    }

    val consumer = Coroutine.create<Int, String>(Dispatcher()) { param: Int ->
        println("start consumer $param")
        for (i in 0..3) {
            val value = yield("consumer")
            println("receiver $value")
        }
        ""
    }

    var i = 0
    while (producer.isActive && consumer.isActive) {
        val result = producer.resume2("producer$i") // 验证 挂起点恢复时获取到的同步返回值为 调用resume时传入的值。
        i ++
        println("------------------------------------------------------------------------------------------ 1 : $result,")
        val r2 = consumer.resume2(result)
        println("------------------------------------------------------------------------------------------ 2 : $r2")

    }
}


suspend fun <T> suspendCoroutine2( block: (Continuation<T>) -> Unit): T {
    return suspendCoroutine {
        println("suspendCoroutine start")
        block(it)
        println("suspendCoroutine end to getOrThrow")
    }
}
