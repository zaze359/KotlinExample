package com.zaze.kotlin.example.algorithm.n21

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
    /**
     * 升序
     * 时间复杂度 O(n + m) 最大不会超过 m + n, n,m两个链表的长度，
     */
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        return when {
            list1 == null -> list2
            list2 == null -> list1
            else -> {
                var tempList1 = list1
                var tempList2 = list2
                // 先默认创建一个节点最后去除即可
                val root = ListNode(-1)
                var mergedList: ListNode? = root
                while (tempList1 != null || tempList2 != null) {
                    // 若某个列表为空 则直接使用 Int.MAX_VALUE 作为哨兵
                    if ((tempList1?.`val` ?: Int.MAX_VALUE) <= (tempList2?.`val` ?: Int.MAX_VALUE)) {
                        mergedList?.next = tempList1
                        tempList1 = tempList1?.next
                    } else {
                        mergedList?.next = tempList2
                        tempList2 = tempList2?.next
                    }
                    mergedList = mergedList?.next
                }
                root.next
            }
        }
    }

    /**
     * 递归法
     * 时间复杂度 O(n + m) 最大不会超过 m + n, n,m两个链表的长度，
     */
    fun mergeTwoLists2(list1: ListNode?, list2: ListNode?): ListNode? {
        return when {
            list1 == null -> list2
            list2 == null -> list1
            list1.`val` <= list2.`val` -> {
                list1.next = mergeTwoLists2(list1.next, list2)
                return list1
            }

            else -> {
                list2.next = mergeTwoLists2(list1, list2.next)
                return list2
            }
        }
    }
}