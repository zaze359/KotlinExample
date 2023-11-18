package com.zaze.kotlin.example.algorithm.n2586

/**
 * 元音字母： 'a'、'e'、'i'、'o'、'u'
 * 元音字符串: 以元音字母开头，并以元音字母结尾。
 */
class Solution {

    companion object {
        val vowelSet = setOf(
            'a', 'e', 'i', 'o', 'u'
        )
    }

    /**
     * 遍历
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    fun vowelStrings(words: Array<String>, left: Int, right: Int): Int {
        if (words.isEmpty()) return 0
        var count = 0
        for (i in left..right) {
            val word = words[i]
            if (word.isEmpty()) {
                continue
            }
            if (vowelSet.contains(word.first()) && vowelSet.contains(word.last())) {
                count++
            }
        }
        return count
    }
}