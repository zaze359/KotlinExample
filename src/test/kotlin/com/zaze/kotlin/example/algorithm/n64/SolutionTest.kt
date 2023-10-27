package com.zaze.kotlin.example.algorithm.n64

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun minPathSum() {
        val solution = Solution()
        assertEquals(
            7,
            solution.minPathSum(
                arrayOf(
                    intArrayOf(1, 3, 1),
                    intArrayOf(1, 5, 1),
                    intArrayOf(4, 2, 1)
                )
            )
        )
        assertEquals(
            12,
            solution.minPathSum(
                arrayOf(
                    intArrayOf(1, 2, 3),
                    intArrayOf(4, 5, 6),
                )
            )
        )
    }
}