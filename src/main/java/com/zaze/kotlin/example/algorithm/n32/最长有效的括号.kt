package com.zaze.kotlin.example.algorithm.n32

import java.util.*

class Solution {


    /**
     * 动态规划
     * dp[] 对应 字符下标结尾的最长有效的括号的长度
     * `()`: dp[i] = dp[i - 1] + 2
     * `....))`: dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2
     * 时间复杂度: 遍历1次字符串，O(n)
     * 空间复杂度: O(n)，需要一个dp数组
     */
    fun longestValidParentheses1(s: String): Int {
        // 记录长度 第 i 个 字符下的最长有效的括号
        val dp = IntArray(s.length)
        var max = 0
        for (i in 1 until s.length) {
            val c = s[i]
            if (c == ')') {
                // 看看前一个是不是 (
                if (s[i - 1] == '(') { // 是 (，表示匹配则又多了一对，长度 + 2
                    dp[i] = dp[(i - 2).coerceAtLeast(0)] + 2
                } else {
                    // 前一个位置 ), 出现 .....))，此时需要检查和它对称的位置是不是 (
                    // 对称位置 = i - 已成对长度 - 1
                    val preLength = dp[i - 1]   // 获取前一个位置的 最长有效
                    val pairLeft = i - preLength - 1 // 获取对称位字符下标
                    if (pairLeft >= 0 && s[pairLeft] == '(') {
                        // 当前是 `)` && 对称位置是 `(`；表示又多了一对
                        // 前一个位置的最长有效 + 对称位前一个位置的最长有效 + 2
                        dp[i] = preLength + dp[(pairLeft - 1).coerceAtLeast(0)] + 2
                    }
                }

                max = Math.max(max, dp[i])
            }
        }
        return max
    }

    /**
     * 栈
     * 栈底永远为 最后一个未匹配的右括号的下标
     * 有效长度 = 右括号下标 - 栈顶元素；选取最长的一个
     * 时间复杂度: 遍历1次字符串，O(n)
     * 空间复杂度: 最坏 O(n)
     */
    fun longestValidParentheses2(s: String): Int {
        val stack = Stack<Int>()
        // 栈底 初始化为 -1
        stack.push(-1)
        var max = 0
        s.forEachIndexed { index, c ->
            when {
                c == '(' -> { // 遇到左括号加入到栈中
                    stack.push(index)
                }

                stack.size == 1 -> { // 当前仅有栈底元素，表示 不存在和 ) 匹配的左括号
                    // 更新栈底元素
                    stack.pop()
                    stack.push(index)
                }

                else -> {
                    // 弹出对应的左括号。
                    stack.pop()
                    // 计算 当前这个右括号的有效长度
                    max = Math.max(max, index - stack.peek())
                }
            }
        }
        return max
    }

    /**
     * 时间复杂度: 遍历2次字符串，O(n)
     * 空间复杂度: O(1)
     */
    fun longestValidParentheses(s: String): Int {
        var left = 0
        var right = 0
        var max = 0
        s.forEach { c ->
            when {
                c == '(' -> {
                    left++
                }

                else -> {
                    right++
                }
            }
            if (left == right) {
                max = Math.max(max, left + right)
            } else if (right > left) {
                left = 0
                right = 0
            }
        }
        println("max1: $max")
        // 倒序，处理 (() 左括号永远大于右括号的场景
        left = 0
        right = 0
        for (i in (s.length - 1) downTo 0) {
            when {
                s[i] == '(' -> {
                    left++
                }

                else -> {
                    right++
                }
            }

            if (left == right) {
                max = Math.max(max, left + right)
            } else if (left > right) {
                left = 0
                right = 0
            }
        }
        println("max2: $max")
        return max
    }

}