package com.zaze.kotlin.example.algorithm.n27

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import kotlin.test.assertContentEquals

class SolutionTest {

    @Test
    fun removeElement() {
        val solution = Solution()
        var nums = intArrayOf(3, 2, 2, 3)
        assertEquals(2, solution.removeElement(nums, 3))
        assertContentEquals(intArrayOf(2, 2), nums.copyOfRange(0, 2))

        nums = intArrayOf(0, 1, 2, 2, 3, 0, 4, 2)
        assertEquals(5, solution.removeElement(nums, 2))
        assertContentEquals(intArrayOf(0, 1, 4, 0, 3), nums.copyOfRange(0, 5))
        nums = intArrayOf(1)
        assertEquals(0, solution.removeElement(nums, 1))
    }
}