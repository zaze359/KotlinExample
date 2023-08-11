package com.zaze.kotlin.example.algorithm

import javax.swing.ListModel

class ListNode(var `val`: Int) {
    var next: ListNode? = null

    companion object {
        fun buildNode(array: IntArray): ListNode? {
            val root = ListNode(-1)
            var temp: ListNode? = root
            array.forEach {
                temp?.next = ListNode(it)
                temp = temp?.next
            }
            return root.next
        }
    }

    fun toList(): List<Int> {
        val list = mutableListOf<Int>()
        var root: ListNode? = this
        while (root != null) {
            list.add(root.`val`)
            root = root.next
        }
        return list
    }
}