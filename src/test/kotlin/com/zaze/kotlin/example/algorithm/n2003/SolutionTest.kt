package com.zaze.kotlin.example.algorithm.n2003

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import kotlin.test.assertContentEquals

class SolutionTest {

    @Test
    fun smallestMissingValueSubtree() {
        val solution = Solution()
        assertContentEquals(
            intArrayOf(11, 9, 1, 7, 2, 2, 1, 2, 1, 1),
            solution.smallestMissingValueSubtree(

                intArrayOf(-1, 0, 4, 1, 3, 4, 3, 5, 1, 7),
                intArrayOf(9, 8, 5, 4, 10, 6, 2, 1, 7, 3)
            )
        )
        assertContentEquals(
            intArrayOf(6, 1, 2, 5, 1),
            solution.smallestMissingValueSubtree(intArrayOf(-1, 3, 3, 0, 3), intArrayOf(5, 3, 1, 4, 2))
        )
        assertContentEquals(
            intArrayOf(6, 1, 2, 1, 1),
            solution.smallestMissingValueSubtree(intArrayOf(-1, 0, 0, 2, 1), intArrayOf(3, 2, 1, 4, 5))
        )
        assertContentEquals(
            intArrayOf(5, 1, 1, 1),
            solution.smallestMissingValueSubtree(intArrayOf(-1, 0, 0, 2), intArrayOf(1, 2, 3, 4))
        )
        assertContentEquals(
            intArrayOf(7, 1, 1, 4, 2, 1),
            solution.smallestMissingValueSubtree(intArrayOf(-1, 0, 1, 0, 3, 3), intArrayOf(5, 4, 6, 2, 1, 3))
        )
    }
}