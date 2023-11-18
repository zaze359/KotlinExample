package com.zaze.kotlin.example.algorithm.n117

import java.util.*

/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var left: Node? = null
 *     var right: Node? = null
 *     var next: Node? = null
 * }
 */
class Solution {

    /**
     * 使用常量级额外空间
     * 时间复杂度： O(n)
     * 空间复杂度：O(1)
     */
    fun connect(root: Node?): Node? {
        root ?: return null
        // 这里可以使用两个 node 来记录当前层 和下一层。同一层的节点相连
        var curNode: Node? = root // 当前层，用于遍历
        var nextLayerRoot: Node? = null // 记录下层的头节点
        var nextLayerNode: Node? = null // 下一层
        var temp: Node? = null // 临时处理
        // BFS
        while (curNode != null) {
            // 先串联当前节点左右子节点，左节点next指向右节点
            curNode.left?.next = curNode.right
            temp = curNode.left ?: curNode.right
            if (nextLayerNode == null) { // 新层的开始
                nextLayerRoot = temp
                nextLayerNode = nextLayerRoot
            } else {
                nextLayerNode.next = temp
            }
            while (nextLayerNode?.next != null) { // 指向最后一个
                nextLayerNode = nextLayerNode.next
            }
            // 判断当前层是否还有下一个节点，没有表示遍历结束，执行下层。
            if (curNode.next == null) {
                curNode = nextLayerRoot
                nextLayerRoot = null
                nextLayerNode = null
            } else { // 存在，处理下一个
                curNode = curNode.next
            }
        }
        return root
    }
}

class Node(var `val`: Int) {
    var left: Node? = null
    var right: Node? = null
    var next: Node? = null

    companion object {
        private fun createNode(value: Int?): Node? {
            return value?.let {
                Node(it)
            }
        }

        /**
         * 给定一个数组 构建一颗二叉树
         * [list]: 数组数据
         */
        fun buildTree(list: List<Int?>): Node? {
            if (list.isEmpty()) return null
            val queue = LinkedList<Node?>() // 基于链表的 双端队列
            val root = createNode(list[0])
            queue.add(root)
            var index = 0
            while (index < list.size) {
                val firstNode = queue.poll()
                if (firstNode != null) {
                    index++
                    if (index < list.size) {
                        firstNode.left = createNode(list[index]).also {
                            queue.add(it)
                        }
                    }
                    index++
                    if (index < list.size) {
                        firstNode.right = createNode(list[index]).also {
                            queue.add(it)
                        }
                    }
                }
            }
            return root
        }
    }

    /**
     * 按层序遍历输出 next，#表示每层的末尾
     * 1,#,2,3,#,4,5,7,#
     */
    fun printNext(): String {
        val ans = LinkedList<String>()
        var temp: Node? = this
        var firstNode: Node? = null
        while (temp != null) {
            ans.add(temp.`val`.toString())
            if (firstNode == null) {
                // 找到下层的第一个节点
                firstNode = temp?.left ?: temp?.right
            }
            temp = temp.next
            if (temp == null) { // 一层处理完
                ans.add("#")
                temp = firstNode
                firstNode = null
            }
        }
        val builder = StringBuilder()
        ans.forEach {
            if (builder.isEmpty()) {
                builder.append(it)
            } else {
                builder.append(",$it")
            }
        }
        return builder.toString()
    }
}