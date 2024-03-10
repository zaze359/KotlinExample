package com.zaze.kotlin.example.algorithm.n2048

class Solution {

    /**
     * 枚举
     * 1000000
     * 1224444
     * 时间复杂度: O(122444 - n)
     */
    fun nextBeautifulNumber(n: Int): Int {
        for (i in n + 1..1224444) {
            if (isBalance(i)) return i
        }
        return 1224444
    }

    private fun isBalance(num: Int): Boolean {
        val arr = IntArray(10)
        var temp = num
        while (temp > 0) {
            arr[temp % 10]++
            temp /= 10
        }
        arr.forEachIndexed { index, i ->
            if (i > 0 && index != i) return false
        }
        return true
    }
}