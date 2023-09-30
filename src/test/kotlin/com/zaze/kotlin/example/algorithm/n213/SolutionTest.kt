package com.zaze.kotlin.example.algorithm.n213

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun rob() {
        val solution = Solution()
        assertEquals(3, solution.rob(intArrayOf(2, 3, 2)))
        assertEquals(4, solution.rob(intArrayOf(1, 2, 3, 1)))
        assertEquals(3, solution.rob(intArrayOf(1, 2, 3)))
        assertEquals(103, solution.rob(intArrayOf(1, 3, 1, 3, 100)))
        assertEquals(8, solution.rob(intArrayOf(1, 4, 1, 1, 4)))
    }

}