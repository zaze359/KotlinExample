package com.zaze.kotlin.example.algorithm.n592

import org.junit.Test
import kotlin.test.assertEquals

class TestSolution {

    @Test
    fun testFractionAddition() {
        val solution = Solution()
        assertEquals("0/1", solution.fractionAddition("-1/2+1/2"))
        assertEquals("1/3", solution.fractionAddition("-1/2+1/2+1/3"))
        assertEquals("-1/6", solution.fractionAddition("1/3-1/2"))
    }

}