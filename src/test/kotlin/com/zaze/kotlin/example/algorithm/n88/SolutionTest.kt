package com.zaze.kotlin.example.algorithm.n88

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import kotlin.test.assertContentEquals

class SolutionTest {

    @Test
    fun merge() {
        val solution = Solution()
        var nums = intArrayOf(1, 2, 3, 0, 0, 0)
        solution.merge(nums, 3, intArrayOf(2, 5, 6), 3)
        assertContentEquals(intArrayOf(1, 2, 2, 3, 5, 6), nums)

        nums = intArrayOf(1)
        solution.merge(nums, 1, intArrayOf(), 0)
        assertContentEquals(intArrayOf(1), nums)
        nums = intArrayOf(0, 0)

        solution.merge(nums, 0, intArrayOf(1, 2), 2)
        assertContentEquals(intArrayOf(1, 2), nums)
    }
}