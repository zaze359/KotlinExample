package com.zaze.kotlin.example.algorithm.n2127

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun maximumInvitations() {

        val solution = Solution()
        assertEquals(3, solution.maximumInvitations(intArrayOf(2, 2, 1, 2)))
        assertEquals(3, solution.maximumInvitations(intArrayOf(1, 2, 0)))
    }
}