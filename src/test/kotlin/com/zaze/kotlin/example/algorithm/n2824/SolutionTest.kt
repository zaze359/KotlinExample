package com.zaze.kotlin.example.algorithm.n2824

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun countPairs() {
        val solution = Solution()
        assertEquals(3, solution.countPairs(listOf(-1, 1, 2, 3, 1), 2))
        assertEquals(10, solution.countPairs(listOf(-6, 2, 5, -2, -7, -1, 3), -2))
    }
}