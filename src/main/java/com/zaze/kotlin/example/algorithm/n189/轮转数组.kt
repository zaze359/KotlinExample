package com.zaze.kotlin.example.algorithm.n189

/**
 * 定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数
 */
class Solution {

    /**
     * 当 k == nums.size 时相当于没有转
     * 所以 最终相当于轮转了 offset = k % nums.size 次
     * 每个元素的位置变为 (i + offset) % nums.size
     *
     * 时间复杂度： O(n)
     * 空间复杂度: O(1)
     */
    fun rotate(nums: IntArray, k: Int): Unit {
        val n = nums.size
        // 相当于每个元素偏移了 offset 个位置
        val offset = k % n
        // 第一步先 将 (offset, end] 交换到前面,即 [1,2,3 ] 和 [5, 6, 7] 对应交换
        val half = Math.ceil(n / 2.0).toInt()
        val swapCount = if (offset > half) { // 超过一半， 只要交换 前 n - offset 部分
            n - offset
        } else { // 未超过，交换 offset
            offset
        }
        for (i in 0 until swapCount) {
            swap(nums, i, n - swapCount + i)
        }
        when {
            offset == half -> {
                // 刚好一半，交换完即完成
                return
            }

            offset < half -> {
                // 例如 nums = [1, 2, 3, 4, 5, 6, 7], k = 2; [6, 7, 1, 2, 3, 4]
                // 交换后 [6, 7, 3, 4, 1, 2]
                // 位移后面交换的部分，3, 4 往后位移 swapCount位即可
                for (i in n - swapCount - 1 downTo swapCount) {
                    repeat(swapCount) {
                        swap(nums, i + it, i + it + 1)
                    }
                }
            }

            else -> { // 超过一半
                // 例如 nums = [1, 2, 3, 4, 5, 6], k = 4; [3, 4, 5, 6, 1, 2]
                // [5, 6, 3, 4, 1, 2]
                // 位移前面 5, 6，offset - swapCount 次
                for (i in swapCount - 1 downTo 0) {
                    repeat(offset - swapCount) {
                        swap(nums, i + it, i + it + 1)
                    }
                }
            }
        }
    }

    private fun swap(nums: IntArray, i: Int, j: Int) {
        val temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
    }
}