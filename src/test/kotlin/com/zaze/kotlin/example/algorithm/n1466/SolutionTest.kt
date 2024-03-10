package com.zaze.kotlin.example.algorithm.n1466

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun minReorder() {
        val solution = Solution()
        assertEquals(
            3, solution.minReorder(
                6, arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(1, 3),
                    intArrayOf(2, 3),
                    intArrayOf(4, 0),
                    intArrayOf(4, 5),
                )
            )
        )
        assertEquals(
            2, solution.minReorder(
                5, arrayOf(
                    intArrayOf(1, 0),
                    intArrayOf(1, 2),
                    intArrayOf(3, 2),
                    intArrayOf(3, 4),
                )
            )
        )
        assertEquals(
            0, solution.minReorder(
                3, arrayOf(
                    intArrayOf(1, 0),
                    intArrayOf(2, 0),
                )
            )
        )
    }
}