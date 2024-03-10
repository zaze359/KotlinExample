package com.zaze.kotlin.example.algorithm.n2008

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun maxTaxiEarnings() {
        val solution = Solution()
//        assertEquals(
//            7, solution.maxTaxiEarnings(
//                5, rides = arrayOf(
//                    intArrayOf(2, 5, 4),
//                    intArrayOf(1, 5, 1),
//                )
//            )
//        )
        assertEquals(
            20, solution.maxTaxiEarnings(
                20, rides = arrayOf(
                    intArrayOf(1, 6, 1),
                    intArrayOf(3, 10, 2),
                    intArrayOf(10, 12, 3),
                    intArrayOf(11, 12, 2),
                    intArrayOf(12, 15, 2),
                    intArrayOf(13, 18, 1),
                )
            )
        )
    }
}