package com.zaze.kotlin.example.algorithm.n2304

class Solution {
    /**
     * [grid]: mxn的网格， grid[i][j]表示 i行j列的元素
     * [moveCost]: moveCost[i][j] 元素值 i 到下一层中第j个位置元素的边长。
     * 空间复杂度: O(m*n*n)
     * 时间复杂度: O(m*n)
     */
    fun minPathCost(grid: Array<IntArray>, moveCost: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        // dp[i][j] 表示从第0行到 第 i 行 j列的最小路径
        val dp = Array<IntArray>(m) {
            IntArray(n){
                Int.MAX_VALUE
            }
        }
        // m * n * n
        for(i in 0 until m) {
            for(j in 0 until n) {
                if(i == 0) { // 第0行 最小路径就是 元素值
                    dp[0][j] = grid[0][j]
                    continue
                }
                val curVal = grid[i][j]
                // 遍历上一层所有元素的最小路径，dp[i - 1][k]
                // 然后再加上元素到该层 J 的边长
                for (k in 0 until n) {
                    val temVal = grid[i-1][k]
                    dp[i][j] = minOf(dp[i][j], dp[i - 1][k] + moveCost[temVal][j] + curVal)
                }
            }
        }
        var min = dp[m - 1][0]
        for(i in 1 until n) {
            min = minOf(min, dp[m - 1][i])
        }
        return min
    }
}