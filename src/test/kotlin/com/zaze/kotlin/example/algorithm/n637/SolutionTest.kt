package com.zaze.kotlin.example.algorithm.n637

import com.zaze.kotlin.example.algorithm.TreeNode
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import kotlin.test.assertContentEquals

class SolutionTest {

    @Test
    fun averageOfLevels() {
        val solution = Solution()
        assertContentEquals(
            doubleArrayOf(3.00000, 14.50000, 11.00000),
            solution.averageOfLevels(TreeNode.buildTree(listOf(3, 9, 20, null, null, 15, 7)))
        )
        assertContentEquals(
            doubleArrayOf(3.00000, 14.50000, 11.00000),
            solution.averageOfLevels(TreeNode.buildTree(listOf(3, 9, 20, 15, 7)))
        )
        assertContentEquals(
            doubleArrayOf(2147483647.0,2147483647.0),
            solution.averageOfLevels(TreeNode.buildTree(listOf(2147483647,2147483647,2147483647)))
        )
    }
}