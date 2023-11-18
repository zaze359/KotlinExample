package com.zaze.kotlin.example.algorithm.n199

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
 *
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 */
class Solution {

    /**
     * BFS
     * 右视图 即 每一层的最后一个元素
     * 时间复杂度：O(n)
     * 空间复杂度: O(n)
     */
    fun rightSideView(root: TreeNode?): List<Int> {
        val retList = LinkedList<Int>()
        val queue = LinkedList<TreeNode?>()
        queue.add(root)
        while(queue.isNotEmpty()) {
            val levelSize = queue.size
            var node: TreeNode? = null
            repeat(levelSize) {
                node = queue.pop()
                node?.left?.let {
                    queue.add(it)
                }
                node?.right?.let {
                    queue.add(it)
                }
            }
            node?.let {// 记录最后一个
                retList.add(it.`val`)
            }
        }
        return retList
    }
}