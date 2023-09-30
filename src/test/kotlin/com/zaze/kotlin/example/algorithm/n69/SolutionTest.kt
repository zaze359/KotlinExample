package com.zaze.kotlin.example.algorithm.n69

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun mySqrt() {
        val solution = Solution()
//        assertEquals(2, solution.mySqrt(4))
//        assertEquals(2, solution.mySqrt(8))
        assertEquals(46339, solution.mySqrt(2147395599))
    }
}