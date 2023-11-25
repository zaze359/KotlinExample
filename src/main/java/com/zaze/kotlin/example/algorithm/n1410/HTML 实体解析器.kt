package com.zaze.kotlin.example.algorithm.n1410

import java.lang.StringBuilder

class Solution {
    companion object {
        val map = mapOf(
            "&quot;" to "\"",
            "&apos;" to "\'",
            "&amp;" to "&",
            "&gt;" to ">",
            "&lt;" to "<",
            "&frasl;" to "/",
        )
    }

    /**
     * 哈希表
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    fun entityParser(text: String): String {
        val builder = StringBuilder()
        var start = 0
        text.forEachIndexed { index, c ->
            if(c == '&') {
                // 将& 之前的字符添加到buffer中, start转为处理特殊
                val subStr = text.substring(start, index)
                builder.append(subStr)
                start = index
                return@forEachIndexed
            }
            //
            if(start >= 0 && c == ';') {
                val specialStr = text.substring(start, index + 1)
                // start 转为处理普通字符
                start = index + 1
                if(map.containsKey(specialStr)) {
                    builder.append(map[specialStr])
                } else {
                    builder.append(specialStr)
                }
            }
        }
        if(start < text.length) {
            builder.append(text.substring(start, text.length))
        }
        return builder.toString()
    }
}