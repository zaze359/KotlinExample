package com.zaze.kotlin.example.algorithm.n344

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import kotlin.test.assertContains
import kotlin.test.assertContentEquals

class SolutionTest {

    @Test
    fun reverseString() {
        val solution = Solution()
        var charArray = charArrayOf('h', 'e', 'l', 'l', 'o')
        solution.reverseString(charArray)
        assertContentEquals(charArrayOf('o', 'l', 'l', 'e', 'h'), charArray)
    }
}