package com.zaze.kotlin.example.algorithm.n41

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun firstMissingPositive() {
        val solution = Solution()
        assertEquals(3, solution.firstMissingPositive(intArrayOf(1, 2, 0)))
        assertEquals(3, solution.firstMissingPositive2(intArrayOf(1, 2, 0)))
        assertEquals(2, solution.firstMissingPositive(intArrayOf(3, 4, -1, 1)))
        assertEquals(2, solution.firstMissingPositive2(intArrayOf(3, 4, -1, 1)))
        assertEquals(1, solution.firstMissingPositive(intArrayOf(7, 8, 9, 11, 12)))
        assertEquals(1, solution.firstMissingPositive2(intArrayOf(7, 8, 9, 11, 12)))
    }
}