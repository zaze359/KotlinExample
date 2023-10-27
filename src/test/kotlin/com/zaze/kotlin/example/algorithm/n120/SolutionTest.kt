package com.zaze.kotlin.example.algorithm.n120

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun minimumTotal() {
        val solution = Solution()
        assertEquals(
            11, solution.minimumTotal(
                listOf(
                    listOf(2),
                    listOf(3, 4),
                    listOf(6, 5, 7),
                    listOf(4, 1, 8, 3),
                )
            )
        )
    }
}