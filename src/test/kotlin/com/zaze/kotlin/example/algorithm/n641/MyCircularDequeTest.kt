package com.zaze.kotlin.example.algorithm.n641

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MyCircularDequeTest {
    @Test
    fun test() {
        val circularDeque = MyCircularDeque(3) // 设置容量大小为3
        assert(circularDeque.insertLast(1))
        assert(circularDeque.insertLast(2))
        assert(circularDeque.insertFront(3))
        assertFalse(circularDeque.insertLast(4))
        // 此时队列 [3, 1, 2]
        assertEquals(2, circularDeque.getRear())
        assert(circularDeque.isFull())
        // 删除队尾
        assert(circularDeque.deleteLast())
        // 队首插入 4
        assert(circularDeque.insertFront(4))
        // 获取队首4
        assertEquals(4, circularDeque.getFront())
    }
}