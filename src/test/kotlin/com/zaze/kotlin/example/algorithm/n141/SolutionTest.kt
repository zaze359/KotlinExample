package com.zaze.kotlin.example.algorithm.n141

import com.zaze.kotlin.example.algorithm.base.ListNode
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun hasCycle() {
        val solution = Solution()
        assertEquals(true, solution.hasCycle(ListNode.buildNode(intArrayOf(3, 2, 0, -4), 1)))
        assertEquals(true, solution.hasCycle(ListNode.buildNode(intArrayOf(1, 2), 0)))
    }
}