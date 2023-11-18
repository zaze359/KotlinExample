package com.zaze.kotlin.example.algorithm.n2103

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun countPoints() {
        val solution = Solution()
        assertEquals(1, solution.countPoints("B0B6G0R6R0R6G9"))
        assertEquals(1, solution.countPoints("B0R0G0R9R0B0G0"))
        assertEquals(0, solution.countPoints("G4"))
    }
}