package com.zaze.kotlin.example.algorithm.n141

import com.zaze.kotlin.example.algorithm.ListNode

/**
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {

    /**
     * 快慢指针
     * 若不存在环，则慢指针永远在快指针后面
     * 若存在环，则快指针会先进入环，然后慢指针后进入，最好情况就是 慢指针刚进入就相遇，最坏就是刚好错过，需要再执行 m - 1，m是环到长度。
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)，需求2个指针
     */
    fun hasCycle(head: ListNode?): Boolean {
        if (head?.next == null) {
            return false
        }
        var slow = head
        var fast = head.next
        while (fast != null) {
            if (slow == fast) {
                return true
            }
            slow = slow?.next
            fast = fast.next?.next
        }
        return false
    }

    /**
     * 哈希
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)， 需要使用Set 过滤
     */
    fun hasCycle2(head: ListNode?): Boolean {
        if (head?.next == null) {
            return false
        }
        val set = HashSet<ListNode>()
        var node = head
        while (node != null) {
            if (set.contains(node)) {
                return true
            }
            set.add(node)
            node = node.next
        }
        return false
    }

    /**
     * 修改节点的指向，将遍历过的节点都指向 head，从而和后续链表断开。
     * 若成环则必然会重新遍历到 HEAD。
     *
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)，需求2个指针
     *
     * 存在问题，将导致源数据被修改。
     */
    fun hasCycle3(head: ListNode?): Boolean {
        if (head?.next == null) {
            return false
        }
        var node = head
        var temp: ListNode
        while (node != null) {
            if (node.next == head) {
                return true
            }
            temp = node
            node = node.next
            temp.next = head
        }
        return false
    }

}