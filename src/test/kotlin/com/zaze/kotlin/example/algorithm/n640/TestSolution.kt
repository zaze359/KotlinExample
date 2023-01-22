package com.zaze.kotlin.example.algorithm.n640

import org.junit.Test
import kotlin.test.assertEquals


class TestSolution {
    @Test
    fun solveEquation() {
        val solution = Solution()
        assertEquals("x=2", solution.solveEquation("x+5-3+x=6+x-2"))
        assertEquals("Infinite solutions", solution.solveEquation("x=x"))
        assertEquals("x=0", solution.solveEquation("2x=x"))
    }
}