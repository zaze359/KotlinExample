package com.zaze.kotlin.example.algorithm.n2698

import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class SolutionTest {
    @Test
    fun punishmentNumber() {
        val solution = Solution()
        assertEquals(182, solution.punishmentNumber(10))
        assertEquals(1478, solution.punishmentNumber(37))
    }
}