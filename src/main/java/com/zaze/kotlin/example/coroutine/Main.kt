package com.zaze.kotlin.example.coroutine

import com.zaze.kotlin.example.DateUtil
import com.zaze.kotlin.example.FileUtils
import com.zaze.kotlin.example.MyLog
import com.zaze.kotlin.example.ThreadPlugin
import kotlinx.coroutines.*
import java.io.File
import kotlin.concurrent.thread
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

fun main() {
    runBlocking {

        val file = File(".")
        log("file: ${file.absolutePath}")
        log("file: ${file.path}")

        println("--------------- fun a start ------------------")
        log("main start")
        log("main result: ${testSuspendable("testSuspendable")} ")
        log("main finish")

        FileUtils.deleteFile(File("testRes/async"))
        val start = System.currentTimeMillis()
        val async1 = async(start = CoroutineStart.LAZY) {
//            val asyncFile = File("testRes/async/1.txt")
//            while (asyncFile.length() < 1L shl 20) {
//                FileUtils.writeToFile("1111111111111111111111111", asyncFile, true)
//            }
            delay(1000L)
            System.currentTimeMillis() - start
        }
        val async2 = async(start = CoroutineStart.LAZY) {
//            val asyncFile = File("testRes/async/2.txt")
//            while (asyncFile.length() < 1L shl 20) {
//                FileUtils.writeToFile("2222222222222222222222222", asyncFile, true)
//            }
            delay(1000L)
            System.currentTimeMillis() - start
        }
        // start 和 未start 时间不同
        async1.start()
        async2.start()
        val one = async1.await()
        val two = async2.await()
        log("async $one+$two/${one + two}(${System.currentTimeMillis() - start}) finish")
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

fun download(url: String): String {
    log("Download start")
    System.getProperties().forEach {
        log("${it.key}=${it.value}")
    }
    repeat(10000) {
        FileUtils.writeToFile("1", File("testRes/src/writeToFile.txt"), true)
    }
    log("Download end")
    return url
}

private fun log(msg: String) {
    MyLog.i("coroutine: ${DateUtil.timeMillisToString()}", msg)
}