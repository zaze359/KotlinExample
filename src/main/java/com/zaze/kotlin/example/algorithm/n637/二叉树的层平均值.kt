package com.zaze.kotlin.example.algorithm.n637

import com.zaze.kotlin.example.algorithm.base.TreeNode
import java.util.LinkedList

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
    /**
     * 求层平均值
     * BFS
     * 时间复杂度：O(n)
     * 空间复杂度: O(n)
     */
    fun averageOfLevels(root: TreeNode?): DoubleArray {
        root ?: return DoubleArray(0)
        val retList = LinkedList<Double>()
        val queue = LinkedList<TreeNode?>()
        queue.add(root)
        while (queue.isNotEmpty()) {
            val size = queue.size
            var sum = 0L // 防止Int越界
            repeat(size) {
                val node = queue.pop()
                sum += node?.`val` ?: 0
                node?.left?.let {
                    queue.add(it)
                }
                node?.right?.let {
                    queue.add(it)
                }
            }
            retList.add(1.0 * sum / size)
        }
        return retList.toDoubleArray()
    }
}