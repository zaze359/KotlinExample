package com.zaze.kotlin.example.algorithm.n98

import com.zaze.kotlin.example.algorithm.base.TreeNode
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun isValidBST() {
        assertEquals(true, Solution().isValidBST(TreeNode.buildTree(listOf(2, 1, 3))))
        assertEquals(false, Solution().isValidBST(TreeNode.buildTree(listOf(5, 1, 4, null, null, 3, 6))))
        assertEquals(false, Solution().isValidBST(TreeNode.buildTree(listOf(5, 1, 6, null, null, 3, 7))))
        assertEquals(true, Solution().isValidBST(TreeNode.buildTree(listOf(2147483647))))
    }
}