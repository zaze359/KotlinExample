package com.zaze.kotlin.example.algorithm.n2562

class Solution {

    /**
     * 找出数组的串联值： 取首位串联拼接，求和
     *
     * 双指针
     *
     * 时间复杂度: O(nlogm) 字符串的转换时间
     *      int转 String 10^x + y= m，m表示数字最大值.
     *      耗时 O(logm)
     * 空间复杂度：O(logm) m表示数字最大值
     */
    fun findTheArrayConcVal(nums: IntArray): Long {
        if (nums.isEmpty()) return 0
        var left = 0
        var right = nums.size - 1
        var concVal = 0L
        while (left <= right) {
            if (left == right) {
                concVal += nums[left]
            } else {
                concVal += (nums[left].toString() + nums[right].toString()).toLong()
            }
            left++
            right--
        }
        return concVal
    }
}