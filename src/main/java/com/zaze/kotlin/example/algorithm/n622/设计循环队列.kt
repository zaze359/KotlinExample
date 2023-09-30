package com.zaze.kotlin.example.algorithm.n622

/**
 * 循环队列，仅队首删除元素，队尾插入元素
 */
class MyCircularQueue(k: Int) {

    // 使用数组实现循环队列 head和tail间的一个位置不存储数据，所以需要 + 1
    private val capacity = k + 1
    private val data = Array(capacity) { -1 }

    // 指向对头，表示获取数据的位置
    private var head: Int = 0

    // 队尾，表示后续插入数据的位置
    // tail - 1就是最后一个数据的下标。
    private var tail: Int = 0

    /**
     * 向循环队列队尾插入一个元素。如果成功插入则返回true
     */
    fun enQueue(value: Int): Boolean {
        if (isFull()) { // 队满
            return false
        }
        data[tail++] = value
        tail %= capacity
        return true
    }

    /**
     * 从循环队列中队首删除一个元素。如果成功删除则返回true
     */
    fun deQueue(): Boolean {
        // 队空
        if (isEmpty()) return false
//        val ret = data[head]
        head = (head + 1) % capacity
        return true
    }

    /**
     * 从队首获取元素。如果队列为空，返回 -1
     */
    fun Front(): Int {
        if (isEmpty()) return -1
        return data[head]
    }

    /**
     * 获取队尾元素。如果队列为空，返回 -1
     */
    fun Rear(): Int {
        if (isEmpty()) return -1
        // 处理0 - 1的情况，防止越界
        return data[(capacity + tail - 1) % capacity]
    }

    fun isEmpty(): Boolean {
        return head == tail
    }

    fun isFull(): Boolean {
        // 循环队列，head和tail间的一个位置不存储数据，方便判断队满
        return (tail + 1) % capacity == head
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * var obj = MyCircularQueue(k)
 * var param_1 = obj.enQueue(value)
 * var param_2 = obj.deQueue()
 * var param_3 = obj.Front()
 * var param_4 = obj.Rear()
 * var param_5 = obj.isEmpty()
 * var param_6 = obj.isFull()
 */