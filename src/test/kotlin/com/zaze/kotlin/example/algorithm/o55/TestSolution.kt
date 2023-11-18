package com.zaze.kotlin.example.algorithm.o55

import com.zaze.kotlin.example.algorithm.base.TreeNode
import kotlin.test.assertEquals
import org.junit.jupiter.api.Test


class TestSolution {

    @Test
    fun isBalanced() {
        val solution = Solution()
        assertEquals(true, solution.isBalanced(TreeNode.buildTree(listOf(3,9,20,null,null,15,7))))
        assertEquals(false, solution.isBalanced(TreeNode.buildTree(listOf(1,2,2,3,3,null,null,4,4))))
    }
}