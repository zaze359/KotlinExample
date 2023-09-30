package com.zaze.kotlin.example.algorithm.n704

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun search() {
        val solution = Solution()
        assertEquals(4, solution.search(intArrayOf(-1, 0, 3, 5, 9, 12), 9))
        assertEquals(-1, solution.search(intArrayOf(-1, 0, 3, 5, 9, 12), 2))
    }
}