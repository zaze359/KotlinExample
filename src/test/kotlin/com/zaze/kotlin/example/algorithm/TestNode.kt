package com.zaze.kotlin.example.algorithm

import com.zaze.kotlin.example.algorithm.base.TreeNode
import org.junit.jupiter.api.Test

class TestNode {
    @Test
    fun buildTree() {
//        assertEquals("[]", TreeNode.buildTree(listOf(1, 2, 2, 3, 3, null, null, 4, 4))?.preorder())
//        val result = TreeNode.buildTree(listOf(3, 9, 20, null, null, 15, 7))
        val result = TreeNode.buildTree(listOf(1, 3, 2, 5, null, null, 9, 6, null, 7))
        println("result.levelPrint: ${result?.levelPrint()}")
        println("result.levelOrder: ${result?.levelOrder()}")
    }
}