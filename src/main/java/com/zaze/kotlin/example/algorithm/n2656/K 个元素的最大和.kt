package com.zaze.kotlin.example.algorithm.n2656

/**
 * 每次从nums中取出一个数 m，然后添加一个数 m + 1
 * 求 k 次后 取出数的最大和
 */
class Solution {

    /**
     *
     * 遍历选择最大值
     * k次 和 就是 k * m + (0 + 1 + 2 + .. + k -1)
     * k * m + (0 + k - 1) * k / 2
     *
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    fun maximizeSum(nums: IntArray, k: Int): Int {
        return k * nums.max() + (k - 1) * k / 2
    }
}