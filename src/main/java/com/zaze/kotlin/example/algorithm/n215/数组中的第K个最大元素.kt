package com.zaze.kotlin.example.algorithm.n215

import com.zaze.kotlin.example.algorithm.HeapSort

/**
 * 定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 12345, 第2个最大就是 4
 * 要求：时间复杂度为 O(n)
 */
class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
//        // 快排
//        // 这里将第K大 转换为 求 第 nums.size - k 个位置的元素，方便后续计算
//        val position = nums.size - k
//        quickSort(nums, position)
//        return nums[position]
        // 堆排
        return heapSort(nums, k)
    }

    // ------------------- 快排 start ------------------------------

    /**
     * 使用快排的思想处理.
     * 这里求的是第K大，并不需要完全有序，仅需要找到即可，且递归分区时仅需要递归一部分分区即可
     * 此时时间复杂度是 O(n)
     */
    private fun quickSort(arr: IntArray, position: Int) {
        actualQuickSort(arr, 0, arr.size - 1, position)
    }

    /**
     * 递归执行
     * 递归分区 K 所在的那一部分分区即可
     */
    private fun actualQuickSort(arr: IntArray, start: Int, end: Int, position: Int) {
        if (start > end) {
            return
        }
        if (start == end) {
            return
        }
        val pivot = partition(arr, start, end)
        when {
            pivot == position -> { // 直接找到了第 position个元素
            }

            pivot >= position -> { // 第 position个元素在 pivot 前面
                actualQuickSort(arr, start, pivot - 1, position)
            }

            else -> { // 第 position个元素 在 pivot 后面
                actualQuickSort(arr, pivot + 1, end, position)
            }
        }
    }


    /**
     * 移位法
     */
    private fun partition(nums: IntArray, start: Int, end: Int): Int {
        var left = start
        var right = end
        val pivot = nums[left]
        while (left < right) {
            while (left < right && nums[right] > pivot) {
                right--
            }
            if (left < right) {
                nums[left++] = nums[right]
            }
            while (left < right && nums[left] < pivot) {
                left++
            }
            if (left < right) {
                nums[right--] = nums[left]
            }
        }
        nums[left] = pivot
        return left
    }

    /**
     * 分区函数，分区并返回分区点
     */
    private fun partition2(arr: IntArray, start: Int, end: Int): Int {
        // 获取分区操作的分区比较点
        val pivot = arr[end]
        var i: Int = start // 指向已分区插入节点位置
        for (j in start..end) {
            if (arr[j] <= pivot) {
                // <= pivot，加入到已分区末尾
                // 交换
                swap(arr, i, j)
                if (j != end) {
                    // 不是最后一位，就后移一位
                    // 遍历到最后时，必然等于pivot，此时交换即可，且i就是分区点
                    i++
                }
            }
        }
        return i
    }

    private fun swap(arr: IntArray, i: Int, j: Int) {
        val temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp
    }

    // ------------------- 快排 end ------------------------------

    /**
     * 堆排序
     */
    private fun heapSort(nums: IntArray, k: Int):Int {
        val heap = HeapSort(nums.size)
        // 堆排
        nums.forEach {
            heap.insert(it)
        }
        var value = 0
        repeat(k) {
            value = heap.getTop()
            heap.removeTop()
        }
        return value
    }

}