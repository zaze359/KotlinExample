package com.zaze.kotlin.example.algorithm.n121

import java.lang.Integer.max

/**
 * 数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格
 * 计算你所能获取的最大利润
 */
class Solution {

    /**
     * 一次遍历
     * 买卖存在时间先后关系
     * 所以遍历时记录最低点，并每次都计算利润，记录最大利润。
     *
     * 时间复杂度：O(n)
     * 空间复杂度: O(1)
     */
    fun maxProfit(prices: IntArray): Int {
        var minPoint = -1 // 最小卖出点
        var profit = 0 //利润
        // 依次遍历，表示从第几天开始买
        prices.forEach {
            if (minPoint < 0 || it < minPoint) {
                // 记录新的最小值，用于计算后续的利润
                minPoint = it
            }
            // 计算利润，并和之前的利润比较
            profit = Math.max(profit, it - minPoint)
        }
        return profit
    }
}