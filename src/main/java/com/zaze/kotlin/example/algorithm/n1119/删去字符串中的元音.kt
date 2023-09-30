package com.zaze.kotlin.example.algorithm.n1119

/**
 * 删去字符串中的元音
 *
 * 程序的输入是一个字符串 s。移除当中的所有元音字母 a、e、i、o、u元音字母
 */
class Solution {
    private val vowels = setOf('a', 'e', 'i', 'o', 'u')

    fun removeVowels(s: String): String = s.filter {
        it !in vowels
    }
}