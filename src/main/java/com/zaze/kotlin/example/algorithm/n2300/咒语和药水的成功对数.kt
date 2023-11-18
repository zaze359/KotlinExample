package com.zaze.kotlin.example.algorithm.n2300

class Solution {
    /**
     * [spells]: 咒语的能量强度
     * [potions]: 药水的能量强度
     * spells[i] * potions[j] >= success 表示成功
     *
     * 时间复杂度：O(nlogm + mlogm)
     * 空间复杂度: O(n) + 排序的额外空间 O(logm)
     */
    fun successfulPairs(spells: IntArray, potions: IntArray, success: Long): IntArray {
        val n = spells.size
        val m = potions.size
        val pairs = IntArray(n)
        // 先从小到大排序, O(mlogm)
        potions.sort()
        for (i in spells.indices) {
            val spell = spells[i].toLong() // 防止int计算溢出
            // 二分 n次 O(logm)
            var left = 0
            var right = m - 1
            while (left <= right) {
                val mid = left + (right - left) / 2
                if (spell * potions[mid] >= success) {
                    right = mid - 1
                } else {
                    left = mid + 1
                }
            }
            pairs[i] = m - left
        }
        return pairs
    }
}