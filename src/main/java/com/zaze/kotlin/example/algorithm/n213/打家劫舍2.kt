package com.zaze.kotlin.example.algorithm.n213

class Solution {

    fun rob(nums: IntArray): Int {
        if (nums.size == 1) {
            return nums[0]
        }
        if (nums.size == 2) {
            return Math.max(nums[0], nums[1])
        }
        return Math.max(robRoom(nums, 0, nums.size - 2), robRoom(nums, 1, nums.size - 1))
    }

    private fun robRoom(nums: IntArray, start: Int, end: Int): Int {
        val dp = IntArray(nums.size)
        dp[start] = nums[start]
        var max = Math.max(nums[start], nums[start + 1])
        dp[start + 1] = max
        for (i in (start + 2)..end) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1])
            if (dp[i] > max) {
                max = dp[i]
            }
        }
        return max
    }


    private var maxMoney = 0

    // 递归, 耗时
    fun rob2(nums: IntArray): Int {
        maxMoney = 0
        if (nums.size == 1) {
            return nums[0]
        }
        if (nums.size == 2) {
            return Math.max(nums[0], nums[1])
        }
        robRoom2(nums, 0, 0, false)
        return maxMoney
    }

    private fun robRoom2(nums: IntArray, position: Int, money: Int, firstRobbed: Boolean) {
        if (position >= nums.size || (position == nums.size - 1 && firstRobbed)) {
            // 终止条件
            // 1. 超出边界
            // 2. 最后一个并且第一个被偷，
            if (money > maxMoney) {
                maxMoney = money
            }
            return
        }
        robRoom2(nums, position + 1, money, firstRobbed or false) // 不偷，看看下一个偷不偷
        robRoom2(nums, position + 2, money + nums[position], firstRobbed or (position == 0)) // 偷，隔一个偷
    }
}