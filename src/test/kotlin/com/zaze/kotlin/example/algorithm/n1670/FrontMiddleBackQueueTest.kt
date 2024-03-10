package com.zaze.kotlin.example.algorithm.n1670

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import kotlin.test.assertContentEquals

class FrontMiddleBackQueueTest {

    @Test
    fun test() {
        val queue = FrontMiddleBackQueue()
        queue.pushFront(1);   // [1]
        queue.pushBack(2);    // [1, 2]
        queue.pushMiddle(3);  // [1, 3, 2]
        queue.pushMiddle(4);  // [1, 4, 3, 2]
        queue.popFront();     // 返回 1 -> [4, 3, 2]
        queue.popMiddle();    // 返回 3 -> [4, 2]
        queue.popMiddle();    // 返回 4 -> [2]
        queue.popBack();      // 返回 2 -> []
        queue.popFront();     // 返回 -1 -> [] （队列为空）
    }
}