package com.zaze.kotlin.example.algorithm

object Sort {
    /**
     * 冒泡排序
     */
    fun bubbleSort(arrays: IntArray, compare: (Int, Int) -> Boolean = { f, s -> f > s }): IntArray {
        // 倒序遍历：表示需要比对的次数
        for (end in (arrays.size - 1) downTo 1) {
            // 顺序遍历：进行比对
            for (begin in 0 until end) {
                if (compare(arrays[begin], arrays[begin + 1])) {
                    // 前一个大于后一个则交换
                    val temp = arrays[begin]
                    arrays[begin] = arrays[begin + 1]
                    arrays[begin + 1] = temp
                }
            }
        }
        return arrays
    }
}