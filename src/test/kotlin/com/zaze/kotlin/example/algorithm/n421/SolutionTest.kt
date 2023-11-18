package com.zaze.kotlin.example.algorithm.n421

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun findMaximumXOR() {
        val solution = Solution()
        assertEquals(28, solution.findMaximumXOR(intArrayOf(3, 10, 5, 25, 2, 8)))
        assertEquals(127, solution.findMaximumXOR(intArrayOf(14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70)))
    }
}