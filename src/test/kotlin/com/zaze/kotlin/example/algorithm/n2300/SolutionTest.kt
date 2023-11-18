package com.zaze.kotlin.example.algorithm.n2300

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import kotlin.test.assertContentEquals

class SolutionTest {

    @Test
    fun successfulPairs() {
        val solution = Solution()
//        assertContentEquals(
//            intArrayOf(4, 0, 3),
//            solution.successfulPairs(spells = intArrayOf(5, 1, 3), potions = intArrayOf(1, 2, 3, 4, 5), success = 7)
//        )
//        assertContentEquals(
//            intArrayOf(2, 0, 2),
//            solution.successfulPairs(spells = intArrayOf(3, 1, 2), potions = intArrayOf(8, 5, 8), success = 16)
//        )
        assertContentEquals(
            intArrayOf(3, 2, 0),
            solution.successfulPairs(
                spells = intArrayOf(56029, 39759, 11542),
                potions = intArrayOf(68460, 91879, 36597),
                success = 1651505078
            )
        )
    }
}