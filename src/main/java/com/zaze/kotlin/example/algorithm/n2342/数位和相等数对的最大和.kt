package com.zaze.kotlin.example.algorithm.n2342

class Solution {

    /**
     * 遍历 + 哈希表 记录数位和 最大数
     * 时间复杂度： O(nlogm)，m 时nums中的最大值，logm 就是最大值的位数
     * 空间复杂度：O(k) k 表示 不同位数和 个数
     */
    fun maximumSum(nums: IntArray): Int {
        var max = -1
        // key 数位和
        // value 数位和 对应的最大数字，保留一个即可
        // 每次找到第二个时 就计算和，同时将 map中的数字也换成较大的那个, 并和 结果 max 比较
        val map = HashMap<Int, Int>()
        nums.forEach {
            val sum = getSum(it)
            val value = map[sum] ?: 0
            if(value > 0) { // 之前以及找到一个，计算和
                max = maxOf(max, it + value)
            }
            // 保留较大的值
            map[sum] = maxOf(it, value)
        }
        return max
    }

    /**
     * 时间复杂度 O(logm) logm 表示 num 的位数
     */
    private fun getSum(num: Int): Int {
        var temp = num
        var sum = 0
        while (temp > 0) {
            sum += temp % 10
            temp /= 10
        }
        return sum
    }
}