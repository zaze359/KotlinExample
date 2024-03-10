package com.zaze.kotlin.example.algorithm.base

/**
 * 堆排
 * 下标从 0 开始，原地将数组进行堆化
 */
class HeapSort {
    private val data: IntArray
    private val n: Int
    var count: Int
        // 已存储数据个数
        private set

    constructor(nums: IntArray) {
        data = nums
        n = data.size
        count = data.size
        // 从最后一个非叶子节点开始堆化
        // 数组堆化: 时间复杂度 O(n)
        for (i in n / 2 - 1 downTo 0) {
            maxHeapify(i)
        }
    }

    constructor(capacity: Int) {
        data = IntArray(capacity)
        n = data.size
        count = 0
    }

    /**
     * 时间复杂度: O(logn)
     */
    fun insert(value: Int) {
        if (count >= n) return
        count++
        data[count - 1] = value
        // 从最后一个节点, 自下往上堆化
        var i = count - 1
        while (i > 0) {
            val parent = (i - 1) / 2
            if (data[i] > data[parent]) {
                swap(i, parent)
            }
            i = parent
        }
    }

    /**
     * 时间复杂度: O(logn)
     */
    fun removeTop() {
        // 将根节点和最后一个叶子节点交换，并删除
        swap(0, count - 1)
        count--
        // 堆化
        maxHeapify(0)
    }

    fun getTop(): Int {
        if (count == 0) return -1
        return data[0]
    }

    fun changeTop(value: Int) {
        if (count > 0) {
            data[0] = value
            maxHeapify(0)
        } else {
            insert(value)
        }
    }

    /**
     * 自上往下堆化: 大顶堆
     * 时间复杂度: O(logn)
     * 空间复杂度: O(1),原地堆化
     * [node]：指定堆化的非叶子节点 node
     */
    private fun maxHeapify(node: Int) {
        if (count <= 0 || node < 0) return
        var i = node
        var left: Int
        var right: Int
        var largest: Int
        while (true) {
            left = i * 2 + 1
            right = i * 2 + 2
            largest = i
            if (left < count && data[left] > data[largest]) {
                largest = left
            }
            if (right < count && data[right] > data[largest]) {
                largest = right
            }
            if (i == largest) return
            swap(i, largest)
            i = largest
        }
    }

    fun isNotEmpty(): Boolean {
        return count > 0
    }

    private fun swap(i: Int, j: Int) {
        if (i == j) return
        val temp = data[i]
        data[i] = data[j]
        data[j] = temp
    }

    /**
     * 堆排序, 从小到大
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(1)
     */
    fun sort() {
        val c = count
        // 排序的过程等同于 将堆顶数据一个个删除。
        // 由于是大顶堆，所以结果就是从小到大
        repeat(c) {
            removeTop()
        }
        count = c
    }

    fun sorted(): IntArray {
        sort()
        return data.copyOfRange(0, count)
    }
}