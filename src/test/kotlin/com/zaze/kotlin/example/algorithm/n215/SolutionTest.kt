package com.zaze.kotlin.example.algorithm.n215

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun findKthLargest() {
        val solution = Solution()
        assertEquals(5, solution.findKthLargest(intArrayOf(3, 2, 1, 5, 6, 4), 2))
        assertEquals(5, solution.findKthLargest(intArrayOf(4, 5, 6, 2, 1), 2))
        assertEquals(4, solution.findKthLargest(intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6), 4))
    }
}