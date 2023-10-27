package com.zaze.kotlin.example.algorithm.n1465

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun maxArea() {
        val solution = Solution()
        assertEquals(
            6, solution.maxArea(
                h = 5, w = 4,
                horizontalCuts = intArrayOf(3, 1),
                verticalCuts = intArrayOf(1)
            )
        )
        assertEquals(
            9, solution.maxArea(
                h = 5, w = 4,
                horizontalCuts = intArrayOf(3),
                verticalCuts = intArrayOf(3)
            )
        )
        assertEquals(
            6, solution.maxArea(
                h = 8, w = 5,
                horizontalCuts = intArrayOf(5, 2, 6, 3),
                verticalCuts = intArrayOf(1, 4)
            )
        )
        assertEquals(
            4, solution.maxArea(
                h = 3, w = 8,
                horizontalCuts = intArrayOf(2),
                verticalCuts = intArrayOf(2, 7, 1, 4, 3, 6)
            )
        )
        assertEquals(
            6, solution.maxArea(
                h = 8, w = 3,
                horizontalCuts = intArrayOf(5, 7, 3, 4, 6),
                verticalCuts = intArrayOf(2)
            )
        )
        assertEquals(
            2, solution.maxArea(
                h = 6, w = 2,
                horizontalCuts = intArrayOf(4, 1, 3, 5),
                verticalCuts = intArrayOf(1)
            )
        )
    }
}