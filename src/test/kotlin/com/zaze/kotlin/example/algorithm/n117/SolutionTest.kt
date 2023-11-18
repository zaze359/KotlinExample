package com.zaze.kotlin.example.algorithm.n117

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun connect() {
        val solution = Solution()
        assertEquals("1,#,2,3,#,4,5,7,#", solution.connect(Node.buildTree(listOf(1, 2, 3, 4, 5, null, 7)))?.printNext())
        assertEquals("", solution.connect(Node.buildTree(listOf()))?.printNext() ?: "")
    }
}