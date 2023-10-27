package com.zaze.kotlin.example.algorithm.n2530

import com.zaze.kotlin.example.algorithm.HeapSort
import java.util.PriorityQueue
import kotlin.math.ceil

/**
 * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
 * 起始分数 为 0 。
 * 每次选择一个数 nums[i]累加, 同时 nums[i] = ceil(nums[i]/3)
 */
class Solution {
    /**
     * 大顶堆
     * 时间复杂度: O(klogn)
     * 空间复杂度：O(1)， 原地堆化
     */
    fun maxKelements(nums: IntArray, k: Int): Long {
        val heap = HeapSort(nums)
        var sum = 0L
        var top: Int
        repeat(k) {
            top = heap.getTop()
            sum += top
            // 浮点优化: +2 等同于 向上取整
            heap.changeTop((top + 2) / 3)
//            heap.changeTop(ceil(top / 3.0).toInt())
        }
        return sum
    }

    /**
     * 使用自带的优先级队列
     * 时间复杂度: O(klogn)
     * 空间复杂度：O(n)
     */
    fun maxKelements2(nums: IntArray, k: Int): Long {
        // 设置为从大到小排序
        val heap = PriorityQueue<Int> { l, r ->
            r - l
        }
        heap.addAll(nums.asList())
        var sum = 0L
        var top: Int
        repeat(k) {
            top = heap.poll()
            sum += top
            heap.offer((top + 2) / 3)
        }
        return sum
    }
}