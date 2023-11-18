package com.zaze.kotlin.example.algorithm.n274

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun hIndex() {
        val solution = Solution()
        assertEquals(3, solution.hIndex(intArrayOf(3, 0, 6, 1, 5)))
        assertEquals(1, solution.hIndex(intArrayOf(1, 3, 1)))
        assertEquals(1, solution.hIndex(intArrayOf(100)))
        assertEquals(1, solution.hIndex(intArrayOf(0, 1)))
        assertEquals(2, solution.hIndex(intArrayOf(11, 15)))
    }
}