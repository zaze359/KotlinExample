package com.zaze.kotlin.example.algorithm.n819


/**
 * 给定一个段落 (paragraph) 和一个禁用单词列表 (banned)。返回出现次数最多，同时不在禁用列表中的单词。
 * 题目保证至少有一个词不在禁用列表中，而且答案唯一。
 * 禁用列表中的单词用小写字母表示，不含标点符号。段落中的单词不区分大小写。答案都是小写字母。
 */
class Solution {
    /**
     * 1. 转为小写
     * 2. 使用正则将所有 a-z 之外的字符都替换空格
     * 3. 将分割字符成单词
     * 4. 过滤：空白字符，禁用单词
     * 5. 将单词分组统计
     * 6. 获取到次数最多的单词
     */
    fun mostCommonWord(paragraph: String, banned: Array<String>): String {
        return paragraph
//            .toLowerCase()
            .lowercase()
            .replace("[^a-z]".toRegex(), " ")
            .split("\\s+".toRegex())
            .filter {
                it.isNotEmpty() && it !in banned
            }
            .groupBy {
                it
            }
            .maxByOrNull {
                it.value.size
            }
//            .maxBy {
//                it.value.size
//            }
            ?.key ?: throw IllegalArgumentException()
    }
}