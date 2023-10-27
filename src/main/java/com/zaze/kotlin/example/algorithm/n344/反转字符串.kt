package com.zaze.kotlin.example.algorithm.n344

class Solution {


    /**
     * 使用 双指针 交换元素
     *
     * 时间复杂度： O(n)，循环了 n/2次
     * 空间复杂度：O(1)，原地操作
     */
    fun reverseString(s: CharArray) {
        if (s.size < 2) return
        var left = 0
        var right = s.size - 1
        var temp: Char
        while (left < right) {
            temp = s[left]
            s[left] = s[right]
            s[right] = temp
            left++
            right--
        }
    }
}