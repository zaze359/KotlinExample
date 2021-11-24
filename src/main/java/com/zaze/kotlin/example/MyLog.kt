package com.zaze.kotlin.example

object MyLog {
    fun i(tag: String, message: String) {
        println("$tag: $message")
    }

    fun println(tag: String, message: String) {
        i(tag, message)
    }
}