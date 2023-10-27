package com.zaze.kotlin.example.algorithm.n1465

class Solution {
    companion object {
        const val MOD = 1000000007
    }

    /**
     * 超出横竖 中 间隔最大的部分即可，乘积就是答案
     * 时间复杂度：O(hlogh + vlogv)，取决于排序算法。
     * 空间复杂度: O(1)，取决于排序算法。原地排序就是O(1)
     */
    fun maxArea(h: Int, w: Int, horizontalCuts: IntArray, verticalCuts: IntArray): Int {
        // 排序保证，按照从小到大，的顺序切
        horizontalCuts.sort()
        verticalCuts.sort()
        // 垂直横切，水平竖切
        return (1L * getMax(verticalCuts, w) * getMax(horizontalCuts, h) % MOD).toInt()
    }

    /**
     * 贪心, 遍历每一刀，记录最大的边长
     */
    private fun getMax(cuts: IntArray, endRange: Int): Int {
        var left = 0
        var tempMax = 0 // 左边的最大值
        cuts.forEach {
            // 计算 边长，并记录最长的边长
            tempMax = maxOf(it - left, tempMax)
            left = it
        }
        // 最后和 边上的比较一下
        return maxOf(endRange - left, tempMax)
    }
}