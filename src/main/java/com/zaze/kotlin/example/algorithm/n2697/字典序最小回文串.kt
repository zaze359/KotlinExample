package com.zaze.kotlin.example.algorithm.n2697

class Solution {

    /**
     * 双指针
     */
    fun makeSmallestPalindrome(s: String): String {
        var left = 0
        var right = s.length - 1
        val ans = CharArray(s.length)
        while (left <= right) {
            if (s[left] != s[right]) {
                ans[left] = if (s[left] > s[right]) s[right] else s[left]
                ans[right] = ans[left]
            } else {
                ans[left] = s[left]
                ans[right] = ans[left]
            }
            left++
            right--
        }
        return String(ans)
    }
}