package com.zaze.kotlin.example.algorithm.n102

import com.zaze.kotlin.example.algorithm.TreeNode
import java.util.*

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        var levelList = mutableListOf<Int>()
        // 用于记录需要输出的节点
        val queue = LinkedList<TreeNode>()
        // 首先添加自己
        root?.let {
            queue.add(it)
        }
        while (queue.isNotEmpty()) {
            val levelSize = queue.size
            // 当前在队列中的就是当前层的节点
            repeat(levelSize) {
                // 取出自己，然后将左右节点加入到队列中
                val first = queue.poll()
                levelList.add(first.`val`)
                // 添加 左右子节点到队列中
                first.left?.let {
                    queue.add(it)
                }
                first.right?.let {
                    queue.add(it)
                }
            }
            result.add(levelList)
            levelList = mutableListOf()
        }
        return result
    }
}