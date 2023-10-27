package com.zaze.kotlin.example.algorithm.n98

import com.zaze.kotlin.example.algorithm.TreeNode
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
     * 记录的是中序遍历的最近一个结果
     */
    var preVal = Long.MIN_VALUE

    /**
     * 二叉搜索树
     * 1. 节点的左子树只包含 小于 当前节点的数。
     * 2. 节点的右子树只包含 大于 当前节点的数。
     * 3. 所有左子树和右子树自身必须也是二叉搜索树。
     * 中序遍历是，是有序的，从小到大。
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)，存在递归
     */
    fun isValidBST(root: TreeNode?): Boolean {
        if (root == null) return true
        val curVal = root.`val`.toLong()
        val leftVal = root.left?.`val`?.toLong() ?: Long.MIN_VALUE
        val rightVal = root.right?.`val`?.toLong() ?: Long.MAX_VALUE
        if (curVal <= leftVal || curVal >= rightVal) {
            // 先检测一下节点自身，是否符合 左小右大，提前退出
            return false
        }
        // 遍历左子树
        if (!isValidBST(root.left)) return false
        // 和 上一个遍历结果比较，由于是中序遍历，理应比上一个值大。
        if (curVal <= preVal) return false
        // 满足条件，更新结果，用于下一个比较
        preVal = curVal
        // 遍历右子树
        return isValidBST(root.right)
    }
}