package com.zaze.kotlin.example.algorithm.n2216

/**
 * nums.length 为偶数
 * 对所有满足 i % 2 == 0 的下标 i ，nums[i] != nums[i + 1] 均成立
 */
class Solution {

    /**
     * 遍历
     * 时间复杂度：O(n)
     * 空间复杂度: O(1)
     */
    fun minDeletion(nums: IntArray): Int {
        val n = nums.size
        if (n == 0) return 0
        var deleteCount = 0
        // 先判断 是否满足  i % 2 == 0 的下标 i ，nums[i] != nums[i + 1]
        var i = 0
        while (i < n - 1) {
            // 计算偏移后的下标，看看奇偶
            val index = i - deleteCount
            if (index % 2 == 1) { // 奇数位，不用管
                i++
                continue
            }
            while (i < n - 1 && nums[i] == nums[i + 1]) {
                // 此时这个元素，不满足最美，删一个，再看看后一个
                deleteCount++
                i++
            }
            i++
        }
        // 若最后是奇数，那么再删除最后一个变为偶数即可
        if ((nums.size - deleteCount) % 2 != 0) {
            deleteCount++
        }
        return deleteCount
    }
}