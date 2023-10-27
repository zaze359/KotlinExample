package com.zaze.kotlin.example.algorithm.n322

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun coinChange() {
        val solution = Solution()
        assertEquals(3, solution.coinChange(intArrayOf(1, 2, 5), amount = 11))
        assertEquals(20, solution.coinChange(intArrayOf(186, 419, 83, 408), amount = 6249))
        assertEquals(2, solution.coinChange(intArrayOf(1,2147483647), amount = 2))

    }
}