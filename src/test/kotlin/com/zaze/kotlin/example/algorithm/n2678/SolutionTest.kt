package com.zaze.kotlin.example.algorithm.n2678

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun countSeniors() {
        val solution = Solution()
        assertEquals(2, solution.countSeniors(arrayOf("7868190130M7522", "5303914400F9211", "9273338290F4010")))
        assertEquals(0, solution.countSeniors(arrayOf("1313579440F2036","2921522980M5644")))
    }
}