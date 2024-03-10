package com.zaze.kotlin.example.algorithm.n828

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun uniqueLetterString() {
        val solution = Solution()
        assertEquals(10, solution.uniqueLetterString("ABC"))
        assertEquals(8, solution.uniqueLetterString("ABA"))
        assertEquals(92, solution.uniqueLetterString("LEETCODE"))
    }
}