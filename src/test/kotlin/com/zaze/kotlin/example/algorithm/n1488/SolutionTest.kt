package com.zaze.kotlin.example.algorithm.n1488

import org.junit.jupiter.api.Test

import kotlin.test.assertContentEquals

class SolutionTest {

    @Test
    fun avoidFlood() {
        val solution = Solution()
        assertContentEquals(intArrayOf(-1, -1, -1, -1), solution.avoidFlood(intArrayOf(1, 2, 3, 4)))
        assertContentEquals(intArrayOf(-1, -1, 2, 1, -1, -1), solution.avoidFlood(intArrayOf(1, 2, 0, 0, 2, 1)))
        assertContentEquals(intArrayOf(), solution.avoidFlood(intArrayOf(1, 2, 0, 1, 2)))
        assertContentEquals(intArrayOf(-1, 69, 1, 1, -1), solution.avoidFlood(intArrayOf(69, 0, 0, 0, 69)))
        assertContentEquals(intArrayOf(-1, -1, 2, -1, -1, 1, -1), solution.avoidFlood(intArrayOf(1, 2, 0, 2, 3, 0, 1)))
        assertContentEquals(intArrayOf(), solution.avoidFlood(intArrayOf(0, 1, 1)))
        assertContentEquals(intArrayOf(-1, 1, -1, 2, -1, -1), solution.avoidFlood(intArrayOf(1, 0, 2, 0, 2, 1)))
        assertContentEquals(
            intArrayOf(-1, 1, -1, 2, -1, 3, -1, 2, 1, 1, -1, -1, -1),
            solution.avoidFlood(intArrayOf(1, 0, 2, 0, 3, 0, 2, 0, 0, 0, 1, 2, 3))
        )
        assertContentEquals(
            intArrayOf(),
            solution.avoidFlood(intArrayOf(2,3,0,0,3,1,0,1,0,2,2))
        )
    }
}