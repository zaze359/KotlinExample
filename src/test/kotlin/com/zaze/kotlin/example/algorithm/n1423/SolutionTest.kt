package com.zaze.kotlin.example.algorithm.n1423

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun maxScore() {
        val solution = Solution()
        assertEquals(12, solution.maxScore(intArrayOf(1, 2, 3, 4, 5, 6, 1), 3))
        assertEquals(55, solution.maxScore(intArrayOf(9, 7, 7, 9, 7, 7, 9), 7))
    }
}