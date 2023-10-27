package com.zaze.kotlin.example.algorithm.n2652

/**
 * 给你一个正整数 n ，请你计算在 [1，n] 范围内能被 3、5、7 整除的所有整数之和
 */
class Solution {


    /**
     * 容斥原理
     * 将所有能被3整除的数和 + 所有被5整除的数和 + 所有被7整除的数和 - 重复计算的数和
     * f(n, m)表示所有 能被 n 整除的数和, 这个和 是一个等差数列
     * f(n,3) + f(n,5) + f(n,7) - f(n,3 * 5) - f(n,3 * 7) - f(n,3 * 5 * 7)
     *
     * 时间复杂度: O(1)
     * 空间复杂度: O(1)
     */
    fun sumOfMultiples2(n: Int): Int {
        return f(n, 3) + f(n, 5) + f(n, 7) - f(n, 3 * 5) - f(n, 3 * 7) - f(n, 3 * 5 * 7) - f(n, 5 * 7)
    }

    private fun f(n: Int, m: Int): Int {
        return (m + (n / m) * m) * (n / m) / 2
    }

    /**
     * 遍历
     * 时间复杂度: O(n)
     * 空间复杂度：O(1)
     */
    fun sumOfMultiples(n: Int): Int {
        var sum = 0
        for (i in 1..n) {
            if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
                sum += i
            }
        }
        return sum
    }
}