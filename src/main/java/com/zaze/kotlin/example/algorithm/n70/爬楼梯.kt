package com.zaze.kotlin.example.algorithm.n70

/**
 * n 阶, 每次可以爬 1 或 2 个台阶。有多少种不同的方法可以爬到楼顶呢？
 */
class Solution {
    /**
     * 动态规划
     * 第 n 阶台阶只能从 n-1 或 n-2 台阶爬过来
     * f(n) = f(n -1) + f(n-2)
     * f(0) = 1; f(1) = 1
     * 类似 斐波那契数列，
     * 区别在于本题 f(2) = 2
     */
    fun climbStairs(n: Int): Int {
        if (n <= 2) {
            return n
        }
        // 递归
//        return climbStairs(n - 1) + climbStairs(n - 2)
        // 循环代替递归
        var ret = 1
        var first = 0
        var sencond = 0
        for (i in 1..n) {
            first = sencond
            sencond = ret
            ret = first + sencond
        }
        return ret
    }
}