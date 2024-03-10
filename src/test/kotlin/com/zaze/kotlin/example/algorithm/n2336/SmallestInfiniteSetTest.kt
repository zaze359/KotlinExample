package com.zaze.kotlin.example.algorithm.n2336

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SmallestInfiniteSetTest {
    @Test
    fun test() {
        val smallestInfiniteSet = SmallestInfiniteSet()
        smallestInfiniteSet.addBack(2) // 2 已经在集合中，所以不做任何变更。
        assertEquals(1, smallestInfiniteSet.popSmallest())
        assertEquals(2, smallestInfiniteSet.popSmallest())
        assertEquals(3, smallestInfiniteSet.popSmallest())
        smallestInfiniteSet.addBack(1) // 将 1 添加到该集合中。
        assertEquals(1, smallestInfiniteSet.popSmallest())
        assertEquals(4, smallestInfiniteSet.popSmallest())
        assertEquals(5, smallestInfiniteSet.popSmallest())

    }
}