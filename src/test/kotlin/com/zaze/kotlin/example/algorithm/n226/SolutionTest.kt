package com.zaze.kotlin.example.algorithm.n226

import com.zaze.kotlin.example.algorithm.base.TreeNode
import org.junit.jupiter.api.Test

import kotlin.test.assertEquals

class SolutionTest {

    @Test
    fun invertTree() {
        val solution = Solution()
        assertEquals(
            "4,7,2,9,6,3,1",
            solution.invertTree(TreeNode.buildTree(listOf(4, 2, 7, 1, 3, 6, 9)))?.levelPrint()
        )
        assertEquals(
            "2,3,1",
            solution.invertTree(TreeNode.buildTree(listOf(2,1,3)))?.levelPrint()
        )
    }
}