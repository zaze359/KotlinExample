package com.zaze.kotlin.example.algorithm.base.stack

/**
 * 基于数组的顺序栈
 */
class ArrayStack(private val capacity: Int) {

    private val data = Array<String?>(capacity) { null }
    private var count = 0

    /**
     * 入栈
     */
    fun push(item: String): Boolean {
        return when {
            count == capacity -> false
            else -> {
                data[count++] = item
                true
            }
        }
    }

    /**
     * 出栈
     */
    fun pop(): String? {
        if (count == 0) return null
        return data[count--]
    }
}