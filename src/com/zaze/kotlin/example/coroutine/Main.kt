package com.zaze.kotlin.example.coroutine

import com.zaze.kotlin.example.DateUtil
import com.zaze.kotlin.example.MyLog
import java.io.File
import kotlin.concurrent.thread
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

suspend fun main() {
    log("main start")
    log("main result: ${testSuspendable("testSuspendable")} ")
    log("main finish")
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
    Thread.sleep(1000L)
    System.getProperties().forEach {
        log("${it.key}=${it.value}")
    }
    log("Download")
    return url
}

private fun log(msg: String) {
    MyLog.i("coroutine: ${DateUtil.timeMillisToString()}", msg)
}