package com.zaze.kotlin.example.algorithm.n696

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import kotlin.test.assertContentEquals

class SolutionTest {

    @Test
    fun maxSumOfThreeSubarrays() {
        val solution = Solution()
        assertContentEquals(
            intArrayOf(1, 4, 7),
            solution.maxSumOfThreeSubarrays(intArrayOf(7, 13, 20, 19, 19, 2, 10, 1, 1, 19), 3)
        )
        assertContentEquals(intArrayOf(0, 3, 5), solution.maxSumOfThreeSubarrays(intArrayOf(1, 2, 1, 2, 6, 7, 5, 1), 2))
        assertContentEquals(
            intArrayOf(0, 2, 4),
            solution.maxSumOfThreeSubarrays(intArrayOf(1, 2, 1, 2, 1, 2, 1, 2, 1), 2)
        )
        assertContentEquals(intArrayOf(0, 1, 2), solution.maxSumOfThreeSubarrays(intArrayOf(4, 3, 2, 1), 1))
    }
}