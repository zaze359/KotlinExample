package com.zaze.kotlin.example.algorithm.o24

import com.zaze.kotlin.example.algorithm.ListNode
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import kotlin.test.assertContentEquals

class SolutionTest {

    @Test
    fun reverseList() {
        val solution = Solution()
        assertContentEquals(
            listOf(5, 4, 3, 2, 1),
            solution.reverseList(ListNode.buildNode(intArrayOf(1, 2, 3, 4, 5)))?.toList()
        )
    }
}