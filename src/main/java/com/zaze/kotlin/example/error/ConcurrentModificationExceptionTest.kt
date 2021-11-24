package com.zaze.kotlin.example.error

import com.zaze.kotlin.example.MyLog
import java.util.*
import kotlin.collections.ArrayList


fun main() {
//    Thread(Runnable {
//        while (true) {
//            Thread.sleep(100L)
//            modifyList()
//        }
//
//    }).start()
//    while (true) {
//        foreachList()
//    }
}


private val forEachList = ArrayList<String>()
private fun modifyList() {
    forEachList.clear()
    forEachList.addAll(listOf("1", "1", "1", "1", "1", "1", "1"))
    MyLog.println("list", "modifyList")
}

private fun foreachList() {
    forEachList.forEach {
        MyLog.println("list", "foreachList")
    }
}

private val stack = Stack<String>()
private fun modifyStack() {
    stack.clear()
    stack.push("1")
    stack.push("1")
    stack.push("1")
    stack.push("1")
    MyLog.println("stack", "modifyStack")
}

private fun peekStack() {
    stack.peek()
}