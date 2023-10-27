package com.zaze.kotlin.example.algorithm.n2562

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun findTheArrayConcVal() {
        val solution = Solution()
        assertEquals(596, solution.findTheArrayConcVal(intArrayOf(7, 52, 2, 4)))
        assertEquals(673, solution.findTheArrayConcVal(intArrayOf(5, 14, 13, 8, 12)))
    }
}