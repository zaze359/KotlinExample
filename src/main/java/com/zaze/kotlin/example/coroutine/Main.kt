package com.zaze.kotlin.example.coroutine

import com.zaze.kotlin.example.*
import com.zaze.kotlin.example.coroutine.lua.CoroutineScope
import kotlinx.coroutines.*
import java.io.File
import kotlin.concurrent.thread
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine


val tag = "coroutine"


fun main() = runBlocking {
//    println("main 1 ${currentCoroutineContext()}")
//    val deferred: Deferred<String> = async {
//        println("main 2 ${currentCoroutineContext()}")
//        println("In async:${Thread.currentThread().name}")
//        delay(1000L) // 模拟耗时操作
//        println("In async after delay!")
//        return@async "Task completed!"
//    }
//    println("main 3 ${currentCoroutineContext()}")
//    // 不再调用 deferred.await()
//    delay(2000L)
//    println("main 4 ${currentCoroutineContext()}")
//    println("main end!")
//
    withContext(Dispatchers.Default) {
        repeat(100) {
//            println("context Default: ${Thread.currentThread()}")
            delay(100)
        }
    }
    MainScope()

    withContext(Dispatchers.IO) {
        repeat(1000) {
            println("context IO: ${Thread.currentThread()}")
            delay(1000)
        }
    }

//    main2()
}

fun main2() = runBlocking {
    log(tag, "---- start");

    launch(Dispatchers.IO) {
        repeat(10) {
            log(tag, "launching")
            delay(100L)
        }
    }
//        val result = testSuspendable("testSuspendable")
//        log(tag, "main result: $result ")

    withContext(ThreadPlugin.testExecutorStub.coroutineDispatcher) {
        log(tag, "aaaa: ${aa()}")
    }

//    withContext(Dispatchers.IO) {
//        val file = File(".")
//        log(tag, "file: ${file.absolutePath}")
//        log(tag, "file: ${file.path}")
//
//        println("--------------- fun a start ------------------")
//        log(tag, "main start")
    log(tag, "main result: ${testSuspendable("testSuspendable")} ")

//        log(tag, "main finish")
//
//        FileUtils.deleteFile(File("testRes/async"))
//        val start = System.currentTimeMillis()
//        val async1 = async(start = CoroutineStart.LAZY) {
//            delay(1000L)
//            System.currentTimeMillis() - start
//        }
//        val async2 = async(start = CoroutineStart.LAZY) {
//            delay(1000L)
//            System.currentTimeMillis() - start
//        }
//        // start 和 未start 时间不同
//        async1.start()
//        async2.start()
//        val one = async1.await()
//        val two = async2.await()
//        log(tag, "async $one+$two/${one + two}(${System.currentTimeMillis() - start}) finish")
//    }
    log(tag, "---- finish");

}

private fun startCoroutine() {
    // funTest协程体
//    val funTest: suspend CoroutineScope.() -> Unit = {
//        println("funTest")
////        suspendFun1()
////        suspendFun2()
//    }
//    GlobalScope.launch(Dispatchers.Default, block = funTest)
}

suspend fun testSuspendable(url: String): Any? {
    log(tag, "---- testSuspendable start");
    val res: Any? = suspendCoroutine { continuation ->
//        thread {
//            try {
//                // 将正常的结果返回
////                continuation.resume(download(url))
//                continuation.resume("url")
//            } catch (e: Exception) {
//                // 将异常返回
//                continuation.resumeWithException(e)
//            }
//        }
        log(tag, "---- suspendCoroutine");
    }

    log(tag, "---- testSuspendable end $res");
    return res
}

fun download(url: String): String {
    log(tag, "Download start $url")

//    System.getProperties().forEach {
//        log(tag, "${it.key}=${it.value}")
//    }
    val file = File("testRes/src/writeToFile.txt");
    FileUtils.deleteFile(file)
    repeat(10000) {
        FileUtils.writeToFile(
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
            file,
            true
        )
    }
    val result = FileUtils.readFromFile(file).toString().substring(0, 10)
    log(tag, "Download end $result")
    return result
}


suspend fun aa(): String = suspendCoroutine {
    Thread(Runnable {
        GlobalScope.launch {
            delay(1000L)
        }
        it.resumeWith(Result.success("aa: 123123"))
    }).start()
}

