package com.zaze.kotlin.example.algorithm.n2697

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun makeSmallestPalindrome() {
        val solution = Solution()
        assertEquals("efcfe", solution.makeSmallestPalindrome("egcfe"))
        assertEquals("abba", solution.makeSmallestPalindrome("abcd"))
        assertEquals("neven", solution.makeSmallestPalindrome("seven"))
    }
}