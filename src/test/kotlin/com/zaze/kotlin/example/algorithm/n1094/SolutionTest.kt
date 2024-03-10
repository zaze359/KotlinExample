package com.zaze.kotlin.example.algorithm.n1094

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun carPooling() {
        val solution = Solution()
        assertFalse(
            solution.carPooling(
                arrayOf(
                    intArrayOf(2, 1, 5), intArrayOf(3, 3, 7)
                ), 4
            )
        )
        assertTrue(
            solution.carPooling(
                arrayOf(
                    intArrayOf(2, 1, 5), intArrayOf(3, 3, 7)
                ), 5
            )
        )
    }
}