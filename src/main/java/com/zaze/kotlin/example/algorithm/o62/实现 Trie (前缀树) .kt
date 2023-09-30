package com.zaze.kotlin.example.algorithm.o62

/**
 * 实现前缀树（字典树、单词查找树）
 * 面向英文单词，所以字符集长度为 26，使用下标来表示对应字符，0表示 a。
 */
class Trie {
    /** Initialize your data structure here. */
    /** 所有子节点 */
    private val children = Array<Trie?>(26) { null }

    /** 是否是末节点，叶子节点 */
    private var isEnd = false


    /** Inserts a word into the trie. */
    /**
     * 时间复杂度 O(n)
     * n 表示 word 字符数
     */
    fun insert(word: String) {
        // 从当前节点开始判断
        var node = this
        word.forEach { c ->
            val index = getCharIndex(c)
            // 查找是否存在对应子节点
            if (node.children[index] == null) {
                // 不存在这个字符的子节点，添加一个子节点。
                node.children[index] = Trie()
            }
            // 将node指向 当前字符对应的子节点
            node.children[index]?.let {
                node = it
            }
        }
        // 遍历完成，最后一个节点就是结束节点
        node.isEnd = true
    }

    /** Returns if the word is in the trie. */

    /**
     * 时间复杂度 O(n)
     * n 表示 word 字符数
     */
    fun search(word: String): Boolean {
        return searchPrefix(word)?.isEnd == true
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */

    /**
     * 时间复杂度 O(n)
     * n 表示 word 字符数
     */
    fun startsWith(prefix: String): Boolean {
        return searchPrefix(prefix) != null
    }

    /**
     * 时间复杂度 O(n)
     * n 表示 word 字符数
     */
    fun searchPrefix(word: String): Trie? {
        var node = this
        word.forEach { c ->
            val index = getCharIndex(c)
            node.children[index]?.let {
                node = it
            } ?: return null
        }
        return node
    }

    /**
     * 时间复杂度 O(n)
     * n 表示 word 字符数
     */
    fun searchRoot(word: String): String? {
        var node = this
        if (word.isEmpty()) return null
        val builder = StringBuilder()
        word.forEach { c ->
            val index = getCharIndex(c)
            val cur = node.children[index]
            when {
                cur == null -> {
                    return null
                }

                cur.isEnd -> {
                    builder.append(c)
                    return builder.toString()
                }

                else -> {
                    builder.append(c)
                    node = cur
                }
            }
        }
        return builder.toString()
    }

    private fun getCharIndex(c: Char): Int {
        return c - 'a'
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * var obj = Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */