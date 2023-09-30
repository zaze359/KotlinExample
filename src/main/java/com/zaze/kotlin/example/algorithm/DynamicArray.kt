package com.zaze.kotlin.example.algorithm

/**
 * 支持动态扩容数组
 */
class DynamicArray(
    // 数组容量大小
    private var capacity: Int = DEFAULT_CAPACITY
) {
    companion object {
        // 默认容量
        private const val DEFAULT_CAPACITY = 10

        // 最大容量
        private const val MAX_CAPACITY = Int.MAX_VALUE
    }

    // 当前已存储数据的长度
    private var usedSize = 0

    private var data: Array<Int>

    init {
        data = Array(capacity) {
            0
        }
    }

    fun add(value: Int): Boolean {
        return insert(usedSize, value)
    }

    fun insert(index: Int, value: Int): Boolean {
        if (usedSize >= capacity) {
            grow()
        }
        if (usedSize >= capacity) {
            println("数组已满: $usedSize")
            return false
        }
        // 将 添加位置及后面的数据后移一位
        (usedSize downTo index + 1).forEach {
            data[it] = data[it - 1]
        }
        // 更新目标位置到值
        data[index] = value

        usedSize++
        return true
    }

    fun remove(value: Int) {
        val index = indexOf(value)
        if (index < 0) return
        // 将删除位置后面的数据前移一位
        (index until usedSize).forEach {
            data[it] = data[it + 1]
        }
        // 直接减一即可，末尾数据不一定需要清除。
//        data[usedSize] = 0
        usedSize--
    }

    fun indexOf(value: Int): Int {
        for (i in 0 until usedSize) {
            if (data[i] == value) return i
        }
        return -1
    }

    private fun grow() {
        if (capacity >= MAX_CAPACITY) {
            return
        }
        capacity = Math.min(capacity * 2, MAX_CAPACITY)
        data = Array(capacity) {
            if (it < data.size) {
                data[it]
            } else {
                0
            }
        }
    }

}