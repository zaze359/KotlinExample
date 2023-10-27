package com.zaze.kotlin.example.algorithm.n1155

/**
 *  n 个一样的骰子，每个骰子上都有 k 个面
 *  求 和 target 可能的组合数
 */
class Solution {
    companion object {
        const val mod = 1000000007
    }

    /**
     * 动态规划
     * 状态：记录 每次投掷可能产生的所有结果的方案数。
     *
     * 时间复杂度：O(n * k * target)
     * 空间复杂度：O(n * target)
     */
    fun numRollsToTarget(n: Int, k: Int, target: Int): Int {
        if (target < n) return 0
        // 定义 dp 状态数组，记录 第n次筛子时对应和的方案数量
        val dp = Array(n + 1) {
            IntArray(target + 1)
        }
        // 不投掷筛子，且和为0
        dp[0][0] = 1
        // 状态转移方程：dp[i][j] = dp[i - 1][j] - j
        for (i in 1..n) {
            for (j in 1..target) { // 第 i 次，和为 j
                for (num in 1..k) {
                    if (j - num >= 0) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - num]) % mod
                    }
                }
            }
        }
        return dp[n][target]
    }
}