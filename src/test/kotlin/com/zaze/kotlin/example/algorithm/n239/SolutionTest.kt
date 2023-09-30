package com.zaze.kotlin.example.algorithm.n239

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import kotlin.test.assertContentEquals

class SolutionTest {

    @Test
    fun maxSlidingWindow() {
        val solution = Solution()
        assertContentEquals(
            intArrayOf(3, 3, 5, 5, 6, 7),
            solution.maxSlidingWindow(intArrayOf(1, 3, -1, -3, 5, 3, 6, 7), 3)
        )
    }
}