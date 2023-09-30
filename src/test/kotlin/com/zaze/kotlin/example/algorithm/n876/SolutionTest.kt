package com.zaze.kotlin.example.algorithm.n876

import com.zaze.kotlin.example.algorithm.ListNode
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import kotlin.test.assertContentEquals

class SolutionTest {

    @Test
    fun middleNode() {
        val solution = Solution()
        assertContentEquals(
            listOf(3, 4, 5),
            solution.middleNode(ListNode.buildNode(intArrayOf(1, 2, 3, 4, 5)))?.toList()
        )
        assertContentEquals(
            listOf(4, 5, 6),
            solution.middleNode(ListNode.buildNode(intArrayOf(1, 2, 3, 4, 5, 6)))?.toList()
        )
    }
}