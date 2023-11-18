package com.zaze.kotlin.example.algorithm.n104

import com.zaze.kotlin.example.algorithm.base.TreeNode
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun maxDepth() {
        val solution = Solution()
        assertEquals(3, solution.maxDepth(TreeNode.buildTree(listOf(3, 9, 20, null, null, 15, 7))))
        assertEquals(2, solution.maxDepth(TreeNode.buildTree(listOf(1,null,2))))
    }
}