package com.zaze.kotlin.example.algorithm.n1631

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun minimumEffortPath() {
        val solution = Solution()
        assertEquals(
            2,
            solution.minimumEffortPath(arrayOf(intArrayOf(1, 2, 2), intArrayOf(3, 8, 2), intArrayOf(5, 3, 5)))
        )
        assertEquals(
            1,
            solution.minimumEffortPath(arrayOf(intArrayOf(1, 2, 3), intArrayOf(3, 8, 4), intArrayOf(5, 3, 5)))
        )
    }
}