package com.zaze.kotlin.example.algorithm.n622

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse

class MyCircularQueueTest {

    @Test
    fun test() {
        val circularQueue = MyCircularQueue(3) // 设置长度为 3
        assert(circularQueue.enQueue(1))
        assert(circularQueue.enQueue(2))
        assert(circularQueue.enQueue(3))
        assertFalse {
            // 返回 false，队列已满
            circularQueue.enQueue(4)
        }
        assertEquals(3, circularQueue.Rear())
        assert(circularQueue.isFull())
        // 删除一个，
        assert(circularQueue.deQueue())
        // 重新插入
        assert(circularQueue.enQueue(4))
        assertEquals(4, circularQueue.Rear())

    }

}