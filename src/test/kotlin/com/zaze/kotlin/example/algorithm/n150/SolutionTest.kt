package com.zaze.kotlin.example.algorithm.n150

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun evalRPN() {
        val solution = Solution()
        assertEquals(9, solution.evalRPN(arrayOf("2", "1", "+", "3", "*")))
        assertEquals(6, solution.evalRPN(arrayOf("4", "13", "5", "/", "+")))
        assertEquals(22, solution.evalRPN(arrayOf("10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+")))
        assertEquals(1, solution.evalRPN(arrayOf("4","3","-")))
    }
}