package com.zaze.kotlin.example.algorithm.n2652

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun sumOfMultiples() {
        val solution = Solution()

        assertEquals(21, solution.sumOfMultiples(7))
        assertEquals(40, solution.sumOfMultiples(10))

    }
}