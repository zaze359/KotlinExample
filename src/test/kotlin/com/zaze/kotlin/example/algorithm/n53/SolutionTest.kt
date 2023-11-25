package com.zaze.kotlin.example.algorithm.n53

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun maxSubArray() {
        val solution =Solution()
        assertEquals(6, solution.maxSubArray(intArrayOf(-2,1,-3,4,-1,2,1,-5,4)))
        assertEquals(1, solution.maxSubArray(intArrayOf(1)))
        assertEquals(23, solution.maxSubArray(intArrayOf(5,4,-1,7,8)))
        assertEquals(-1, solution.maxSubArray(intArrayOf(-2, -1)))
    }
}