package com.zaze.kotlin.example.algorithm.o10

import kotlin.test.assertEquals
import org.junit.jupiter.api.Test


class TestSolution {

    @Test
    fun testFib() {
        val solution = Solution()
//        assertEquals(1, solution.fib3(2))
//        assertEquals(5, solution.fib3(5))
//        assertEquals(8, solution.fib3(6))
//        assertEquals(13, solution.fib3(7))
        assertEquals(807526948, solution.fib3(48))
    }
}