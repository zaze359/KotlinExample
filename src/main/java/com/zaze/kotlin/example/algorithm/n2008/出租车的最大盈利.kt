package com.zaze.kotlin.example.algorithm.n2008

class Solution {

    /**
     * 哈希表 + 动态规划
     * 时间复杂度：O(n + rides.size)
     * 空间复杂度：O(n + rides.size)
     */
    fun maxTaxiEarnings(n: Int, rides: Array<IntArray>): Long {
        // 记录下车点的最大利润
        val dp = LongArray(n + 1)
        // 按照下车点进行分类
        val map = HashMap<Int, ArrayList<IntArray>>()
        rides.forEach {
            val end = it[1]
            if (!map.containsKey(end)) {
                map[end] = ArrayList()
            }
            map[end]?.add(it)
        }
        // 遍历下车点，计算下车点的利润
        for (i in 1..n) {
            dp[i] = dp[i - 1] // 至少是之前的利润
            // 看看是否存在人下车，有的话重新计算一下
            map[i]?.forEach {
                val start = it[0]
                val end = it[1]
                val tip = it[2]
                dp[end] = maxOf(dp[end], dp[start] + end - start + tip)
            }
        }
        return dp[n]
    }
}