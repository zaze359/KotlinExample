package com.zaze.kotlin.example.algorithm.n2678

/**
 * 信息用长度为 15 的字符串
 * - 前十个字符是乘客的手机号码
 * - 接下来的一个字符是乘客的性别。
 * - 接下来两个字符是乘客的年龄。
 * - 最后两个字符是乘客的座位号。
 */
class Solution {

    /**
     * 年龄在第 12, 13 两个字符，即下标 11,12
     * 时间复杂度: O(n) , details的长度
     * 空间复杂度: O(1), 固定的字符串长度 15
     */
    fun countSeniors(details: Array<String>): Int {
        var age60 = 0
        details.map {
            it.toCharArray()
        }.forEach {
            val first = it[11] - '0'
            // 十位数大于 6 或者十位数 =6 且个位数大于 1
            if(first > 6 || first == 6 && it[12] - '0' > 0) {
                age60 ++
            }
        }
        return age60
    }
}