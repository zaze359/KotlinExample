package com.zaze.kotlin.example.algorithm.n518

/**
 * 零钱兑换2
 * coins：表示不同面额的硬币。
 * amount：总金额
 * 计算并返回可以凑成总金额的 硬币组合数，无法凑出时返回0
 * 条件：硬币有无限个，结果为32 位带符号整数
 */
class Solution {

//    fun change(amount: Int, coins: IntArray): Int {
//        return changeActual(amount, coins.sorted())
//    }
//
//    fun changeActual(amount: Int, coins: List<Int>): Int {
//        // 记录金额对应的 组合数
//        val dp = IntArray(amount + 1)
//        dp[0] = 1
//        coins.forEach {
//            for(i in it..amount) {
//                dp[i] += dp[i - it]
//            }
//        }
//    }
}