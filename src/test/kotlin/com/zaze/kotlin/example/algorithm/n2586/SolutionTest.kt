package com.zaze.kotlin.example.algorithm.n2586

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun vowelStrings() {
        val solution = Solution()
        assertEquals(2, solution.vowelStrings(arrayOf("are", "amy", "u"), 0, 2))
        assertEquals(3, solution.vowelStrings(arrayOf("hey", "aeo", "mu", "ooo", "artro"), 1, 4))
    }
}