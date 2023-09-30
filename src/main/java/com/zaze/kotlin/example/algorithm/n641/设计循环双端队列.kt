package com.zaze.kotlin.example.algorithm.n641

/**
 * 循环双端队列，队首队尾都支持插入/删除元素
 */
class MyCircularDeque(k: Int) {

    // 使用数组实现循环队列 head和tail间的一个位置不存储数据，所以需要 + 1
    private val capacity = k + 1
    private val data = Array(capacity) { -1 }

    // 指向对头，表示获取数据的位置
    private var head: Int = 0

    // 队尾，表示后续插入数据的位置
    // tail - 1就是最后一个数据的下标。
    private var tail: Int = 0

    /**
     * 从队首前插入一个元素。如果成功插入则返回true
     */
    fun insertFront(value: Int): Boolean {
        if (isFull()) { // 队满
            return false
        }
        // 队首前面的位置插入元素
        head = (capacity + head - 1) % capacity
        data[head] = value
        return true
    }

    fun insertLast(value: Int): Boolean {
        if (isFull()) { // 队满
            return false
        }
        data[tail] = value
        tail = (tail + 1) % capacity
        return true
    }

    /**
     * 删除队首元素。如果成功删除则返回true
     */
    fun deleteFront(): Boolean {
        if (isEmpty()) return false
//        val ret = data[head]
        head = (head + 1) % capacity
        return true
    }

    /**
     * 删除队尾元素
     */
    fun deleteLast(): Boolean {
        if (isEmpty()) return false
        tail = (capacity + tail - 1) % capacity
        return true
    }

    /**
     * 从队首获取元素。如果队列为空，返回 -1
     */
    fun getFront(): Int {
        if (isEmpty()) return -1
        return data[head]
    }

    /**
     * 获取队尾元素。如果队列为空，返回 -1
     */
    fun getRear(): Int {
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
 * Your MyCircularDeque object will be instantiated and called as such:
 * var obj = MyCircularDeque(k)
 * var param_1 = obj.insertFront(value)
 * var param_2 = obj.insertLast(value)
 * var param_3 = obj.deleteFront()
 * var param_4 = obj.deleteLast()
 * var param_5 = obj.getFront()
 * var param_6 = obj.getRear()
 * var param_7 = obj.isEmpty()
 * var param_8 = obj.isFull()
 */