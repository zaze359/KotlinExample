package com.zaze.kotlin.example.algorithm.n120

import kotlin.math.min

/**
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 每次只能移动到下一行相邻的节点,下标相同 或 下标 + 1
 * triangle[i][j] => triangle[i + 1][j] || triangle[i + 1][j + 1]
 *
 */
class Solution {

    /**
     * 动态规划
     *
     * dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1])
     */
    fun minimumTotal(triangle: List<List<Int>>): Int {
        // 由于是三角 第一排必然只有一个，数组长度 1,2,3,4 ... n
        if (triangle.isEmpty()) return 0
        if (triangle.size == 1) return triangle[0][0]
        // n * n 的空间，实际只有一半存储数据，其他的都浪费了
        // 赋值先都赋值为最大值
        val dp = Array(triangle.size) {
            IntArray(triangle.size) {
                Int.MAX_VALUE
            }
        }
        // 初始化第一个
        dp[0][0] = triangle[0][0]
        // 初始化 dp 第一个列
        for (i in 1 until triangle.size) {
            dp[i][0] = dp[i - 1][0] + triangle[i][0]
        }
        //
        for (i in 1 until triangle.size) {
            // 从1开始，0已经提前赋值
            for (j in 1 until triangle[i].size) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i][j]
            }
        }
        // 初始化最大
        var min = Int.MAX_VALUE
        val end = dp.size - 1
        for (i in dp[end].indices) {
            min = minOf(min, dp[end][i])
        }
        return min
    }
}