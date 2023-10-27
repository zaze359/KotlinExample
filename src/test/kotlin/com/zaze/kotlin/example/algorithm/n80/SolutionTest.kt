package com.zaze.kotlin.example.algorithm.n80

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun removeDuplicates() {
        val solution = Solution()
        assertEquals(5, solution.removeDuplicates(intArrayOf(1, 1, 1, 2, 2, 3)))
        assertEquals(7, solution.removeDuplicates(intArrayOf(0, 0, 1, 1, 1, 1, 2, 3, 3)))
    }
}