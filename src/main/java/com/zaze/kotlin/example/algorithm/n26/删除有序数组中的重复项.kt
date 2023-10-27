package com.zaze.kotlin.example.algorithm.n26

/**
 * 删除有序数组中的重复项
 * 要求：
 * 1. 原地删除重复项
 * 2. 稳定：元素的 相对顺序 应该保持 一致
 *
 */
class Solution {

    /**
     *
     */
    fun removeDuplicates(nums: IntArray): Int {
        if (nums.size <= 1) return nums.size
        // 在有序数组中，当存在相同元素时，删除n个重复元素就相当于后续元素都向前偏移 n 位。
        // 记录偏移量 即记录存在多少个重复元素
        var offset = 0
        for (i in 1 until nums.size) {
            if (nums[i] == nums[i - 1]) { // 和前一个相同，那么后续元素的偏移量 + 1
                offset++
            } else {
                // 是不同元素，直接前移偏移量
                nums[i - offset] = nums[i]
            }
        }
        return nums.size - offset
    }

    /**
     * 双指针
     */
    fun removeDuplicates2(nums: IntArray): Int {
        if (nums.size <= 1) return nums.size
        // slow 指向左边已处理元素下标
        var slow = 0
        // fast 顺序遍历的指针
        for (fast in 1 until nums.size) {
            if (nums[fast] != nums[slow]) { // 是不同元素，
                // 那么赋值给 p的后一位，同时 p 也指向后一位
                nums[++slow] = nums[fast]
            }
        }
        return slow + 1
    }
}