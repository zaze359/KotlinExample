package com.zaze.kotlin.example.algorithm.n103

import com.zaze.kotlin.example.algorithm.base.TreeNode
import org.junit.jupiter.api.Test

import kotlin.test.assertContentEquals

class SolutionTest {

    @Test
    fun zigzagLevelOrder() {
        val solution = Solution()
        assertContentEquals(
            listOf(
                listOf(3),
                listOf(20, 9),
                listOf(15, 7),
            ),
            solution.zigzagLevelOrder(TreeNode.buildTree(listOf(3, 9, 20, null, null, 15, 7)))
        )
        assertContentEquals(
            listOf(
                listOf(1),
            ),
            solution.zigzagLevelOrder(TreeNode.buildTree(listOf(1)))
        )
        assertContentEquals(
            listOf(),
            solution.zigzagLevelOrder(TreeNode.buildTree(listOf()))
        )
        assertContentEquals(
            listOf(
                listOf(1),
                listOf(3, 2),
                listOf(4, 5),
            ),
            solution.zigzagLevelOrder(TreeNode.buildTree(listOf(1, 2, 3, 4, null, null, 5)))
        )
    }
}