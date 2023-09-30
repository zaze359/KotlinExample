package com.zaze.kotlin.example.algorithm.n69

/**
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 */
class Solution {
    /**
     * 二分查找
     */
    fun mySqrt(x: Int): Int {
        if (x == 0) return 0
        if (x == 1) return 1
        var left = 0L
        // 边界其实可以取 x/2。
        // a^2 >= 2*a 可得 a >= 2，即 a >= 2时, 题解a <= x/2
        var right = x / 2L
        var ans = -1
        // 题解 ans:  pow(i) <= x 且 pow(i + 1) > x
        while (left <= right) {
            val mid = left + (right - left) / 2L
            val pow = mid * mid
            println("mid: $mid")
            println("pow: $pow")
            when {
                pow == x.toLong() -> {
                    return mid.toInt()
                }

                pow > x -> {
                    right = mid - 1
                }

                else -> { // 较小，可能就是答案，先记录一下
                    ans = mid.toInt()
                    left = mid + 1
                }
            }
        }
        return ans
    }
}