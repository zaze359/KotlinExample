package com.zaze.kotlin.example.algorithm.n10

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun isMatch() {
        val solution = Solution()
        assertEquals(true, solution.isMatch("aa", "a*"))
        assertEquals(true, solution.isMatch("ab", ".*"))
    }
}