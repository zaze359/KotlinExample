package com.zaze.kotlin.example.algorithm.n199

import com.zaze.kotlin.example.algorithm.TreeNode
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun rightSideView() {
        val solution = Solution()
        assertEquals(listOf(1, 3, 4), solution.rightSideView(TreeNode.buildTree(listOf(1, 2, 3, null, 5, null, 4))))
        assertEquals(listOf(1, 3), solution.rightSideView(TreeNode.buildTree(listOf(1, null, 3))))
    }
}