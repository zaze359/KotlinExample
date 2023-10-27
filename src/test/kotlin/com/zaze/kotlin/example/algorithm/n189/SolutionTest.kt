package com.zaze.kotlin.example.algorithm.n189

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import kotlin.test.assertContentEquals

class SolutionTest {

    @Test
    fun rotate() {
        val solution = Solution()
        var nums = intArrayOf(1, 2, 3, 4, 5, 6, 7)
        //
        //
        solution.rotate(nums, 3)
        assertContentEquals(intArrayOf(5, 6, 7, 1, 2, 3, 4), nums)
        nums = intArrayOf(-1, -100, 3, 99)
        solution.rotate(nums, 2)
        assertContentEquals(intArrayOf(3, 99, -1, -100), nums)
        nums = intArrayOf(1, 2, 3, 4, 5, 6)
        solution.rotate(nums, 2)
        assertContentEquals(intArrayOf(5, 6, 1, 2, 3, 4), nums)
        nums = intArrayOf(1, 2, 3, 4, 5, 6)
        solution.rotate(nums, 3)
        assertContentEquals(intArrayOf(4, 5, 6, 1, 2, 3), nums)
        nums = intArrayOf(1, 2, 3, 4, 5, 6)
        solution.rotate(nums, 4)
        assertContentEquals(intArrayOf(3, 4, 5, 6, 1, 2), nums)
        nums = intArrayOf(-1, -100, 3, 99)
        solution.rotate(nums, 3)
        assertContentEquals(intArrayOf(-100, 3, 99, -1), nums)
    }
}