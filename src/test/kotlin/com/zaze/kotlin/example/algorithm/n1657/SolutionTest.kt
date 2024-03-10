package com.zaze.kotlin.example.algorithm.n1657

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun closeStrings() {
        val solution = Solution()
        assertTrue(solution.closeStrings("abc", "bca"))
        assertFalse(solution.closeStrings("a", "aa"))
        assertTrue(solution.closeStrings("cabbba", "abbccc"))
    }
}