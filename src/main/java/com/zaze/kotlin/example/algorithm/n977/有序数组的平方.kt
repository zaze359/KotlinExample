package com.zaze.kotlin.example.algorithm.n977

/**
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序
 * [-2, -1, 0 , 1]
 * [0, 1, 1, 4]
 */
class Solution {
    /**
     * 双指针
     * 分别指向 0, n-1，一个向后遍历 一个向前遍历，谁大谁推进一步.
     * 从大到小填充结果
     */
    fun sortedSquares(nums: IntArray): IntArray {
        var i = 0
        var j = nums.size - 1
        // 缓存平方结果，避免重复计算
        var ii = -1
        var jj = -1
        // 从大到小填充结果
        var ansIndex = nums.size - 1
        val ans = IntArray(nums.size)
        while (i <= j) {
            if (ii < 0) {
                ii = nums[i] * nums[i]
            }
            if (jj < 0) {
                jj = nums[j] * nums[j]
            }
            if (ii < jj) {
                ans[ansIndex] = jj
                jj = -1
                --j
            } else {
                ans[ansIndex] = ii
                ii = -1
                ++i
            }
            --ansIndex
        }
        return ans
    }
}