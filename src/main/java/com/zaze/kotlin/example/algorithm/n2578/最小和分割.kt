package com.zaze.kotlin.example.algorithm.n2578

/**
 * 将正整数 num ，分割成两个非负整数 num1 和 num2
 * 每个数字的顺序可以改变
 * 求 num1 + num2的 最小 值
 */
class Solution {
    /**
     * 要使得两数和最小，那么分割时必然需要进行二分
     * 同时将最小的数字放在高位，这样才能保证最小。
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(n)
     *
     * n表示位数 = lognum
     */
    fun splitNum(num: Int): Int {
        // 将数字转为char数组，从小到大排序
        var num1 = 0
        var num2 = 0
        // 排序 O(nlogn) + 遍历 O(n)
        num.toString().toCharArray().sorted().forEachIndexed { index, c ->
            if(index % 2 == 0) {
                num1 = num1 * 10 + (c - '0')
            } else {
                num2 = num2 * 10 + (c - '0')
            }
        }

        return num1 + num2
    }
}