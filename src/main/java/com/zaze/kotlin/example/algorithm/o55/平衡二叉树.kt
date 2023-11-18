package com.zaze.kotlin.example.algorithm.o55

import com.zaze.kotlin.example.algorithm.base.TreeNode


/**
 *  输入一棵二叉树的根节点，判断该树是不是平衡二叉树
 *  平衡二叉树： 左右子树的深度不超过1
 */
class Solution {
    fun isBalanced(root: TreeNode?): Boolean {
        if (root == null) {
            return true
        }
        val left = height(root.left)
        val right = height(root.right)
        return check(left, right)
    }

    // true：左右子树相差的深度不超过 1
    // left 或 right < 0 时则表示 已经不平衡，那么直接返回 false即可
    private fun check(left: Int, right: Int): Boolean {
        return left >= 0 && right >= 0 && Math.abs(left - right) <= 1
    }

    /**
     * 叶子节点：0
     * 非叶子节点：递归获取子树的高度。
     * 左右子树满足平衡，则 + 1，否则返回 -1 表示不平衡
     */
    private fun height(root: TreeNode?): Int {
        return when (root) {
            null -> 0 // 叶子节点 返回 0
            else -> { // 非叶子节点，获取 左右子树的高度
                val left = height(root.left)
                val right = height(root.right)
                // 检测是否平衡，若平衡则高度 + 1.
                // 不平衡返回 -1
                if (check(left, right)) {
                    Math.max(left, right) + 1
                } else {
                    -1
                }
            }
        }
    }
}