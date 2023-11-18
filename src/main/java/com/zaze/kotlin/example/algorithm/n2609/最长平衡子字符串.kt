package com.zaze.kotlin.example.algorithm.n2609

class Solution {
    /**
     * 平衡：所有0都在1之前，且0、1数量相同，例如 000111
     * [s]: 仅由 0 和 1 组成的二进制字符串
     *
     * 求最长的平衡子字符串。
     *
     * 一次遍历 + 计数
     */
    fun findTheLongestBalancedSubstring(s: String): Int {
        // 找到连续的1字符串，然后往前找0
        var max = 0
        var zeroSize = 0
        var oneSize = 0
        s.forEachIndexed { index, c ->
            if (c == '0') {
                if (oneSize != 0) { // 之前有1，那么就是新子串的开始
                    zeroSize = 1
                    oneSize = 0
                } else { // 连续的0
                    zeroSize++
                }
                return@forEachIndexed
            }
            // 遇到1，计算一下最长的平衡子字符串
            if (zeroSize == 0) { // 之前没有 0，直接跳过
                return@forEachIndexed
            }
            // 之前有0
            oneSize++
            // 由于0， 1相同，所有取 两者最小值
            max = maxOf(max, minOf(zeroSize, oneSize))
        }
        // 结果需要乘以2
        return max * 2
    }
}