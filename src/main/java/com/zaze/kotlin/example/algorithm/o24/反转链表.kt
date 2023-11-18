package com.zaze.kotlin.example.algorithm.o24

import com.zaze.kotlin.example.algorithm.base.ListNode

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        var curNode: ListNode? = head
        var reverseHead: ListNode? = null

        var next: ListNode?
        while (curNode != null) {
            // 取出，暂存原始到后续链表
            next = curNode.next
            // 将当前节点作为 已反转列表的父节点
            curNode.next = reverseHead
            // 更新反转链表的head
            reverseHead = curNode
            // 继续处理 后续链表
            curNode = next
        }
        return reverseHead
    }
}