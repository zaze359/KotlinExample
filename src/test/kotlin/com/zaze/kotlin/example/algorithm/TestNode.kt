package com.zaze.kotlin.example.algorithm

import org.junit.jupiter.api.Test

class TestNode {
    @Test
    fun buildTree() {
//        assertEquals("[]", TreeNode.buildTree(listOf(1, 2, 2, 3, 3, null, null, 4, 4))?.preorder())

        val result = TreeNode.buildTree(listOf(3, 9, 20, null, null, 15, 7))
        println("result.depthPrint: ${result?.depthPrint()}")
        println("result.levelOrder: ${result?.levelOrder()}")

    }
}