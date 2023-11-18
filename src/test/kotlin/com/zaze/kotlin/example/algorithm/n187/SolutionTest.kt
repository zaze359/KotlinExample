package com.zaze.kotlin.example.algorithm.n187

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import kotlin.test.assertContentEquals

class SolutionTest {

    @Test
    fun findRepeatedDnaSequences() {
        val solution = Solution()
        assertContentEquals(
            listOf("AAAAACCCCC", "CCCCCAAAAA"),
            solution.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT")
        )
        assertContentEquals(
            listOf("AAAAAAAAAA"),
            solution.findRepeatedDnaSequences("AAAAAAAAAAAAA")
        )
    }
}