package com.zaze.kotlin.example.algorithm.n1

import kotlin.test.Test
import kotlin.test.assertContentEquals

class TestSolution {
    @Test
    fun testTwoSum() {
        val solution = Solution()
        assertContentEquals(
            intArrayOf(0, 1),
            solution.twoSum(intArrayOf(2,7,11,15), 9)
        )

    }
}