package com.zaze.kotlin.example.algorithm.n1726

/**
 * 一个由 不同 正整数组成的数组 nums
 * 返回满足 a * b = c * d 的元组 (a, b, c, d) 的数量
 */
class Solution {
    /**
     * 由于 所有数字不同
     * 找出 a * b = c * d 后在进行不同组合即可得到 a,b,c,d 组成的所有元组。
     * ab 和 cd 作为整体，时存在 A(2, 2) 2种。abcd,cdab
     * ab、cd 内部又各自存在2种排列方式，所以最终有 A(2, 2) *2*2 = 8种；
     * 求组合数公式： n! / (n - 2)! = n * (n - 1) * 4
     *
     * 哈希表进行统计
     */
    fun tupleSameProduct(nums: IntArray): Int {
        // 记录 乘积相同的 不同元组数量
        val map = HashMap<Int, Int>()
        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                val multi = nums[i] * nums[j]
                map.put(multi, (map[multi] ?: 0) + 1)
            }
        }
        var count = 0
        map.values.forEach {
            // n! / (n - 2)! = n * (n - 1)
            count += it * (it - 1) * 4
        }
        return count
    }
}