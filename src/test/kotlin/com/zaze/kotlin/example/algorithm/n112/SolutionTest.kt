package com.zaze.kotlin.example.algorithm.n112

import com.zaze.kotlin.example.algorithm.base.TreeNode
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun hasPathSum() {
        val solution = Solution()
        assertEquals(
            true,
            solution.hasPathSum(TreeNode.buildTree(listOf(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1)), 22)
        )
        assertEquals(
            false,
            solution.hasPathSum(TreeNode.buildTree(listOf(1,2,3)), 5)
        )
    }
}