package com.zaze.kotlin.example.algorithm.n696

class Solution {

    /**
     * 找出三个长度为 k，互不重叠的子数组， 要求和最大。
     * 动态规划，
     * 时间复杂度: O(n)
     * 空间复杂度: O(n * m), 题目就中是三个子数组，m = 3
     */
    fun maxSumOfThreeSubarrays(nums: IntArray, k: Int): IntArray {
        val n = nums.size
        // 子数组个数
        val m = 3
        if (n < m * k) return nums
        // 记录 所有单个子数组的 和
        // sums[i] = nums[i] + ... + nums[i + k - 1]
        val sums = IntArray(n)
        for (i in 0..n - k) {
            repeat(k) {
                sums[i] += nums[i + it]
            }
        }
        // dp[i][j]，前i个元素中， j个无重叠子数组的最大和。
        // 状态转移方程:
        // 若第 i 个元素 不在最大和子数组中，dp[i][j] = dp[i - 1][j]
        // 若第 i 个元素 在最大和子数组中，[i - k + 1, i]
        //     dp[i][j] = dp[i - k][j - 1] + sum[i - k + 1]
        val dp = Array(n) {
            IntArray(m + 1)
        }
        // 初始值, 前 k -1
        dp[k - 1][1] = sums[0]
        // dp[n - 1][m] 就是最大和。
        for (i in k until n) {
            for (j in 1..m) {
                dp[i][j] = maxOf(dp[i - 1][j], dp[i - k][j - 1] + sums[i - k + 1])
            }
        }
        // 根据状态转移方程 回溯出结果，找出组成这个最大和的 子数组，且需要最小序号
        val ans = IntArray(3)
        // 此时得到 max = dp[n - 1][m]
        //
        val max = dp[n - 1][m]
        //
        var i = n - 1
        // dp 数组的特性 dp[i][m] >= dp[i - 1][m]
        // 当相同时，那么第 i 个元素无用，继续往前比对
        // dp[i][m] > dp[i - 1][m]。表示第 i 个元素有用，此时我们就确认了 第m个子数组一定是 [i - k + 1, i]
        // 找到后就可以不关心 m了，只要看m-1即可
        // 同理可以 一次遍历求出 0 ~ m 所有的子数组位置
        var c = m
        while (i > k-1 && c > 0) {
            when {
                dp[i][c] == dp[i - 1][c] -> {
                    i--
                }

                dp[i][c] > dp[i - 1][c] -> {
                    // i有用， 找到子数组 [i - k + 1, i]
                    // c - 1表示结果下标
                    c--
                    ans[c] = i - k + 1
                    // 往 i - k + 1 前面找 其他子数组
                    i -= k
                }

                else -> {}
            }
        }
        return ans
    }
}