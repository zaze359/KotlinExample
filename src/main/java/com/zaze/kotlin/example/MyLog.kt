package com.zaze.kotlin.example

object MyLog {
    fun i(tag: String, message: String) {
        println("$tag: $message")
    }

    fun println(tag: String, message: String) {
        i(tag, message)
    }
}

fun log(tag: String, msg: String) {
    MyLog.i("${DateUtil.timeMillisToString()} $tag: ", msg)
}

fun logThread(tag: String = "", msg: String) {
    MyLog.i("${DateUtil.timeMillisToString()} ${Thread.currentThread().name} $tag: ", msg)
}