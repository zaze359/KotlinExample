package com.zaze.kotlin.example.algorithm.n2646

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun minimumTotalPrice() {
        val solution = Solution()
        assertEquals(
            23, solution.minimumTotalPrice(
                n = 4, edges = arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(1, 2),
                    intArrayOf(1, 3),
                ), price = intArrayOf(2, 2, 10, 6), trips = arrayOf(
                    intArrayOf(0, 3),
                    intArrayOf(2, 1),
                    intArrayOf(2, 3),
                )
            )
        )
    }
}