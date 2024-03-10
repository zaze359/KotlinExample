package com.zaze.kotlin.example.algorithm.n2477

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun minimumFuelCost() {
        val solution = Solution()
        assertEquals(
            3, solution.minimumFuelCost(
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(0, 2),
                    intArrayOf(0, 3),
                ), 5
            )
        )
    }
}