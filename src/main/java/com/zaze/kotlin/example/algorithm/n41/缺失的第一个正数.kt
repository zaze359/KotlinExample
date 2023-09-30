package com.zaze.kotlin.example.algorithm.n41

class Solution {

    /**
     * 存在长度为 n 的数组 nums，找出数组中缺失的最小正数。
     * 要求：时间复杂度 O(n), 空间复杂度O(1)
     *
     * 已知 数组长度为 n，数组下标 [0, n - 1]
     * 假设全部为正数，它们能表示的最小正数集合为 [1, n]
     * 若刚好能均匀填充满[1, n]，则题解为 n + 1
     * 若存在 x 个数不在 [1, n]内，则区间内缺失的最小数就是题解。
     *
     * 哈希表 解法：
     * 将所有 数组中的正数和 数组下标建立 hash。
     * 正数对应的下标 打上标记
     * 对于非正数，转为 n + 1，使用 负号 作为数组下标的标记。
     * 顺序遍历，找到第一个 > 0的位置下标 position， position + 1就是 题解
     */
    fun firstMissingPositive(nums: IntArray): Int {
        // 假设数组内正数没有缺失，最大值就是长度 size.
        val max = nums.size
        // 对于非正数，转为 n + 1
        for (i in 0 until max) {
            if (nums[i] <= 0) {
                nums[i] = max + 1
            }
        }

        // 正数值和对应的下标， 打上标记  "-"
        for (i in 0 until max) {
            // 取出value，将 value 和 index 建立映射关系，
            val value = Math.abs(nums[i])
            // 值在 [1, n] 区间内，且没有标记过，就在 value - 1下标处添加标记
            // 表示 存在 value这个正数。
            if (value in 1..max && nums[value - 1] > 0) {
                nums[value - 1] = -nums[value - 1]
            }
        }
        // 上述处理完后，对于存在的正数，对应下标的取值应该是个负数。
        // 查询第一个 > 0 的位置，表示正数缺失
        nums.forEachIndexed { index, value ->
            if (value > 0) { // 找到缺失，返回 ret = position + 1
                return index + 1
            }
        }
        // 没找到时，就是在 [1, n] 区间外。
        return max + 1
    }

    /**
     * 置换
     *  将数组的值和下标对应，即 nums[index] = index + 1
     *  若值和下标不对应则表示正数缺失。
     * 时间复杂度 O(n), 空间复杂度O(1)
     */
    fun firstMissingPositive2(nums: IntArray): Int {
        val max = nums.size
        var temp = -1
        var value = -1
        for (i in 0 until max) {
            // 位于[1, n] 间的值,且值和下标不匹配时 就进行交换
            while (nums[i] in 1..max && nums[i] != i + 1) {
                value = nums[i]
                temp = nums[value - 1]
                // 交换值，将 value 交互到 下标 value - 1处。
                nums[value - 1] = value
                nums[i] = if (value == temp) { // 需要交换的两数相等
                    -1 // 置为负数，保证和坐标不对应
                } else { // 正常交换
                    temp
                }
            }
        }
        // value != index + 1 表示缺失
        nums.forEachIndexed { index, v ->
            if (v != index + 1) { // 找到，返回 position + 1
                return index + 1
            }
        }
        // 没找到时，就是在 [1, n] 区间外。
        return max + 1
    }
}