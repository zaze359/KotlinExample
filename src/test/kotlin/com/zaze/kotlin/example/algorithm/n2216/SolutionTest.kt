package com.zaze.kotlin.example.algorithm.n2216

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun minDeletion() {
        val solution = Solution()
        assertEquals(1, solution.minDeletion(intArrayOf(7, 1, 2, 2, 1, 7, 5, 8, 0, 2, 0, 7, 4, 1, 4, 3, 6, 9, 4)))
        assertEquals(1, solution.minDeletion(intArrayOf(1, 1, 2, 3, 5)))
        assertEquals(2, solution.minDeletion(intArrayOf(1, 1, 2, 2, 3, 3)))
    }
}