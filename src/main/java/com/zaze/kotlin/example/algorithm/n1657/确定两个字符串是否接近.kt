package com.zaze.kotlin.example.algorithm.n1657

import java.util.*

/**
 * 接近的定义：
 * 1. 现有字符位置交换, abc  cba
 * 2. 现有字符变换， aaacbb,  bbbcaa, b 和 a 进行变换。
 * 位运算 + 计数
 * 时间复杂度: O()
 */
class Solution {

    /**
     * 1. 总字符数相同
     * 2. 字符种类相同, 通过异或位运算判断字符种类
     * 3. 由于可以变换以及交换，所以只要出现的频次相同即可，字符不同没关系
     *
     * 时间复杂度：O(n + ClogC) C = 26 , n表示字符串长度。
     * 空间复杂度：O(C) C = 26
     */
    fun closeStrings(word1: String, word2: String): Boolean {
        if (word1.length != word2.length) return false
        // 表示仅包含英文，所以使用
        val countArray1 = IntArray(26)
        val countArray2 = IntArray(26)
        var charNum1 = 0
        var charNum2 = 0
        word1.forEach {
            val index = it - 'a'
            charNum1 = charNum1 or (1 shl index)
            countArray1[index]++
        }
        word2.forEach {
            val index = it - 'a'
            charNum2 = charNum2 or (1 shl index)
            countArray2[index]++
        }
        // 字符种类不同
        if ((charNum1 xor charNum2) != 0) return false
        // 比对出现的频次, 不关心字母是什么
        // 按照频率排序
        // O(ClogC)
        countArray1.sort()
        countArray2.sort()
        return Arrays.equals(countArray1, countArray2)
    }
}