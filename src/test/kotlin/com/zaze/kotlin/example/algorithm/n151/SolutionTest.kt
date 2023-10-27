package com.zaze.kotlin.example.algorithm.n151

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun reverseWords() {
        val solution  = Solution()
        assertEquals( "blue is sky the", solution.reverseWords( "the sky is blue"))
        assertEquals( "world hello", solution.reverseWords( "  hello world  "))
    }
}