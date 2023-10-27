package com.zaze.kotlin.example.algorithm.n322

/**
 * 一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 返回可以凑成总金额所需的 最少的硬币个数
 * 没有时返回 -1
 */
class Solution {
    /**
     * 动态规划
     * dp[n] 记录 n 总金额所需的最少硬币数。
     * dp[m] = dp[n - x] + 1 个x硬币
     *
     * 时间复杂度:O(S * n)，S总金额，n 不同币值
     * 空间复杂度: O(S)
     * [coins]: 不同面额的硬币
     * [amount]: 总金额
     * @return 最少的硬币个数
     */
    fun coinChange(coins: IntArray, amount: Int): Int {
        if (amount <= 0) return 0
        val max = amount + 1
        // 初始化 dp状态表，默认赋值为 总金额 + 1
        val dp = IntArray(max) { -1 }
        dp[0] = 0
        // 依次 遍历所有总金额的组合
        for (i in 0..amount) {
            // 每次都是从小到大遍依次取硬币更新状态
            // dp[i] == -1 表示没有组合
            if (dp[i] == -1) {
                // 跳到下一个
                continue
            }
            for (j in coins.indices) {
                val index = i + coins[j]
                // 超出了，直接跳过，index 可能越界导致为负值
                if (index < 0 || index > amount) continue
                if (dp[index] == -1) {
                    dp[index] = dp[i] + 1
                } else {
                    dp[index] = Math.min(dp[index], dp[i] + 1)
                }
            }
        }
        return dp[amount]
    }
}