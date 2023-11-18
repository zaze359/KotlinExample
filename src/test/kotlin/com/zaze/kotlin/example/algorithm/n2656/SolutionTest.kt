package com.zaze.kotlin.example.algorithm.n2656

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun maximizeSum() {
        val solution = Solution()
        assertEquals(18, solution.maximizeSum(intArrayOf(1, 2, 3, 4, 5), 3))
        assertEquals(11, solution.maximizeSum(intArrayOf(5, 5, 5), 2))
    }
}