package com.zaze.kotlin.example.algorithm.n53


/**
 * 超出具有最大和的 连续子数组
 */
class Solution {

    /**
     * 动态规划:
     *
     * 在遍历过程中 进行求和，因为顺序遍历，所以和就是 连续子数组的和。
     *
     * 若和大于0，那么就继续连续，可能可以得到最大值。
     * 若变为负，表示中断数组，和负数相加必然不可能得到最大，后面数字重新开始求和
     * 遍历过程中记录 最大和
     *
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    fun maxSubArray(nums: IntArray): Int {
        if(nums.isEmpty()) return 0
        if(nums.size == 1) return nums[0]
        var max = nums[0]
        var sum = 0
        nums.forEach {
            sum += it
            max = maxOf(max, sum)
            if(sum <= 0) { // 只有 > 0 才有连续的必要，<= 就重新找子数组
                sum = 0
            }
        }
        return max
    }
}