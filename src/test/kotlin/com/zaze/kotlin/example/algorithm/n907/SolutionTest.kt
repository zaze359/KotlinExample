package com.zaze.kotlin.example.algorithm.n907

import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class SolutionTest {
    @Test
    fun sumSubarrayMins() {
        val solution = Solution()
        assertEquals(17, solution.sumSubarrayMins(intArrayOf(3, 1, 2, 4)))
        assertEquals(444, solution.sumSubarrayMins(intArrayOf(11, 81, 94, 43, 3)))
    }
}