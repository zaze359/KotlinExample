package com.zaze.kotlin.example.algorithm.n137

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun singleNumber() {
        val solution = Solution()
        assertEquals(3, solution.singleNumber(intArrayOf(2, 2, 3, 2)))
        assertEquals(99, solution.singleNumber(intArrayOf(0, 1, 0, 1, 0, 1, 99)))
    }
}