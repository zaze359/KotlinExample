package com.zaze.kotlin.example.algorithm.n151

import java.lang.StringBuilder

class Solution {
    fun reverseWords(s: String): String {
        // 按照 空格 分割，去除空字符
        val words = s.split(" ").filter {
            it.isNotEmpty()
        }.map {
            it
        }
        val builder = StringBuilder()
        // 倒序 拼接
        for (i in words.size - 1 downTo 0) {
            builder.append(words[i])
            if (i != 0) {
                builder.append(" ")
            }
        }
        return builder.toString()
    }
}