package com.zaze.kotlin.example.algorithm.n27


/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素
 * 要求 空间复杂度O(1)，允许改变元素顺序
 */
class Solution {

    /**
     * 双指针,从左到右遍历
     * left 用于遍历元素比对，right用于交换
     *
     * 当 num[left]和 val相同时就将num[right]赋值到 left
     * 这样 right 后面的就都是移除的元素。
     * 最终结果的长度就是 right + 1
     *
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var left = 0
        var right = nums.size - 1 // 指向最后一个
        while (left <= right) {
            if (nums[left] == `val`) {
                // 需要删除，直接使用最后一个元素覆盖。
                nums[left] = nums[right]
                // 将 right直接删除。
                right--
            } else { // 不同时，就继续遍历下一个
                left++
            }
        }
        return right + 1
    }
}