package com.zaze.kotlin.example.algorithm.n2048

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun nextBeautifulNumber() {
        val solution = Solution()
        assertEquals(22, solution.nextBeautifulNumber(1))
        assertEquals(1333, solution.nextBeautifulNumber(1000))
        assertEquals(3133, solution.nextBeautifulNumber(3000))
    }
}