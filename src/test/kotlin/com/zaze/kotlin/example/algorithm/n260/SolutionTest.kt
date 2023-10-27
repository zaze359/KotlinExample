package com.zaze.kotlin.example.algorithm.n260

import org.junit.jupiter.api.Test
import java.lang.StringBuilder

import kotlin.test.assertContentEquals

class SolutionTest {

    @Test
    fun singleNumber() {
        val solution = Solution()
        assertContentEquals(listOf(3, 5), solution.singleNumber(intArrayOf(1, 2, 1, 3, 2, 5)).sorted())
        assertContentEquals(listOf(-1, 0), solution.singleNumber(intArrayOf(-1, 0)).sorted())
        assertContentEquals(listOf(0, 1), solution.singleNumber(intArrayOf(0, 1)).sorted())
        assertContentEquals(listOf(Int.MIN_VALUE, 0), solution.singleNumber(intArrayOf(0, Int.MIN_VALUE)).sorted())
    }
}