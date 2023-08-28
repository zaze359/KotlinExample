package com.zaze.kotlin.example.algorithm.n977

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import kotlin.test.assertContentEquals

class SolutionTest {

    @Test
    fun sortedSquares() {
        val solution = Solution()
        assertContentEquals(intArrayOf(0, 1, 9, 16, 100), solution.sortedSquares(intArrayOf(-4, -1, 0, 3, 10)))
        assertContentEquals(intArrayOf(4, 9, 9, 49, 121), solution.sortedSquares(intArrayOf(-7, -3, 2, 3, 11)))
    }
}