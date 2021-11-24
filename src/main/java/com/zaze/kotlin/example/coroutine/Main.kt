package com.zaze.kotlin.example.coroutine

import com.zaze.kotlin.example.*
import kotlinx.coroutines.*
import sun.jvm.hotspot.CommandProcessor
import sun.tools.util.CommandLine
import java.io.File
import kotlin.concurrent.thread
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine


val tag = "coroutine"

fun main() {
    runBlocking {
        withContext(ThreadPlugin.testExecutorStub.coroutineDispatcher) {
            log(tag, "aaaa: ${aa()}")
        }
        withContext(Dispatchers.IO) {
            val file = File(".")
            log(tag, "file: ${file.absolutePath}")
            log(tag, "file: ${file.path}")

            println("--------------- fun a start ------------------")
            log(tag, "main start")
            log(tag, "main result: ${testSuspendable("testSuspendable")} ")
            log(tag, "main finish")

            FileUtils.deleteFile(File("testRes/async"))
            val start = System.currentTimeMillis()
            val async1 = async(start = CoroutineStart.LAZY) {
                delay(1000L)
                System.currentTimeMillis() - start
            }
            val async2 = async(start = CoroutineStart.LAZY) {
                delay(1000L)
                System.currentTimeMillis() - start
            }
            // start 和 未start 时间不同
            async1.start()
            async2.start()
            val one = async1.await()
            val two = async2.await()
            log(tag, "async $one+$two/${one + two}(${System.currentTimeMillis() - start}) finish")
        }
        log(tag, "async 123123");
    }
}


suspend fun testSuspendable(url: String): String {
    return suspendCoroutine<String> { continuation ->
        thread {
            try {
                // 将正常的结果返回
                continuation.resume(download(url))
            } catch (e: Exception) {
                // 将异常返回
                continuation.resumeWithException(e)
            }
        }
    }
}

suspend fun aa(): String = suspendCoroutine {
    Thread(Runnable {
        GlobalScope.launch {
            delay(1000L)
        }
        it.resumeWith(Result.success("aa: 123123"))
    }).run()
}


fun download(url: String): String {
    log(tag, "Download start")
    Thread.sleep(10000L)
//    System.getProperties().forEach {
//        log(tag, "${it.key}=${it.value}")
//    }
//    repeat(10000) {
//        FileUtils.writeToFile("1", File("testRes/src/writeToFile.txt"), true)
//    }
    log(tag, "Download end")
    return url
}