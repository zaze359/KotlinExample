package com.zaze.kotlin.example.algorithm.n152

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun maxProduct() {
        val solution = Solution()
        assertEquals(6, solution.maxProduct(intArrayOf(2, 3, -2, 4)))
        assertEquals(48, solution.maxProduct(intArrayOf(-2, -3, -2, -4)))
        assertEquals(0, solution.maxProduct(intArrayOf(-2,0,-1)))
        assertEquals(0, solution.maxProduct(intArrayOf(0,-1)))
    }
}