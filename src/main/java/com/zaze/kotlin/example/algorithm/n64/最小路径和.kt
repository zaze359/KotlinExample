package com.zaze.kotlin.example.algorithm.n64

/**
 *
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 每次只能向下或者向右移动一步
 */
class Solution {

    /**
     * 动态规划
     *
     * f[i][j] = f[i - 1][j] || f[i][j - 1] + 当前路径长度
     * 时间复杂度：O(mn)
     * 空间复杂度：O(mn)
     */
    fun minPathSum(grid: Array<IntArray>): Int {
        if (grid.isEmpty()) return 0
        val m = grid.size // 行
        val n = grid[0].size // 列
        val dp = Array(m) {
            IntArray(n)
        }
        //初始化左上角
        dp[0][0] = grid[0][0]
        // 初始化第一列(每行第一个元素)，只能从上边演变过来
        for (i in 1 until  m) {
            dp[i][0] = grid[i][0] + dp[i - 1][0]
        }
        // 初始化第一排 (每列第一个元素)，只能从左边列演变过来列状态
        for (j in 1 until n) {
            dp[0][j] = grid[0][j] + dp[0][j - 1]
        }
        // 处理其他元素
        for (i in 1 until m) {
            for (j in 1 until n) {
                // 只能下、右移动，所以 当前状态只可能从 上边 或者 左边得到
                // 当前路径值 + min(上方最小路径，左边最小路径)
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1])
            }
        }
        return dp[m - 1][n - 1]
    }
}