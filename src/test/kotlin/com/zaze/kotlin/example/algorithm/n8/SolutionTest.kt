package com.zaze.kotlin.example.algorithm.n8

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun myAtoi() {
        val solution = Solution()
        assertEquals(42, solution.myAtoi("42"))
        assertEquals(-42, solution.myAtoi("     -42"))
        assertEquals(-2147483648, solution.myAtoi("-91283472332"))
        assertEquals(2147483647, solution.myAtoi("91283472332"))
        assertEquals(0, solution.myAtoi("words and 987"))
    }
}