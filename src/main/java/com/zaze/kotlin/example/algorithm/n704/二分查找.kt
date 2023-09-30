package com.zaze.kotlin.example.algorithm.n704

/**
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target，
 * 搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 */
class Solution {
    /**
     * nums 升序
     * nums 中的所有元素是不重复
     * 二分查找
     * 时间复杂度 O(logn)
     * 空间复杂度 O(1)
     */
    fun search(nums: IntArray, target: Int): Int {
        if (nums.isEmpty()) return -1
        // 递归
//        return binarySearch(nums, target, left = 0, right = nums.size - 1)
        // 循环代替递归
        var left = 0
        var right = nums.size - 1
        while (right >= left) {
            val mid = left + (right - left) / 2
            when {
                nums[mid] == target -> {
                    // 找到，直接返回
                    return mid
                }

                nums[mid] > target -> {
                    // target < 中间值，那么应该位于 mid 的左边 [left, mid)
                    right = mid - 1
                }

                else -> {
                    // target > 中间值，那么应该位于 mid 的右边 (mid, right)
                    left = mid + 1
                }
            }
        }
        // 没有找到
        return -1
    }

    private fun binarySearch(nums: IntArray, target: Int, left: Int, right: Int): Int {
        if (right < left) { // 没有找到
            return -1
        }
        val mid = left + (right - left) / 2
        return when {
            nums[mid] == target -> { // 找到，直接返回
                mid
            }

            nums[mid] > target -> {
                // target < 中间值，那么应该位于 mid 的左边 [left, mid)
                binarySearch(nums, target, left = left, right = mid - 1)
            }

            else -> {
                // target > 中间值，那么应该位于 mid 的右边 (mid, right)
                binarySearch(nums, target, left = mid + 1, right = right)
            }
        }
    }
}