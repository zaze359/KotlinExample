package com.zaze.kotlin.example.algorithm.n226

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
     * 层序遍历，交换左右节点
     */
    fun invertTree(root: TreeNode?): TreeNode? {
        root ?: return null
        // 暂存需要遍历的节点
        val queue = LinkedList<TreeNode?>()
        queue.add(root)
        while(queue.isNotEmpty()) {
            val node = queue.poll()
            val temp = node?.left
            node?.left = node?.right
            node?.right = temp
            node?.left?.let {
                queue.add(it)
            }
            node?.right?.let {
                queue.add(it)
            }
        }
        return root
    }
}