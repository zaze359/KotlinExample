package com.zaze.kotlin.example.algorithm.n136

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun singleNumber() {
        val solution = Solution()
        assertEquals(1, solution.singleNumber(intArrayOf(2,2,1)))
        assertEquals(4, solution.singleNumber(intArrayOf(4,1,2,1,2)))
        assertEquals(1, solution.singleNumber(intArrayOf(1)))
    }
}