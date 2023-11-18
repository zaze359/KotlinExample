package com.zaze.kotlin.example.algorithm.n21

import com.zaze.kotlin.example.algorithm.base.ListNode
import org.junit.jupiter.api.Test

import kotlin.test.assertContentEquals

class SolutionTest {

    @Test
    fun mergeTwoLists() {
        assertContentEquals(
            listOf(1, 1, 2, 3, 4, 4),
            Solution().mergeTwoLists(ListNode.buildNode(intArrayOf(1, 2, 4)), ListNode.buildNode(intArrayOf(1, 3, 4)))
                ?.toList()
        )
        assertContentEquals(
            emptyList(),
            Solution().mergeTwoLists(ListNode.buildNode(intArrayOf()), ListNode.buildNode(intArrayOf()))
                ?.toList() ?: emptyList()
        )
        assertContentEquals(
            listOf(0),
            Solution().mergeTwoLists(ListNode.buildNode(intArrayOf()), ListNode.buildNode(intArrayOf(0)))
                ?.toList()
        )
    }
}