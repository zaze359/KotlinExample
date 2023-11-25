package com.zaze.kotlin.example.algorithm.n2342

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun maximumSum() {
        val solution = Solution()
        assertEquals(54, solution.maximumSum(intArrayOf(18, 43, 36, 13, 7)))
        assertEquals(-1, solution.maximumSum(intArrayOf(10,12,19,14)))
    }
}