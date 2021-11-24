package com.zaze.kotlin.example

fun log(tag: String, msg: String) {
    MyLog.i("${DateUtil.timeMillisToString()} $tag: ", msg)
}