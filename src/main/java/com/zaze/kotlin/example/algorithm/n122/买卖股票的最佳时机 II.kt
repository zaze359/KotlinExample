package com.zaze.kotlin.example.algorithm.n122

import kotlin.math.max


/**
 *
 * 1. 最多只能持有一股股票
 * 2. 可以当天买当天卖 T0
 * 返回最大利润
 */
class Solution {

    /**
     * 动态规划
     */
    fun maxProfit(prices: IntArray): Int {
//        // dp 记录每一天最大的利润， 不用记录
//        val dp = IntArray(prices.size)
        if (prices.size <= 1) return 0
        var sum = 0
        // 将所有盈利相加
        for (i in 1 until prices.size) {
            // 今天要么亏钱，要么赚钱
            sum += maxOf(prices[i] - prices[i - 1], 0)
        }
        return sum
    }

    /**
     * 贪心
     */
    fun maxProfit3(prices: IntArray): Int {
//        // dp 记录每一天最大的利润， 不用记录
//        val dp = IntArray(prices.size)
        if (prices.size <= 1) return 0
        var sum = 0
        // 将每一笔盈利都相加
        for (i in 1 until prices.size) {
            // 今天要么亏钱，要么赚钱
            sum += maxOf(prices[i] - prices[i - 1], 0)
        }
        return sum
    }

    /**
     * 回溯
     * 超时
     */
    fun maxProfit2(prices: IntArray): Int {
        if (prices.size <= 1) return 0
        return maxOf(f(prices, 0, 1, 0), f(prices, 1, 2, 0))
    }

    private fun f(prices: IntArray, buyDay: Int, sellDay: Int, profit: Int): Int {
        if (buyDay > prices.size - 1 || sellDay > prices.size - 1) return profit
        if (prices[sellDay] < prices[buyDay]) {
            // 这笔交易亏钱或者不赚钱，那么buyDay 不应该买，跳过到下一天
            return f(prices, buyDay + 1, buyDay + 2, profit)
        }
        // 今天卖了，买明天, 后天卖
        val max1 = f(prices, sellDay + 1, sellDay + 2, profit + prices[sellDay] - prices[buyDay])
        // 继续持有，尝试明天卖
        val max2 = f(prices, buyDay, sellDay + 1, profit)
        return maxOf(max1, max2)
    }


}