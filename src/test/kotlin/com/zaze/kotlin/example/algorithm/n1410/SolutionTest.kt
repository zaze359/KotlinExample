package com.zaze.kotlin.example.algorithm.n1410

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun entityParser() {
        val solution = Solution()
        assertEquals(
            "& is an HTML entity but &ambassador; is not.",
            solution.entityParser("&amp; is an HTML entity but &ambassador; is not.")
        )
        assertEquals(
            "and I quote: \"...\"",
            solution.entityParser("and I quote: &quot;...&quot;")
        )
        assertEquals(
            "Stay home! Practice on Leetcode :)",
            solution.entityParser("Stay home! Practice on Leetcode :)")
        )
    }
}