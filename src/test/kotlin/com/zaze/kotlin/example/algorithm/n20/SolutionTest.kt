package com.zaze.kotlin.example.algorithm.n20

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun isValid() {
        val solution = Solution()
//        assertEquals(true, solution.isValid("()"))
//        assertEquals(true, solution.isValid("()[]{}"))
        assertEquals(false, solution.isValid("(){}}{"))
    }
}