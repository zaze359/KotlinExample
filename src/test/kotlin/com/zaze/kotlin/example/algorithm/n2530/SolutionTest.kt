package com.zaze.kotlin.example.algorithm.n2530

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun maxKelements() {
        val solution = Solution()
        assertEquals(50, solution.maxKelements(intArrayOf(10, 10, 10, 10, 10), 5))
        assertEquals(17, solution.maxKelements(intArrayOf(1, 10, 3, 3, 3), 3))
    }
}