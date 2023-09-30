package com.zaze.kotlin.example.algorithm.n169

class Solution {

    /**
     * 给定一个大小为 n 的数组 nums ，返回其中的多数元素(数组中出现次数 大于 ⌊ n/2 ⌋ 的元素)
     */
    fun majorityElement(nums: IntArray): Int {
        val sorted = nums.sorted()
        return sorted[sorted.size / 2]
    }
}