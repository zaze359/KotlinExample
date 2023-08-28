package com.zaze.kotlin.example.algorithm.n41

class Solution {

    /**
     * 存在长度为 n 的数组 nums，找出数组中缺失的最小正数。
     * 要求：时间复杂度 O(n), 空间复杂度O(1)
     *
     * 已知 数组长度为 n，数组下标 [0, n - 1]
     * 假设全部为正数，它们能表示的最小正数集合为 [1, n]
     * 若刚好均匀填充在[1, n]，则题解为 n + 1
     * 若存在 x 个数不在 [1, n]内，则区间内缺失的最小数就是题解。
     *
     * 哈希表 解法：
     * 将所有 数组中的正数和 数组下标建立 hash。正数对应的下标 打上标记
     * 对于非正数，转为 n + 1，使用 负号 作为数组下标的标记。
     * 顺序遍历，找到第一个 > 0的位置下标 position， position + 1就是 题解
     */
    fun firstMissingPositive(nums: IntArray): Int {
        val max = nums.size
        // 对于非正数，转为 n + 1
        for (i in 0 until max) {
            if (nums[i] <= 0) {
                nums[i] = max + 1
            }
        }

        // 正数对应的下标 打上标记  "-"
        for (i in 0 until max) {
            val value = Math.abs(nums[i])
            if (value in 1..max && nums[value - 1] > 0) {
                nums[value - 1] = -nums[value - 1]
            }
        }

        // 查询第一个 > 0 的位置
        nums.forEachIndexed { index, value ->
            if (value > 0) { // 找到缺失，返回 position + 1
                return index + 1
            }
        }
        // 没找到时，就是在 [1, n] 区间外。
        return max + 1
    }

    fun firstMissingPositive2(nums: IntArray): Int {
        val max = nums.size
        var temp = -1
        var value = -1
        for (i in 0 until max) {
            while (nums[i] in 1..max && i != nums[i] - 1) { // 只有[1, n]间的值,且值和下标不匹配才需要交换
                value = nums[i]
                temp = nums[value - 1]
                // 交换值
                nums[value - 1] = value
                nums[i] = if (value == temp) { // 需要交换的两数相等
                    -1 // 置为负数，保证和坐标不对应
                } else { // 正常交换
                    temp
                }
            }
        }
        // value != index + 1 表示缺失
        nums.forEachIndexed { index, value ->
            if (value != index + 1) { // 找到，返回 position + 1
                return index + 1
            }
        }
        // 没找到时，就是在 [1, n] 区间外。
        return max + 1
    }
}