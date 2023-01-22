package com.zaze.kotlin.example.algorithm.n33

internal class Solution {
    fun search(nums: IntArray, target: Int): Int {
        val n = nums.size
        if (n == 0) {
            return -1
        }
        var low = 0
        var high = n - 1
        //
        var left: Int
        var right: Int
        while (low <= high) {
            // 获取左右边的值，来判断新区间中的数据是否有序
            left = nums[low]
            right = nums[high]
            // 相同直接返回
            // if (left == target) {
            // return low;
            // }
            // 获取中间值
            val mid = low + high shr 1
            val midValue = nums[mid]
            println(" mid: $mid; midValue: $midValue")
            // 相同直接返回
            if (midValue == target) {
                return mid
            }
            // 查找的值小于中间值场景,
            if (target < midValue) {
                if (target >= left) { // 往回找
                    // 查找的值 在 [left, mid] 区间内
                    high = mid - 1
                } else { // 需要往后找
                    // 值在[mid, right] 区间内
                    low = mid + 1
                }
                continue
            }
            // 查找的值大于中间值场景
            if (left < midValue || target <= right) {
                // 直接跳到 mid之后
                // 1. left -> mid 是有序的,
                // 2. 查找的值小于等于最右边的数，
                low = mid + 1
            } else { // 查找的大于最后一个值，此时需要往回找
                high = mid - 1
            }
        }
        return -1
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            var intArray = intArrayOf(4, 5, 6, 7, 0, 1, 2)
            var target = 1
            intArray = intArrayOf(1)
            target = 1
            // intArray = new int[] { 4, 5, 6, 7, 8, 1, 2, 3 };
            // target = 5;
            // intArray = new int[] { 5, 1, 2, 3, 4 }; // 1
            // target = 1;
            // intArray = new int[] { 3, 1 }; // 1
            // target = 1;
            // intArray = new int[] { 8, 9, 2, 3, 4 }; // 9
            // target = 9;
            // intArray = new int[] { 9, 8 }; // 8
            // target = 8;
            // mid < a1
            val index = Solution().search(intArray, target)
            println("index: $index")
        }
    }
}