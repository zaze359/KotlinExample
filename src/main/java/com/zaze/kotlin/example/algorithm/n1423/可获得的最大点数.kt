package com.zaze.kotlin.example.algorithm.n1423

import kotlin.math.min

class Solution {
    /**
     * 每次从两边获取一张，求k次后最大
     * 时间复杂度：O(n)
     * 空间复杂度: O(1)
     */
    fun maxScore(cardPoints: IntArray, k: Int): Int {
        val n = cardPoints.size
        if (n == 0) return 0
        val total = cardPoints.fold(0) { acc, i ->
            acc + i
        }
        if (n == k) return total
        // 从左右取， 所以剩下的必然是连续的数组，找出最小和的即可
        val remain = n - k
        var sum = 0
        for (i in 0 until remain) {
            sum += cardPoints[i]
        }
        var minSum = sum
        for (i in remain until n) {
            sum = sum - cardPoints[i - remain] + cardPoints[i]
            minSum = minOf(sum, minSum)
        }
        return total - minSum
    }


    /**
     * 递归，超时
     */
    private fun maxScore(cardPoints: IntArray, left: Int, right: Int, sum: Int, k: Int): Int {
        if (k == 0) {
            return sum
        }
        val sum1 = maxScore(cardPoints, left + 1, right, sum + cardPoints[left], k - 1)
        val sum2 = maxScore(cardPoints, left, right - 1, sum + cardPoints[right], k - 1)
        return maxOf(sum1, sum2)
    }


}