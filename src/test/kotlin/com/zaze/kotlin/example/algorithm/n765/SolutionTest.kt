package com.zaze.kotlin.example.algorithm.n765

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun minSwapsCouples() {
        val solution = Solution()
//        assertEquals(5, solution.minSwapsCouples(intArrayOf(9, 12, 2, 10, 11, 0, 13, 6, 4, 5, 3, 8, 1, 7)))
//        assertEquals(1, solution.minSwapsCouples(intArrayOf(2, 0, 5, 4, 3, 1)))
        assertEquals(3, solution.minSwapsCouples(intArrayOf(0, 2, 4, 6, 7, 1, 3, 5)))
        assertEquals(1, solution.minSwapsCouples(intArrayOf(0, 2, 1, 3)))
        assertEquals(0, solution.minSwapsCouples(intArrayOf(3, 2, 0, 1)))
        assertEquals(2, solution.minSwapsCouples(intArrayOf(5, 4, 2, 6, 3, 1, 0, 7)))
    }
}