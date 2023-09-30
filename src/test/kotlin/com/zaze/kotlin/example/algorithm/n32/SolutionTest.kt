package com.zaze.kotlin.example.algorithm.n32

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun longestValidParentheses() {
        val solution = Solution()
        assertEquals(2, solution.longestValidParentheses("())"))
        assertEquals(2, solution.longestValidParentheses("(()"))
        assertEquals(4, solution.longestValidParentheses(")()())"))
        assertEquals(0, solution.longestValidParentheses(""))
        assertEquals(6, solution.longestValidParentheses("()(())"))
        assertEquals(2, solution.longestValidParentheses("()(()"))
        assertEquals(2, solution.longestValidParentheses("(()(((()"))
        assertEquals(4, solution.longestValidParentheses("(()()"))
        assertEquals(22, solution.longestValidParentheses(")(((((()())()()))()(()))("))
    }
}