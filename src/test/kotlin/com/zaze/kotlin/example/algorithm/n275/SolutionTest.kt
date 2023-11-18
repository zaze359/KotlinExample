package com.zaze.kotlin.example.algorithm.n275

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun hIndex() {
        val solution = Solution()
        assertEquals(2, solution.hIndex(intArrayOf(0, 0, 4, 4)))
        assertEquals(3, solution.hIndex(intArrayOf(0, 1, 3, 6, 5)))
        assertEquals(1, solution.hIndex(intArrayOf(1, 1, 3)))
        assertEquals(1, solution.hIndex(intArrayOf(100)))
        assertEquals(1, solution.hIndex(intArrayOf(0, 1)))
        assertEquals(2, solution.hIndex(intArrayOf(11, 15)))
        assertEquals(2, solution.hIndex(intArrayOf(1, 2, 100)))
    }
}