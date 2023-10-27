package com.zaze.kotlin.example.algorithm.n10

/**
 * 实现一个支持 '.' 和 '*' 的正则表达式匹配
 * s: 字符串
 * p: 字符规律
 */
class Solution {

    /**
     * 动态规划
     * 定义状态表数组dp[][],保存 字符串s的字符 和 模式串p的字符的匹配关系。
     * dp[0][*]对应空字符的情况。
     * dp[i][j] = true 表示 s前i个字符 和 p前j个字符匹配
     */
    fun isMatch(s: String, p: String): Boolean {
        // 定义状态表 dp
        // 第0位 表示空字符,
        // s[i] 对应dp[i + 1][*]
        val dp = Array(s.length + 1) {
            BooleanArray(p.length + 1)
        }
        // dp[0][0] 表示s、p 都是空字符串
        // 当 p 是空时，仅当 s也是空时才能匹配，其他情况都是false
        dp[0][0] = true
        // 填充状态表，由于0表示空字符，所以状态表中位置和元素下标位置相差 1
        for (i in dp.indices) {
            // 从[i][1] 开始处理, [i][0]的情况仅有[0][0]才匹配，其他都是false
            for (j in 1 until dp[0].size) {
                // 获取当前匹配的字符
                val sc = if (i == 0) null else s[i - 1]
                val pc = p[j - 1]
                if (pc == '*') {
                    // 这里是表示 *，0次匹配的情况,即 s[i - 1] 和 前缀 p[j - 3]的匹配状态
                    dp[i][j] = dp[i][j - 2]
                    // 若匹配，那么 p前缀 + (字母*) 必然也匹配
                    // 不匹配时，再看看当前字符 和 *前的字母是否匹配，并结合 s前缀 来进行判断
                    if (!dp[i][j] && matches(sc, p[j - 2])) {
                        // 当前字符能匹配
                        // s前缀 和 (字母*) 匹配， 那么 s 前缀 + 字母 也必然 匹配
                        dp[i][j] = dp[i - 1][j]
                    }
                } else if (matches(sc, pc)) {
                    // 是字母或 . ; 新状态则是 前一个的状态 + 当前字符的匹配情况
                    dp[i][j] = dp[i - 1][j - 1]
                }
            }
        }
        // 获取 整串 s 的匹配状态。
        return dp[s.length][p.length]
    }

    /**
     * 匹配字符
     */
    private fun matches(sc: Char?, pc: Char): Boolean {
        return when {
            sc == null -> return false
            pc == '.' -> return true
            else -> {
                sc == pc
            }
        }
    }
}