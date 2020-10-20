package com.zaze.kotlin.example.coroutine

import com.zaze.kotlin.example.DateUtil
import com.zaze.kotlin.example.MyLog
import java.lang.Exception
import javax.xml.crypto.Data
import kotlin.concurrent.thread
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

suspend fun main() {
    MyLog.i(DateUtil.timeMillisToString(), "main start")
    val result = testSuspendable("testSuspendable")
    MyLog.i(DateUtil.timeMillisToString(), result)
    MyLog.i(DateUtil.timeMillisToString(), "main finish")
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
    Thread.sleep(2000L)
    return url
}