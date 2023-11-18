package com.zaze.kotlin.example.algorithm.base

/**
 * 链表节点
 */
class ListNode(var `val`: Int) {
    var next: ListNode? = null

    companion object {
        /**
         * [pos]: 尾节点指向的节点位置，pos >= 0 表示链表成环
         */
        fun buildNode(array: IntArray, pos: Int = -1): ListNode? {
            val root = ListNode(-1)
            var temp: ListNode? = root
            var posNode: ListNode? = null
            array.forEachIndexed { i, value ->
                temp?.next = ListNode(value)
                if (i == pos) {
                    posNode = temp?.next
                }
                temp = temp?.next
            }
            // 尾节点赋值，默认指向 null，需要成环时指向 pos
            temp?.next = posNode
            return root.next
        }
    }

    fun toList(): List<Int> {
        val set = HashSet<ListNode>()
        val list = mutableListOf<Int>()
        var root: ListNode? = this
        while (root != null && !set.contains(root)) {
            set.add(root)
            list.add(root.`val`)
            root = root.next
        }
        return list
    }
}