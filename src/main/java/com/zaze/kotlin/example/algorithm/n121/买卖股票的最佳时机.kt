package com.zaze.kotlin.example.algorithm.n121

import java.lang.Integer.max

class Solution {
    fun maxProfit(prices: IntArray): Int {
        var minPoint = -1
        var profit = 0
        prices.forEach {
            if (minPoint < 0 || it < minPoint) {
                // 出现了新的最小值
                minPoint = it
            }
            // 取最大即可
            profit = max(profit, it - minPoint)
        }
        return profit
    }
}