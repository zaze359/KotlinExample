package com.zaze.kotlin.example.algorithm.n2698

/**
 * 求惩罚数 的和 i 在区间 [1, n], 1 <= n <= 1000
 * i ^ 2， 分解后得到的数之和等于 i
 * 1 * 1 = 1 , 1 = 1
 * 9 * 9 = 81, 8 + 1 = 9
 * 10 * 10 = 100, 10 + 0 = 10
 */
class Solution {

    /**
     * 递归深度遍历
     */
    fun punishmentNumber(n: Int): Int {
        var sum = 0
        for (i in 1..n) {
            val pow = i * i
            if (check("$pow", 0, i)) {
                sum += pow
            }
        }
        return sum
    }

    private fun check(numStr: String, sum: Int, target: Int): Boolean {
        if (numStr.isEmpty()) return sum == target
        // 数字分解 求和，相当于在数字中间添加 加号。
        // 可以添加[0, size - 1]
        for (i in 1..numStr.length) {
            if (check(numStr.substring(i, numStr.length), sum + numStr.substring(0, i).toInt(), target)) {
                return true
            }
        }
        return false
    }
}