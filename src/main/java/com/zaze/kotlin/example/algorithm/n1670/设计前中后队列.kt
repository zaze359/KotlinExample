package com.zaze.kotlin.example.algorithm.n1670

import java.util.LinkedList

/**
 * 使用两个均分的双端队列来实现
 * left存储左边部分，right存储右边部分
 */
class FrontMiddleBackQueue() {
    /**
     * 维护 start ~ mid
     */
    private val left = LinkedList<Int>()

    /**
     * 维护 mid ~ end
     */
    private val right = LinkedList<Int>()

    /**
     * 将 val 添加到队列的 最前面
     */
    fun pushFront(`val`: Int) {
        left.addFirst(`val`)
        balance()
    }

    /**
     * 将 val 添加到队列的 正中间 。
     */
    fun pushMiddle(`val`: Int) {
        if (left.size == right.size) {
            left.addLast(`val`)
        } else {
            left.add(left.size - 1, `val`)
            balance()
        }
    }

    /**
     * 将 val 添加到队里的 最后面
     */
    fun pushBack(`val`: Int) {
        right.addLast(`val`)
        balance()
    }

    /**
     * 将 最前面 的元素从队列中删除并返回值，如果删除之前队列为空，那么返回 -1
     */
    fun popFront(): Int {
        if (left.isEmpty()) return -1
        return left.pop().apply {
            balance()
        }
    }


    /**
     *  将 正中间 的元素从队列中删除并返回值，如果删除之前队列为空，那么返回 -1
     */
    fun popMiddle(): Int {
        return when {
            left.isEmpty() -> {
                -1
            }

            else -> { // 中间元素一定在左边最后一个
                left.pollLast()
            }
        }.apply {
            balance()
        }
    }

    /**
     * 将 最后面 的元素从队列中删除并返回值，如果删除之前队列为空，那么返回 -1
     */
    fun popBack(): Int {
        return when {
            left.isEmpty() -> {
                -1
            }

            right.isEmpty() -> {
                left.pollLast()
            }

            else -> {
                right.pollLast()
            }
        }.apply {
            balance()
        }
    }

    /**
     * 平衡左右队列， 左边最多可以比右边大1, 保证中间元素在左边最后
     */
    private fun balance() {
        val shiftSize = left.size - right.size
        when {
            shiftSize > 1 -> { // 左边多，左移
                repeat(shiftSize - 1) {
                    right.addFirst(left.pollLast())
                }
            }

            shiftSize < 0 -> { // 右边多，右移
                repeat(-shiftSize) {
                    left.addLast(right.pop())
                }
            }

            else -> { // 左右相等或者 左边多一个，属于平衡

            }
        }
    }

}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * var obj = FrontMiddleBackQueue()
 * obj.pushFront(`val`)
 * obj.pushMiddle(`val`)
 * obj.pushBack(`val`)
 * var param_4 = obj.popFront()
 * var param_5 = obj.popMiddle()
 * var param_6 = obj.popBack()
 */