package com.zaze.kotlin.example.algorithm.n1380

import com.zaze.kotlin.example.algorithm.base.TreeNode
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun bstToGst() {
        val solution = Solution()
        assertEquals(
            "30,36,21,36,35,26,15,null,null,null,33,null,null,null,8", solution.bstToGst(
                TreeNode.buildTree(
                    listOf(4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8)
                )
            )?.levelPrint() ?: ""
        )
    }
}