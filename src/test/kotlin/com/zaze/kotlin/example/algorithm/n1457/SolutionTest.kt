package com.zaze.kotlin.example.algorithm.n1457

import com.zaze.kotlin.example.algorithm.base.TreeNode
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun pseudoPalindromicPaths() {
        val solution = Solution()
        assertEquals(2, solution.pseudoPalindromicPaths(TreeNode.buildTree(listOf(2, 3, 1, 3, 1, null, 1))))
        assertEquals(
            1,
            solution.pseudoPalindromicPaths(TreeNode.buildTree(listOf(2, 1, 1, 1, 3, null, null, null, null, null, 1)))
        )
    }
}