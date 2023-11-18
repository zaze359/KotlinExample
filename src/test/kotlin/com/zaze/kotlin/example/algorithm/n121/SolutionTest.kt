package com.zaze.kotlin.example.algorithm.n121

import kotlin.test.assertEquals
import org.junit.jupiter.api.Test


class SolutionTest {

    @Test
    fun testBuildTree() {
        val solution = Solution()
        assertEquals(5, solution.maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))
        assertEquals(0, solution.maxProfit(intArrayOf(7, 6, 4, 3, 1)))
    }
}