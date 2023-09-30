package com.zaze.kotlin.example.algorithm.n169

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun majorityElement() {
        val solution = Solution()
        assertEquals(3, solution.majorityElement(intArrayOf(3, 2, 3)))
        assertEquals(2, solution.majorityElement(intArrayOf(2, 2, 1, 1, 1, 2, 2)))
    }
}