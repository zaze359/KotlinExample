package com.zaze.kotlin.example.algorithm.n152

/**
 * 整数数组 nums,找出数组中乘积最大的非空连续子数组
 */
class Solution {

    /**
     * 动态规划
     * dp[n] = Math.max(nums[n] * nums[n - 1], dp[n -1] * nums[n])
     * 由于存在负数，最小值可能就变成最大值，所以这里记录最大最小
     *
     * 时间复杂度：O(n)
     * 空间复杂度: O(n)
     */
    fun maxProduct2(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        // dp 记录 连续最大或最小乘积
        // 因为存在 负数，最小值可能就变成最大值，记录最大最小
        val dp = Array(nums.size) {
            IntArray(2)
        }
        dp[0][0] = nums[0]
        dp[0][1] = nums[0]
        var ans = nums[0]
        // 记录临时计算数据
        val temp = IntArray(4)
        for (i in 1 until nums.size) {
            temp[0] = nums[i]
            // 相邻两数乘积
            temp[1] = nums[i] * nums[i - 1]
            // 之前的最大乘积 * 当前
            temp[2] = dp[i - 1][0] * nums[i]
            // 之前的最小乘积 * 当前
            temp[3] = dp[i - 1][1] * nums[i]
            // 选择最大最小。这里是固定4次循环，
            temp.forEach {
                dp[i][0] = maxOf(dp[i][0], it)
                dp[i][1] = minOf(dp[i][1], it)
            }
            ans = maxOf(ans, dp[i][0])
        }
        return ans
    }

    /**
     * 进行空间优化
     * dp 中每次都仅使用的 上一个 最大最小，之前的其实都没用，所以可以仅记录最近的最大最小
     * 时间复杂度：O(n)
     * 空间复杂度: O(1)
     */
    fun maxProduct(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        var max = nums[0]
        var min = nums[0]
        var ans = nums[0]
        // 记录临时计算数据
        val temp = IntArray(4)
        for (i in 1 until nums.size) {
            temp[0] = nums[i]
            // 相邻两数乘积
            temp[1] = nums[i - 1] * nums[i]
            // 之前的最大乘积 * 当前
            temp[2] = max * nums[i]
            // 之前的最小乘积 * 当前
            temp[3] = min * nums[i]
            // 选择最大最小。先重置下最大最小
            max = temp[0]
            min = temp[0]
            // 这里是固定3次循环，
            for(j in 1 until  temp.size) {
                max = maxOf(max, temp[j])
                min = minOf(min, temp[j])
            }
            // 和之前比较
            ans = maxOf(ans, max)
        }
        return ans
    }
}