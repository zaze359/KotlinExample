package com.zaze.kotlin.example.algorithm.n187

class Solution {
    companion object {
        const val maxLength = 10
        val charMap = mapOf(
            'A' to 0,
            'C' to 1,
            'G' to 2,
            'T' to 3,
        )
    }

    /**
     * 返回出现多次的长度为10的子串，可以按照任意顺序返回
     * 哈希表
     */
    fun findRepeatedDnaSequences2(s: String): List<String> {
        val n = s.length
        if (n <= maxLength) {
            return emptyList()
        }
        val ans = HashSet<String>()
        // 记录各个长度为10的子串
        val set = HashSet<String>()
        for (i in 0..n - maxLength) {
            s.substring(i, i + maxLength).let {
                if (set.contains(it)) {
                    ans.add(it)
                } else {
                    set.add(it)
                }
            }

        }
        return ans.toList()
    }

    /**
     * 滑动窗口 + 位运算 + 哈希
     * 字符返回使用二进制映射
     * A 00
     * C 01
     * G 10
     * T 11
     * 要求的结果字符串长度为10，所以总共20位，可以使用一个 int来表示这个字符串。
     *
     * 相邻的两个字符串存在联系，通过滑动窗口思想可以快速计算得到结果
     * binNext = bin << 2 | s[i] ,且需要抹除高位
     */
    fun findRepeatedDnaSequences(s: String): List<String> {
        val n = s.length
        if (n <= maxLength) {
            return emptyList()
        }
        // 记录各个长度为10的子串的二进制值。
        val set = HashSet<Int>()
        // key：二进制值, value：字符串起始下标，随便一个即可
        val ans = HashMap<Int, Int>()
        var bin = 0
        // 初始化第一个
        for (i in 0 until maxLength) {
            bin = (bin shl i) or (charMap[s[i]] ?: 0)
        }
        set.add(bin)
        val mod = (1 shl 20) - 1 // 低20位都是1
        for (i in 1..n - maxLength) {
            bin = ((bin shl 2) and mod) or (charMap[s[i + maxLength - 1]] ?: 0)
            if (set.contains(bin)) {
                ans[bin] = i
            } else {
                set.add(bin)
            }
        }
        return ans.map {
            s.substring(it.value, it.value + maxLength)
        }
    }
}