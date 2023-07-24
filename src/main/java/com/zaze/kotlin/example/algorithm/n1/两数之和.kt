package com.zaze.kotlin.example.algorithm.n1

/**
 *
 */
class Solution {
    /**
     * 从给定数组中找到2个元素之和为 target的那两个整数，返回它们的下标
     * nums：给定的整数数组
     * target：目标值
     * 条件：只会存在一个有效答案，且同一个元素不能重复。返回顺序随意。
     */
    fun twoSum(nums: IntArray, target: Int): IntArray {
        // 求两数之和：first + second = target；
        // 得到 first = target - second
        // 一次遍历的解题方式,时间复杂度 O(n)：空间换时间。
        // 将已遍历过的值和对应下标保存在 HashMap中。
        // 由于仅存在一个答案，first 在 second 之前。
        // 所以我们在往后遍历的过程中，查看map中是否存在对应的first即可
        val map = HashMap<Int, Int>() // hashmap 查询时间复杂度 O(1)
        var first = -1
        var second = -1
        run loop@{
            nums.forEachIndexed { index, value ->
                // 没有返回 -1
                first = map[target - value] ?: -1
                if (first >= 0) { // 存在
                    second = index
                    return@loop
                } else {
                    map[value] = index
                }
            }
        }
        return intArrayOf(first, second)
    }

    /**
     * 暴力解法，循环相加得到结果
     * 嵌套循环：时间复杂度为 O(n2)
     */
    fun twoSum2(nums: IntArray, target: Int): IntArray {
        var first = -1
        var second = -1

        run loop@{
            nums.forEachIndexed { index, value ->
                first = index
                for (j in index + 1 until nums.size) {
                    if (value + nums[j] == target) {
                        second = j
                        return@loop
                    }
                }
            }
        }
        return intArrayOf(first, second)
    }
}