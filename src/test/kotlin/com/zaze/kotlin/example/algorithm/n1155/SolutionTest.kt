package com.zaze.kotlin.example.algorithm.n1155

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun numRollsToTarget() {
        val solution = Solution()
        assertEquals(1, solution.numRollsToTarget(1, 6, 3))
        assertEquals(6, solution.numRollsToTarget(2, 6, 7))
        assertEquals(222616187, solution.numRollsToTarget(30, 30, 500))
    }
}