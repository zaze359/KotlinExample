package com.zaze.kotlin.example.algorithm.n239

import java.util.Deque
import java.util.PriorityQueue

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。
 * 滑动窗口每次只向右移动一位。
 */
class Solution {

    /**
     * 单调递减队列.
     * 记录每次比较最大值的下标
     * 大值的下标在前，即num[queue[i]] > num[queue[i + 1]]
     */
    val queue = ArrayDeque<Int>()

    /**
     * 时间复杂度: O(n), 每个数据入队一次，最多出队一次
     * 空间：O(k)
     */
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        if (nums.isEmpty()) return intArrayOf(0)
        if (nums.size <= k) {
            return intArrayOf(getMax(nums, 0, nums.size - 1, nums.size))
        }
        queue.clear()
        // 每次移动一位，所以存在 size - k + 1 个结果
        val ret = IntArray(nums.size - k + 1)
        repeat(ret.size) {
            // 第一组需要处理k 个数据，后续几组重新处理 1个数据即可
            ret[it] = getMax(nums, 0 + it, k - 1 + it, if (it == 0) k else 1)
        }
        return ret
    }

    /**
     * size 表示 需要处理的数据长度。
     */
    private fun getMax(nums: IntArray, start: Int, end: Int, size: Int): Int {
        if (start == end) {
            return nums[start]
        }
        // O(size)
        for (i in end - size + 1 .. end) {
            // 逐个比较
            while (!queue.isEmpty() && nums[i] >= nums[queue.last()]) {
                // 新值 较大，去除最小值
                queue.removeLast()
            }
            queue.addLast(i)
        }
        //
        // 第一个就是最大值
        while (queue.first() < start) {
            queue.removeFirst()
        }
        return nums[queue.first()]
    }
}