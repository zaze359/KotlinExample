package com.zaze.kotlin.example.algorithm.n318

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun maxProduct() {
        val solution = Solution()
        assertEquals(16, solution.maxProduct(arrayOf("abcw", "baz", "foo", "bar", "xtfn", "abcdef")))
        assertEquals(4, solution.maxProduct(arrayOf("a", "ab", "abc", "d", "cd", "bcd", "abcd")))
        assertEquals(0, solution.maxProduct(arrayOf("a", "aa", "aaa", "aaaa")))
    }
}