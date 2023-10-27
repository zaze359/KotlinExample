package com.zaze.kotlin.example.algorithm.n2731

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun sumDistance() {
        val solution = Solution()
        assertEquals(8, solution.sumDistance(intArrayOf(-2, 0, 2), "RLL", 3))
        assertEquals(5, solution.sumDistance(intArrayOf(1, 0), "RL", 2))
    }
}