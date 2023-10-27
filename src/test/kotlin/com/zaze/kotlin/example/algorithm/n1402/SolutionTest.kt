package com.zaze.kotlin.example.algorithm.n1402

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun maxSatisfaction() {
        val solution = Solution()
        assertEquals(14, solution.maxSatisfaction(intArrayOf(-1, -8, 0, 5, -9)))
        assertEquals(20, solution.maxSatisfaction(intArrayOf(4, 3, 2)))
    }
}