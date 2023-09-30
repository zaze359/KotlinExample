package com.zaze.kotlin.example.algorithm.n23

import com.zaze.kotlin.example.algorithm.ListNode

/**
 * 数组中的链表都已经按升序排列
 * 将所有链表合并到一个升序链表中
 */
class Solution {

    /**
     * 分治
     */
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if (lists.isEmpty()) return null
        return merge(lists, 0, lists.size - 1)
    }

    fun merge(lists: Array<ListNode?>, l: Int, r: Int): ListNode? {
        if (l == r) {
            return lists[l]
        }
        if (l > r) {
            return null
        }
        val mid = (l + r) shr 1
        // 将列表 进行拆分，两两合并
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r))
    }


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
     * 循环
     * 可以使用 优先级队列/小顶堆 优化
     */
    fun mergeKLists2(lists: Array<ListNode?>): ListNode? {
        if (lists.isEmpty()) return null
        // 存储各个链表的头指针，用于遍历
        var nullPointCount = 0
        val pointList = Array(lists.size) {
            val node = lists[it]
            if (node == null) {
                nullPointCount++
            }
            lists[it]
        }
        val root = ListNode(0)
        var mergeNode: ListNode? = root
        while (nullPointCount < lists.size - 1) {
            nullPointCount = 0
            var minPos = 0
            var preMin = Int.MAX_VALUE
            var min = Int.MAX_VALUE
            // m * n
            run loop@{
                pointList.forEachIndexed { index, listNode ->
                    when {
                        listNode == null -> {
                            nullPointCount++
                            return@forEachIndexed
                        }

                        listNode.`val` == preMin -> {
                            // 相同
                            min = listNode.`val`
                            minPos = index
                            return@loop
                        }

                        listNode.`val` < min -> {
                            min = listNode.`val`
                            minPos = index
                        }

                        else -> {}
                    }
                }
            }
            preMin = min
            mergeNode?.next = pointList[minPos]
            mergeNode = mergeNode?.next
            pointList[minPos] = pointList[minPos]?.next
        }
        mergeNode?.next = pointList.find { it != null }
        println("root: ${root.toList()}")
        return root.next
    }


}