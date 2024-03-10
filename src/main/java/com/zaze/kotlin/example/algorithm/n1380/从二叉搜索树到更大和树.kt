package com.zaze.kotlin.example.algorithm.n1380

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
    private var sum = 0

    /**
     * [root]: 二叉搜索树，右子树节点都大于root，左子树节点都小于root
     *
     * 递归
     * 反向中序遍历
     *
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)， 递归栈空间
     */
    fun bstToGst(root: TreeNode?): TreeNode? {
        root ?: return null
        // 先处理右子树，这里的值大，其他节点都需要加上这些值。
        // 一直递归，从最右子节点开始处理, 它最大
        bstToGst(root.right)
        // 当前节点 + 右子树节点和
        sum += root.`val`
        // 更新当前节点值
        root.`val` = sum
        // 处理左子树，左子树的值至少需要增加 sum
        bstToGst(root.left)
        return root
    }
}