package com.zaze.kotlin.example.algorithm.n2525

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun categorizeBox() {
        val solution = Solution()
        assertEquals("Heavy", solution.categorizeBox(length = 1000, width = 35, height = 700, mass = 100))
        assertEquals("Neither", solution.categorizeBox(length = 200, width = 50, height = 800, mass = 50))
        assertEquals("Heavy", solution.categorizeBox(length = 1569, width = 714, height = 170, mass = 408))
        assertEquals("Both", solution.categorizeBox(length = 2909, width = 3968, height = 3272, mass = 727))
    }
}