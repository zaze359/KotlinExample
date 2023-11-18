package com.zaze.kotlin.example.algorithm.n112

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
 * 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum
 */
class Solution {

    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
//        return hasPathSum1(root, targetSum)
//        return hasPathSum2(root, targetSum)
        return hasPathSum3(root, targetSum)
    }

    /**
     * 递归,DFS
     * 时间复杂度：O(n)
     * 空间复杂度：O(logn)，树的高度，最坏可能是 O(n)，树呈现为链状。
     */
    fun hasPathSum1(root: TreeNode?, targetSum: Int): Boolean {
        root ?: return false
        if (root.left == null && root.right == null) {
            return targetSum == root.`val`
        }
        return hasPathSum(root.left, targetSum - root.`val`)
                || hasPathSum(root.right, targetSum - root.`val`)
    }

    /**
     * BFS, 使用队列，先进先出
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    fun hasPathSum2(root: TreeNode?, targetSum: Int): Boolean {
        root ?: return false
        if (root.left == null && root.right == null) {
            return targetSum == root.`val`
        }

        val queue = LinkedList<TreeNode?>()
        // 记录当前节点对应对应的 sum值
        val sumQueue = LinkedList<Int>()
        // 添加到末尾
        queue.add(root)
        sumQueue.add(root.`val`)
        while (queue.isNotEmpty()) {
            // 获取第一个元素
            val node = queue.poll()
            val sum = sumQueue.poll() ?: 0
            if(node?.left == null && node?.right == null && sum == targetSum) {
                // 遍历到这个叶子节点时，sum == targetSum
                return true
            }
            // 从队首获取数据，先添加左 就先处理, 后添加右，后处理
            node?.left?.let {
                queue.add(it)
                sumQueue.add(sum + it.`val`)
            }
            node?.right?.let {
                queue.add(it)
                sumQueue.add(sum + it.`val`)
            }
        }
        return false
    }


    /**
     * DFS, 利用栈，后进先出的特性，这里使用 LinkedList 实现
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    fun hasPathSum3(root: TreeNode?, targetSum: Int): Boolean {
        root ?: return false
        if (root.left == null && root.right == null) {
            return targetSum == root.`val`
        }

        val queue = LinkedList<TreeNode?>()
        // 记录当前节点对应对应的 sum值
        val sumQueue = LinkedList<Int>()
        queue.push(root)
        sumQueue.push(root.`val`)
        while (queue.isNotEmpty()) {
            // 获取队首
            val node = queue.pop()
            val sum = sumQueue.pop()
            if(node?.left == null && node?.right == null && sum == targetSum) {
                // 遍历到这个叶子节点时，sum == targetSum
                return true
            }
            // 先添加到队首
            node?.right?.let {
                queue.push(it)
                sumQueue.push(sum + it.`val`)
            }
            // 后添加到队首，优先处理左节点
            node?.left?.let {
                queue.push(it)
                sumQueue.push(sum + it.`val`)
            }
        }
        return false
    }
}