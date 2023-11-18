package com.zaze.kotlin.example.algorithm.n2103

/**
 * 有n个环，红、绿、蓝中的一种。
 * 总共有 10个杆，[0, 9]
 *
 */
class Solution {

    /**
     * [rings] 长度为2n的字符串，每2个字符确定一个环 "G2" 表示在第2杆有 G 环。
     * 返回 杆上有 全部RGB3种环的 杆数。
     *
     * 空间复杂度：O(1), 固定 10
     * 时间复杂度：O(n)，环数
     */
    fun countPoints(rings: String): Int {
        val n = rings.length / 2
        val dp = IntArray(10) // 记录每个杆上的 RGB环状态
        var i = 0
        var color: Char
        var index: Int
        //
        var count = 0 // 统计RGB的杆
        //
        var temp: Int
        repeat(n) {
            color = rings[i]
            i++
            index = rings[i] - '0'
            i++
            // 按位记录
            temp = dp[index]
            when (color) {
                'R' -> { // 0001
                    dp[index] = dp[index] or 1
                }

                'G' -> { // 0010
                    dp[index] = dp[index] or 2
                }

                'B' -> {// 0100
                    dp[index] = dp[index] or 4
                }

                else -> {}
            }
            // 之前不包含 RGB，之后包含了就计数，防止重复统计
            if (temp != 7 && dp[index] == 7) {
                count++
            }
        }
        return count
    }
}