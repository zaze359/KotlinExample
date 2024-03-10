package com.zaze.kotlin.example.algorithm.n2661

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun firstCompleteIndex() {
        val solution = Solution()
        assertEquals(
            2, solution.firstCompleteIndex(
                intArrayOf(1, 3, 4, 2), arrayOf(
                    intArrayOf(1, 4),
                    intArrayOf(2, 3),
                )
            )
        )
        assertEquals(
            3, solution.firstCompleteIndex(
                intArrayOf(2,8,7,4,1,3,5,6,9), arrayOf(
                    intArrayOf(3,2,5),
                    intArrayOf(1,4,6),
                    intArrayOf(8,7,9),
                )
            )
        )
    }
}