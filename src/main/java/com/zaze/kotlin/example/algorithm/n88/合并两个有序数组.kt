package com.zaze.kotlin.example.algorithm.n88

/**
 * 合并后到结果保存在 nums1 中。
 * nums1: 初始长度是 m + n
 */
class Solution {
    /**
     * 空间复杂度：O(1)
     * 时间复杂度:
     * 最好: O(n)
     * 最坏: O(m + n)
     */
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        if (n == 0 || nums1.size != m + n) { // 不需要合并
            return
        }
        // 双指针，从末尾开始遍历
        var p1 = m - 1
        var p2 = n - 1
        while (p1 >= 0 && p2 >= 0) {
            // 比较，谁大谁放最后
            nums1[p1 + p2 + 1] = if (nums1[p1] > nums2[p2]) {
                nums1[p1--]
            } else {
                nums2[p2--]
            }
        }
        // 处理nums2 还有剩余的情况，nums1 没处理完 不用管，因为本来就是有序的。
        (p2 downTo 0).forEach {
            nums1[it] = nums2[it]
        }
    }

    /**
     * 循环比较处理
     * 空间复杂度：O(1)
     * 时间复杂度：
     * 最好 O(n)
     * 最坏 O(m * n)
     */
    fun merge2(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        if (n == 0 || nums1.size != m + n) { // 不需要合并
            return
        }
        var usedSize = m
        nums2.forEach {
            insert(nums1, usedSize, it)
            usedSize++
        }
    }

    private fun insert(nums1: IntArray, m: Int, newValue: Int) {
        (m - 1 downTo 0).forEach {
            when {
                newValue >= nums1[it] -> { // 新值较大，直接插入
                    nums1[it + 1] = newValue
                    return
                }

                else -> { // 新值较小，将旧值后移一位
                    nums1[it + 1] = nums1[it]
                }
            }
        }
        // 表示新值比 nums1 中的都小
        nums1[0] = newValue
    }


}