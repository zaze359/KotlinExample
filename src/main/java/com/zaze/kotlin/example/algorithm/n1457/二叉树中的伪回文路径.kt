package com.zaze.kotlin.example.algorithm.n1457

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
     *  回文序列，正序和倒序相同。即偶数序列，每个数字都是成对存在，奇数序列，仅中间一个数字出现奇数次。
     *  伪回文，排序后能变为回文。
     *
     * dfs
     * 时间复杂度：O()
     * 空间复杂度: O(n), bfs 遍历需要n 长度的队列
     */
    fun pseudoPalindromicPaths(root: TreeNode?): Int {
        if (root == null) return 0
        // 数字返回 1~9
        // 使用固定长度的数组dp, 存储 下标对应数字出现的次数。
        val dp = IntArray(10)
        return dfs(root, dp)
    }

    private fun dfs(node: TreeNode?, dp: IntArray): Int {
        if (node == null) return 0
        dp[node.`val`]++
        var ans = 0
        if (node.left == null && node.right == null) {
            // 是叶子节点 统计一下奇数数字个数
            var oddCount = 0
            dp.forEach {
                if (it % 2 == 1) {
                    oddCount++
                }
            }
            if (oddCount <= 1) { // 没有奇数数字 或 仅1个奇数次的数字
                ans++
            }
        } else { // 有子节点，继续遍历
            ans = dfs(node.left, dp) + dfs(node.right, dp)
        }
        // 数字处理完后从dp中移除
        dp[node.`val`]--
        return ans
    }
}