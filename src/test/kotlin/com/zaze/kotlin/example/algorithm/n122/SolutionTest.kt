package com.zaze.kotlin.example.algorithm.n122

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun maxProfit() {
        val solution = Solution()
        assertEquals(7, solution.maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))
        assertEquals(4, solution.maxProfit(intArrayOf(1, 2, 3, 4, 5)))
        assertEquals(7, solution.maxProfit(intArrayOf(3, 2, 6, 5, 0, 3)))
    }
}