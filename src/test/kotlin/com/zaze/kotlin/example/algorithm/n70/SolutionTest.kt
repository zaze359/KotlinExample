package com.zaze.kotlin.example.algorithm.n70

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun climbStairs() {
        val solution = Solution()
        assertEquals(2, solution.climbStairs(2))
        assertEquals(3, solution.climbStairs(3))

    }
}