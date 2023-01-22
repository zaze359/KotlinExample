package com.zaze.kotlin.example.algorithm.n819

import kotlin.test.Test
import kotlin.test.assertEquals

class TestSolution {
    @Test
    fun testMostCommonWord() {
        val solution = Solution()
//        assertEquals(
//            "ball",
//            solution.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", arrayOf("hit"))
//        )
//        assertEquals("ball", solution.mostCommonWord("Bob. hIt, baLl", arrayOf("bob", "hit")))
        assertEquals(
            "ball",
            solution.mostCommonWord("..Bob hit a ball, the hit BALL flew far after it was hit.", arrayOf("hit"))
        )

    }
}