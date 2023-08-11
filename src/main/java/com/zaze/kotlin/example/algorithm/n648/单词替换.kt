package com.zaze.kotlin.example.algorithm.n648

import com.zaze.kotlin.example.algorithm.o62.Trie


/**
 * 单词替换
 */
class Solution {
    /**
     * 将 sentence 中的 继承词 使用词根替换，优先 最短的词根。
     * [dictionary]: 许多词根组成的词典。["cat","bat","rat"]
     * [sentence]: 空格分隔单词形成的句子。例如 "the cattle was rattled by the battery"
     * 时间复杂度： O(d + s) 词根字符数 + 句子字符数
     * 空间复杂度： O(d + s) 词根字符数 + 句子字符数
     * @return 例如 "the cat was rat by the bat"
     */
    fun replaceWords(dictionary: List<String>, sentence: String): String {
        // 使用 dictionary 构建字典树。
        val trie = Trie()
        // 构建树的时间复杂度： O(d)  词根字符数
        // 空间复杂度：O(d) 词根字符数
        for (word in dictionary) { // 遍历次数 = 词根数
            trie.insert(word) // insert内部会遍历 词根的所有字符。
        }
        // 分隔字符进行存储，空间复杂度 O(s) sentence的字符数
        val words: MutableList<String> = sentence.split(" ").toMutableList()
        // 时间复杂度: O(s) sentence的字符数
        words.forEachIndexed { index, word -> // 遍历次数 = 单词数量
            trie.searchRoot(word)?.let {// searchRoot内部会遍历字符，时间复杂度O(n)
                words[index] = it
            }
        }
        return words.joinToString(" ")
    }
}