package com.zaze.kotlin.example.algorithm.n907

import java.util.LinkedList

class Solution {

    companion object {
        const val MOD = 1e9 + 7
    }

    /**
     * 单调栈 + 贡献法
     *
     * arr[j] 是左边最近一个小于 arr[i]的 元素，arr[k] 是右边第一个小于等于 arr[i]的元素，
     * 例如 0132331, i = 3, j = 1, k = 6，左边包含和arr[i]重复元素，右边不包含，防止重复计算
     * 即 j ~ k 中的所有子串 最小值都是 arr[i], 和 = arr[i] * (i - j) * (k - i)
     *
     * 时间复杂度: O(n), 2次完整遍历
     * 空间复杂度：O(n), 一个 2*n的数组，一个最大n 的单调栈。
     */
    fun sumSubarrayMins(arr: IntArray): Int {
        if (arr.isEmpty()) return 0
        val n = arr.size
        if (n == 1) return arr[0]
        // dp[i][0] 表示第 arr[i] 为最小的最长子字符串的左半边长度, dp[i][1] 表示右半边长度
        val dp = Array<IntArray>(n) {
            IntArray(2)
        }
        // 单调栈，
        val monoStack = LinkedList<Int>()
        monoStack.push(-1) // 左边界 -1
        // 先从左到右遍历，确定左边
        for (i in arr.indices) {
            // 第一个是 -1，不处理
            while (monoStack.size > 1 && arr[i] <= arr[monoStack.peek()]) {
                // 保证栈顶对应的元素 < arr[i], 去除所有 >= 当前元素
                monoStack.pop()
            }
            // 计算左边长度
            dp[i][0] = i - monoStack.peek()
            monoStack.push(i)
        }
        monoStack.clear()
        monoStack.push(n)
        // 倒序遍历，确定右边
        for (i in n - 1 downTo 0) {
            // 第一个是 n，不处理
            while (monoStack.size > 1 && arr[i] < arr[monoStack.peek()]) {
                // 保证栈顶对应的元素 <= arr[i], 找到右边界
                monoStack.pop()
            }
            // 计算长度
            dp[i][1] = monoStack.peek() - i
            monoStack.push(i)
        }
        var ans = 0
        for (i in dp.indices) {
            ans = ((ans + 1L * arr[i] * dp[i][0] * dp[i][1]) % MOD).toInt()
        }
        return ans
    }
}