package com.zaze.kotlin.example.algorithm.n103

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
     * 先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行
     */
    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        val queue = LinkedList<TreeNode>()
        val ret = LinkedList<List<Int>>()
        root?.let {
            queue.add(it)
        }
        var ltr = true
        while (queue.isNotEmpty()) {
            val levelSize = queue.size
            val tempList = LinkedList<Int>()
            repeat(levelSize) {
                // 处理顺序不变。
                val node = queue.pop() ?: return@repeat
                node.left?.let {
                    queue.add(it)
                }
                node.right?.let {
                    queue.add(it)
                }
                if (ltr) { // 从左到右, 先进先出，添加末尾
                    tempList.add(node.`val`)
                } else { // 从右到左, 后进先出，添加队首
                    tempList.push(node.`val`)
                }
            }
            ret.add(tempList)
            ltr = ltr.not()
        }
        return ret
    }
}