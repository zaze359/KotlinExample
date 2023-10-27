package com.zaze.kotlin.example.algorithm.n2520

/**
 * 求能整除 num 的数位的数目。
 */
class Solution {
    fun countDigits(num: Int): Int {
        var count = 0
        "$num".forEach {
            if (num % (it - '0') == 0) {
                count++
            }
        }
        return count
    }
}