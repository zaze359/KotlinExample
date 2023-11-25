package com.zaze.kotlin.example.algorithm.n2304

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun minPathCost() {
        val solution = Solution()
        assertEquals(
            17, solution.minPathCost(
                arrayOf(
                    intArrayOf(5, 3),
                    intArrayOf(4, 0),
                    intArrayOf(2, 1),
                ), arrayOf(
                    intArrayOf(9, 8),
                    intArrayOf(1, 5),
                    intArrayOf(10, 12),
                    intArrayOf(18, 6),
                    intArrayOf(2, 4),
                    intArrayOf(14, 3),
                )
            )
        )
    }
}