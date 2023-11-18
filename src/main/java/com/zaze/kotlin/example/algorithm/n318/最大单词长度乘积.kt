package com.zaze.kotlin.example.algorithm.n318

class Solution {
    /**
     * 找出最大两个单词，计算它们的长度乘积，单词不包含公共字母
     *
     * [words]: 单词数组
     *
     * 位运算
     * 使用Int的 后26位表示小写字母，记录单词中出现的字母。单词存在对应字母就将对应位标记为1.
     * 当不存在公共字母时，两个单词a,b, a & b = 0，否则 > 0
     * 时间复杂度: O(L + n^2),L 为所有单词的总字符数,n 单词数
     * 空间复杂度: O(n)
     */
    fun maxProduct(words: Array<String>): Int {
        val n = words.size
        // 先将所有单词按位转为Int，并记录
        // key: 二进制
        // value: 对应单词的下标
        val binMap = HashMap<Int, Int>()
        // O(L), L 为所有单词的总字符数。
        words.forEachIndexed { index, s ->
            var bin = 0
            s.forEach {
                bin = (1 shl (it - 'a')) or bin
            }
            // 不包含该二进制 或者 二进制相同时记录长度最大的
            if (!binMap.containsKey(bin) || s.length > words[binMap[bin]!!].length) {
                binMap[bin] = index
            }
        }
        var max = 0
        // 遍历所有组合，找出最大长度。
        // O(n^2)
        binMap.keys.toIntArray().let { bins ->
            for (i in bins.indices) {
                val bin1 = bins[i]
                for (j in i + 1 until bins.size) {
                    val bin2 = bins[j]
                    if (bin1 and bin2  == 0) { // 不存在公共字母
                        max = maxOf(max, words[binMap[bin1]!!].length * words[binMap[bin2]!!].length)
                    }
                }
            }
        }
        return max
    }
}