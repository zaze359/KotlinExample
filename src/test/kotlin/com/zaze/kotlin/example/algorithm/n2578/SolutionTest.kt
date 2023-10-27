package com.zaze.kotlin.example.algorithm.n2578

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun splitNum() {
        val solution = Solution()
        assertEquals(59, solution.splitNum(4325))
        assertEquals(75, solution.splitNum(687))
    }
}