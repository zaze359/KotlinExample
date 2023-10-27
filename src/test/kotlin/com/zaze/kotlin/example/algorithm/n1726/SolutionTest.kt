package com.zaze.kotlin.example.algorithm.n1726

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun tupleSameProduct() {
        val solution = Solution()
        assertEquals(8, solution.tupleSameProduct(intArrayOf(2, 3, 4, 6)))
        assertEquals(16, solution.tupleSameProduct(intArrayOf(1, 2, 4, 5, 10)))
    }
}