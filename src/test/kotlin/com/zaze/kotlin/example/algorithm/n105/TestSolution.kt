package com.zaze.kotlin.example.algorithm.n105

import kotlin.test.assertEquals
import org.junit.jupiter.api.Test


class TestSolution {

    @Test
    fun testBuildTree() {
        val solution = Solution()
        assertEquals("[-1]", "[${solution.buildTree(intArrayOf(-1), intArrayOf(-1))?.depthPrint()}]")
        assertEquals(
            "[3,9,20,null,null,15,7]",
            "[${solution.buildTree(intArrayOf(3, 9, 20, 15, 7), intArrayOf(9, 3, 15, 20, 7))?.depthPrint()}]"
        )
    }
}