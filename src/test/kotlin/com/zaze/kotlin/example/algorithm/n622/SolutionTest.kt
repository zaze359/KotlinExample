package com.zaze.kotlin.example.algorithm.n622

import com.zaze.kotlin.example.algorithm.TreeNode
import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class SolutionTest {
    @Test
    fun widthOfBinaryTree() {
        val solution = Solution()
        assertEquals(4, solution.widthOfBinaryTree(TreeNode.buildTree(listOf(1, 3, 2, 5, 3, null, 9))))
        assertEquals(7, solution.widthOfBinaryTree(TreeNode.buildTree(listOf(1, 3, 2, 5, null, null, 9, 6, null, 7))))
    }
}