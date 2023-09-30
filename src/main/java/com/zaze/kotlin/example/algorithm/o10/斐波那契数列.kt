package com.zaze.kotlin.example.algorithm.o10


/**
 * 求 斐波那契数列 的第 n 项 f(n)
 * f(n)=f(n-1)+f(n-2)
 */
class Solution {
    // 边界值
    private val mod = 1000000007

    /**
     * 动态规划
     * 利用循环替代递归。
     * 自底向上自算
     */
    fun fib(n: Int): Int {
        // (f(1) + f(2)) + f(3) ....

        return when {
            n < 2 -> {
                n
            }

            else -> {
                var a = 0 // 第一个数
                var b = 1 // 第二个数
                var fn = 0 // 第三个数 = 两数之和
                repeat(n - 1) {
                    fn = (a + b) % mod
                    a = b
                    b = fn
                }
                fn
            }
        }
    }

    /**
     * 递归法：自顶向上计算
     * 递归期间存在大量重复计数。 例如 求 f(10)
     * f(8) 就会被计数两次，f(7) 三次 ....
     * 可以考虑空间换时间，添加一个数组记录已计算过的数值 n。
     */
    fun fib2(n: Int): Int {
        return when (n) {
            0 -> {
                0
            }

            1 -> {
                1
            }

            else -> {
                fib2(n - 1) + fib2(n - 2)
            }
        } % mod
    }

    /**
     * 矩阵快速幂
     * O(logn)
     */
    fun fib3(n: Int): Int {
        if (n < 2) {
            return n
        }
        val q = arrayOf(intArrayOf(1, 1), intArrayOf(1, 0))
        return pow(q, n - 1)[0][0]
//        return pow(q, n)[0][1]
    }

    /**
     * 快速幂 求数组 array的 n次方
     * O(logn)
     */
    private fun pow(a: Array<IntArray>, n: Int): Array<IntArray> {
        var matrix = a // 底数
        var pow = n // 幂次
        // 保存结果，初始值是一个单位矩阵
        var ret = arrayOf(intArrayOf(1, 0), intArrayOf(0, 1))
        var i = 1
        while (pow > 0) {
            println("------------ ${i++}")
            if ((pow and 1) == 1) {
                // 奇数 表示多出一个 indexNum，单独 和之前的结果 乘算一下
                ret = multiply(ret, matrix)
//                println("pow: $pow, ret1: ${ret[0][1]}")
//                println("pow: $pow, ret0: ${ret[0][0]}")
            }

            // 将底数平方一下
            matrix = multiply(matrix, matrix)
//            println("pow: $pow, matrix: ${matrix[0][1]}")
//            println("pow: $pow, matrix: ${matrix[0][0]}")
            // 每次将 幂次/2
            pow = pow shr 1
        }
        return ret
    }

    /**
     * 根据快速求幂，求 2数相乘
     */
    private fun multiply(a: Array<IntArray>, b: Array<IntArray>): Array<IntArray> {
        val ret = arrayOf(intArrayOf(0, 0), intArrayOf(0, 0))
        // 行列
        for (i in 0 until 2) { //
            for (j in 0 until 2) { //
                ret[i][j] = ((a[i][0].toLong() * b[0][j] + a[i][1].toLong() * b[1][j]) % mod).toInt()
            }
        }
        return ret
    }

}