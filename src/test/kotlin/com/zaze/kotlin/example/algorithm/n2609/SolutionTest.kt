package com.zaze.kotlin.example.algorithm.n2609

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun findTheLongestBalancedSubstring() {
        val solution = Solution()
        assertEquals(6, solution.findTheLongestBalancedSubstring("01000111"))
        assertEquals(4, solution.findTheLongestBalancedSubstring("00111"))
    }
}