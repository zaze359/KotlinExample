package com.zaze.kotlin.example.algorithm.n2760

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun longestAlternatingSubarray() {
        val solution = Solution()
//        assertEquals(1, solution.longestAlternatingSubarray(intArrayOf(1, 2), 2))
//        assertEquals(3, solution.longestAlternatingSubarray(intArrayOf(3, 2, 5, 4), 5))
        assertEquals(2, solution.longestAlternatingSubarray(intArrayOf(2, 3, 3, 10), 18))
    }
}