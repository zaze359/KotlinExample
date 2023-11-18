package com.zaze.kotlin.example.algorithm.n2258

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun maximumMinutes() {
        val solution = Solution()
        assertEquals(
            1, solution.maximumMinutes(
                arrayOf(
                    intArrayOf(0, 0, 0, 0, 0, 0),
                    intArrayOf(0, 2, 2, 2, 2, 0),
                    intArrayOf(0, 0, 0, 1, 2, 0),
                    intArrayOf(0, 2, 2, 2, 2, 0),
                    intArrayOf(0, 0, 0, 0, 0, 0)
                )
            )
        )
        assertEquals(
            3, solution.maximumMinutes(
                arrayOf(
                    intArrayOf(0, 2, 0, 0, 0, 0, 0),
                    intArrayOf(0, 0, 0, 2, 2, 1, 0),
                    intArrayOf(0, 2, 0, 0, 1, 2, 0),
                    intArrayOf(0, 0, 2, 2, 2, 0, 2),
                    intArrayOf(0, 0, 0, 0, 0, 0, 0),
                )
            )
        )
        assertEquals(
            -1, solution.maximumMinutes(
                arrayOf(
                    intArrayOf(0, 0, 0, 0),
                    intArrayOf(0, 1, 2, 0),
                    intArrayOf(0, 2, 0, 0),
                )
            )
        )
        assertEquals(
            1000000000, solution.maximumMinutes(
                arrayOf(
                    intArrayOf(0, 0, 0),
                    intArrayOf(2, 2, 0),
                    intArrayOf(1, 2, 0),
                )
            )
        )

        assertEquals(
            -1, solution.maximumMinutes(
                arrayOf(
                    intArrayOf(0, 0, 2, 2, 1, 1, 0, 2, 1, 1, 2, 2, 0, 2, 2, 1, 2, 0, 1, 2, 2, 0, 1, 2, 2, 1, 2, 2),
                    intArrayOf(2, 2, 2, 1, 1, 2, 2, 1, 2, 0, 1, 1, 1, 2, 2, 1, 1, 0, 2, 2, 2, 0, 1, 0, 1, 2, 2, 2),
                    intArrayOf(0, 0, 1, 1, 0, 1, 2, 0, 1, 1, 1, 1, 0, 2, 0, 2, 0, 2, 1, 1, 0, 2, 1, 2, 2, 2, 1, 2),
                    intArrayOf(2, 2, 0, 0, 0, 0, 1, 0, 1, 0, 2, 0, 1, 0, 2, 0, 0, 1, 2, 1, 0, 1, 1, 1, 2, 0, 2, 0),
                    intArrayOf(2, 2, 1, 1, 1, 1, 1, 0, 0, 0, 0, 2, 0, 1, 1, 1, 1, 2, 0, 2, 1, 1, 2, 0, 2, 0, 2, 0),
                    intArrayOf(0, 1, 0, 1, 2, 2, 2, 0, 2, 0, 2, 2, 1, 2, 0, 0, 1, 0, 2, 0, 2, 0, 1, 2, 2, 0, 2, 0),
                    intArrayOf(1, 0, 2, 2, 2, 0, 2, 0, 2, 0, 2, 0, 1, 0, 2, 2, 0, 2, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0),
                    intArrayOf(0, 1, 2, 0, 1, 0, 1, 0, 2, 1, 2, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 2, 0, 1, 0, 1, 0, 2),
                    intArrayOf(2, 1, 1, 0, 1, 1, 2, 2, 1, 2, 2, 1, 0, 1, 0, 0, 0, 2, 1, 0, 2, 2, 1, 2, 1, 2, 0, 1),
                    intArrayOf(1, 1, 2, 0, 2, 2, 1, 2, 0, 2, 1, 1, 0, 0, 0, 2, 2, 2, 2, 1, 2, 2, 0, 2, 1, 1, 2, 0),
                    intArrayOf(2, 1, 2, 2, 0, 0, 1, 0, 1, 2, 1, 0, 1, 0, 2, 0, 0, 1, 1, 0, 2, 0, 2, 0, 1, 2, 2, 0),
                    intArrayOf(1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 2, 0, 2, 1, 2, 1, 1, 0, 1, 0, 0, 2, 1, 2, 1, 0, 2),
                    intArrayOf(2, 0, 1, 0, 2, 0, 1, 0, 2, 0, 2, 1, 2, 0, 2, 2, 2, 1, 0, 2, 1, 0, 1, 2, 1, 0, 1, 1),
                    intArrayOf(0, 2, 2, 1, 0, 2, 1, 0, 1, 2, 2, 1, 2, 2, 1, 2, 0, 1, 2, 2, 0, 2, 1, 0, 2, 1, 0, 0),
                    intArrayOf(0, 2, 2, 2, 1, 2, 1, 0, 0, 2, 2, 0, 1, 0, 2, 1, 0, 0, 2, 1, 1, 1, 2, 1, 2, 1, 0, 1),
                    intArrayOf(2, 2, 2, 1, 1, 1, 1, 0, 2, 2, 2, 1, 0, 0, 2, 2, 0, 0, 1, 1, 0, 0, 2, 1, 2, 1, 2, 2),
                    intArrayOf(2, 1, 2, 1, 1, 1, 0, 2, 1, 0, 1, 1, 2, 1, 0, 0, 1, 1, 2, 1, 2, 2, 1, 2, 0, 2, 0, 0)
                )
            )
        )
    }
}