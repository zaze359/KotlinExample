package com.zaze.kotlin.example.algorithm.base.stack

import com.zaze.kotlin.example.algorithm.base.ListNode

/**
 * 基于链表的栈
 */
class LinkedListStack {
    var top: ListNode? = null

    fun push(item: Int) {
        val new = ListNode(item)
        new.next = top
        top = new
    }

    fun pop(): Int {
        return top?.let {
            val value = it.`val`
            top = it.next
            value
        } ?: -1
    }
}