package com.zaze.kotlin.example.algorithm.n102

import com.zaze.kotlin.example.algorithm.base.TreeNode
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals


class SolutionTest {

    @Test
    fun levelOrder() {
        val solution = Solution()
        assertContentEquals(
            listOf(
                listOf(3),
                listOf(9, 20),
                listOf(15, 7),
            ), solution.levelOrder(TreeNode.buildTree(listOf(3, 9, 20, null, null, 15, 7)))
        )
    }
}