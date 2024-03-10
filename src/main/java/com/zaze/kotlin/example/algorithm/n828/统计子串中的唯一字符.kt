package com.zaze.kotlin.example.algorithm.n828

class Solution {

    /**
     * 贡献法
     * 统计每个字符出现的位置，在字符重复出现时，比如第一次i  第二次j,
     * 它们之间的字符串 [-1, s[i],  s[j]), 总共有 (i + 1) * (j - i) 个子字符串，-1开始方便计算。
     * 每个子串中该字符都是唯一字符，子串数就是贡献值。
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    fun uniqueLetterString(s: String): Int {
        // 记录字符出现的位置,O(n)
        val map = HashMap<Char, ArrayList<Int>>()
        s.forEachIndexed { index, c ->
            if (!map.containsKey(c)) {
                map[c] = ArrayList<Int>().apply {
                    // 由于下标从0开始，添加一个-1作为左边界
                    add(-1)
                }
            }
            map[c]?.add(index)
        }
        var ans = 0
        map.forEach { k, v ->
            v.add(s.length) // 添加右边界
            for (i in 1 until v.size - 1) {
                ans += (v[i] - v[i - 1]) * (v[i + 1] - v[i])
            }
        }
        return ans
    }
}