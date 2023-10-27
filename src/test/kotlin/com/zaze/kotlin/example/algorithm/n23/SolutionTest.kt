package com.zaze.kotlin.example.algorithm.n23

import com.zaze.kotlin.example.algorithm.ListNode
import org.junit.jupiter.api.Test

import kotlin.test.assertContentEquals

class SolutionTest {

    @Test
    fun mergeKLists() {
        val solution = Solution()
        assertContentEquals(
            listOf(1, 1, 2, 3, 4, 4, 5, 6),
            solution.mergeKLists(
                arrayOf(
                    ListNode.buildNode(intArrayOf(1, 4, 5)),
                    ListNode.buildNode(intArrayOf(1, 3, 4)),
                    ListNode.buildNode(intArrayOf(2, 6))
                )
            )?.toList()
        )
        assertContentEquals(
            listOf(),
            solution.mergeKLists(
                arrayOf()
            )?.toList() ?: emptyList()
        )

        assertContentEquals(
            listOf(),
            solution.mergeKLists(
                arrayOf(ListNode.buildNode(intArrayOf()))
            )?.toList() ?: emptyList()
        )
        assertContentEquals(
            listOf(1),
            solution.mergeKLists(
                arrayOf(ListNode.buildNode(intArrayOf(1)))
            )?.toList() ?: emptyList()
        )
        assertContentEquals(
            listOf(),
            solution.mergeKLists(
                arrayOf(ListNode.buildNode(intArrayOf()), ListNode.buildNode(intArrayOf())),
            )?.toList() ?: emptyList()
        )
    }
}