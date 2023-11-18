package com.zaze.kotlin.example.algorithm.n2760

/**
 * 从nums 中找出连续的奇偶子数组 nums[l] ~ nums[r]，并且子数组所有元素 nums[i] <= threshold
 * nums[l] 为 偶数
 *
 * 返回最长的子数组的长度
 */
class Solution {

    /**
     * 穷举 + 动态规划
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    fun longestAlternatingSubarray(nums: IntArray, threshold: Int): Int {
        var maxLength = 0 // 记录最大长度
        var tempLength = 0 // 记录当前子数组 长度
        var preNum = 0 // 记录前一个值
        // 遍历过程中记录 求出所有奇偶子数组的长度，记录最大的那个
        nums.forEachIndexed { index, i ->
            when {
                i > threshold -> { // 当前值超过阈值
                    // 初始化
                    tempLength = 0
                    preNum = 0
                }

                i % 2 == 0 -> { // 当前是偶数
                    if (tempLength == 0 || preNum % 2 == 0) {
                        // 1. 未找到过子数组
                        // 2. 连续两个偶数
                        // 两种情况都表示 新子数组的开始
                        tempLength = 1
                    } else { // 之前是奇数
                        tempLength++
                    }
                    preNum = i
                    maxLength = maxOf(maxLength, tempLength)
                }

                else -> { // 当前奇数
                    if (tempLength != 0 && preNum % 2 == 0) { // 若之前是偶数，且以找到子数组
                        tempLength++
                        maxLength = maxOf(maxLength, tempLength)
                    } else { // 中断了，清空
                        tempLength = 0
                        preNum = 0
                    }
                    preNum = i
                }
            }
        }
        return maxLength
    }
}