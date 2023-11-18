package com.zaze.kotlin.example.algorithm.n105

import com.zaze.kotlin.example.algorithm.base.TreeNode

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
    val inorderMap = HashMap<Int, Int>()

    /**
     * @param [preorder] 前序遍历
     * @param [inorder] 中序遍历
     */
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        inorderMap.clear()
        if (preorder.isEmpty() || inorder.isEmpty() || (preorder.size != inorder.size)) {
            return null
        }
        inorder.forEachIndexed { index, i ->
            inorderMap[i] = index
        }
        return toBuildTree(preorder, inorder, 0, preorder.size - 1, 0, inorder.size - 1)
    }

    /**
     * 根据 left, right 来表示树在前序或中序中的区间
     * @param [preorder] 前序遍历
     * @param [inorder] 中序遍历
     * @param [preLeft] 前序-左边界
     * @param [preRight] 前序-右边界
     * @param [inLeft] 中序-左边界
     * @param [inRight] 中序-右边界
     */
    private fun toBuildTree(
        preorder: IntArray,
        inorder: IntArray,
        preLeft: Int,
        preRight: Int,
        inLeft: Int,
        inRight: Int
    ): TreeNode? {
        if (preLeft > preRight || inLeft > inRight) {
            return null
        }
        // 前序遍历的第一个节点就是根节点
        val rootIndex = preLeft
        //
        val rootNode = TreeNode(preorder[rootIndex])
        // 查找根节点在中序遍历中的位置，它的左边是左子树，右边是右子树。
        val tempIndex = inorderMap[rootNode.`val`] ?: return null

        // 递归处理左子树
        // 在中序遍历树中：中序的左边界 到 根节点位置都是 左子树
        // 左子树的长度
        val leftLength = tempIndex - inLeft
        // 左子树-前序：left = 根节点后一个，right = left + leftLength
        // 左子树-中序：left = 还是原来的左边界inLeft, right = 根节点前一个位置
        rootNode.left = toBuildTree(
            preorder, inorder,
            preLeft = preLeft + 1,
            preRight = preLeft + leftLength,
            inLeft = inLeft,
            inRight = tempIndex - 1
        )

        // 递归处理右子树：
        // 在中序遍历树中：根节点位置 到 中序的右边界都是 右子树, 右子树一直在最后边
        // 右子树-前序：left = preLeft + leftLength + 1，right = 还是原来的右边界
        // 右子树-中序：left = 根节点后一个位置, right = 还是原来的右边界inRight
        rootNode.right = toBuildTree(
            preorder, inorder,
            preLeft = preLeft + leftLength + 1,
            preRight = preRight,
            inLeft = tempIndex + 1,
            inRight = inRight
        )
        return rootNode
    }
}
