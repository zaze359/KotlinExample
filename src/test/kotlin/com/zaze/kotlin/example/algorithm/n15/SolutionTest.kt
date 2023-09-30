package com.zaze.kotlin.example.algorithm.n15

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import kotlin.test.assertContentEquals

class SolutionTest {

    @Test
    fun threeSum() {
        val solution = Solution()
        assertContentEquals(listOf(listOf(-1,-1,2), listOf(-1,0,1)), solution.threeSum(intArrayOf(-1,0,1,2,-1,-4)))
        assertContentEquals(listOf(listOf(0, 0, 0)), solution.threeSum(intArrayOf(0, 0, 0)))
    }
}