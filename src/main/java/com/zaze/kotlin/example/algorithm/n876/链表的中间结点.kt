package com.zaze.kotlin.example.algorithm.n876

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
    fun middleNode(head: ListNode?): ListNode? {
        head ?: return head
        // 快慢指针
        // 由于是求中间节点，所有 慢指针走一步，快指针走2步，这样快指针走到末尾时慢指针就是在中间
        var slow = head
        var fast = head
        // 对于奇数，fast 刚好遍历到 尾节点， slow在中间位置
        // 对于偶数, fast 遍历到尾节点.next，slow 位于第二个中间节点。
        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }
        return slow
    }
}