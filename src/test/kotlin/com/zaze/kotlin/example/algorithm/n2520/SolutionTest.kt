package com.zaze.kotlin.example.algorithm.n2520

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun countDigits() {
        val solution = Solution()
        assertEquals(1, solution.countDigits(7))
        assertEquals(2, solution.countDigits(121))
        assertEquals(4, solution.countDigits(1248))
    }
}