package com.zaze.kotlin.example.algorithm.n2558

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun pickGifts() {
        val solution = Solution()
        assertEquals(29, solution.pickGifts(intArrayOf(25, 64, 9, 4, 100), 4))
        assertEquals(4, solution.pickGifts(intArrayOf(1, 1, 1, 1), 4))
    }
}