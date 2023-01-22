package com.zaze.kotlin.example.algorithm.n165

import kotlin.test.Test
import kotlin.test.assertEquals

class TestSolution {
    @Test
    fun testCompareVersion() {
        val solution = Solution()
        assertEquals(0, solution.compareVersion("1.01", "1.001"))
        assertEquals(0, solution.compareVersion("1.0", "1.0.0"))
        assertEquals(-1, solution.compareVersion("0.1", "1.1"))
        assertEquals(1, solution.compareVersion("1.1", "0.2"))
        assertEquals(1, solution.compareVersion("1.0.1", "1"))
    }
}