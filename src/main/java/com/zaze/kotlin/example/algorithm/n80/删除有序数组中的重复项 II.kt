package com.zaze.kotlin.example.algorithm.n80

/**
 * 有序数组 nums ,原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 */
class Solution {
    /**
     * 顺序遍历
     * 从之前 同类型题目的 的重复一次变为允许重复两次，仅需要稍作改变即可
     */
    fun removeDuplicates2(nums: IntArray): Int {
        if (nums.size <= 2) return nums.size
        // 记录偏移量，即记录删除了多少个重复元素
        var offset = 0
        for (i in 2 until nums.size) {
            // 和前面两个相同，删除这一个，即后续的元素需要再往前一步。
            // 由于位移后一定会出现多个连续元素，所以这里和位移后的的下标比较。
            if (nums[i] == nums[i - 2 - offset]) {
                offset++
            } else { // 不同元素
                nums[i - offset] = nums[i]
            }
        }
        return nums.size - offset
    }

    /**
     * 双指针，快慢指针
     */
    fun removeDuplicates(nums: IntArray): Int {
        if (nums.size <= 2) return nums.size
        var slow = 2 // 指向已处理数组的后一位，即待填充位置。
//        var fast = 2 // 遍历指针
        for (fast in 2 until nums.size) {
            if(nums[fast] != nums[slow - 2]) {
                // 不超过两次，slow这个位置赋值为新的不同元素，并后移
                nums[slow ++] = nums[fast]
            }
        }
        return slow
    }
}