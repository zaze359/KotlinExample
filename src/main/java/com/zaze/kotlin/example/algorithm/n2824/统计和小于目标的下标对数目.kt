package com.zaze.kotlin.example.algorithm.n2824

class Solution {

    /**
     * 排序 + 二分
     * 时间复杂度：O(n * logn)
     * 空间复杂度: 取决于排序算法。 O(logn)
     */
    fun countPairs(nums: List<Int>, target: Int): Int {
        // 排序
        val sorted = nums.sorted()
        var ret = 0
        // i 之后的都不用管
        for (i in 1 until sorted.size) {
            // 往前面找，防止重复计数,  例如 [2,4] 和 [4, 2]
            // 二分找出所有的 k, nums[i] + nums[k] < target。
            val k = binarySearch(sorted, 0, i - 1, target - sorted[i])
            ret += k
        }
        return ret
    }

    private fun binarySearch(nums: List<Int>, start: Int, end: Int, target: Int): Int {
        var left = start
        var right = end
        var ans = 0
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (nums[mid] < target) { // 满足，数量 = mid + 1
                ans = mid + 1
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        return ans
    }
}