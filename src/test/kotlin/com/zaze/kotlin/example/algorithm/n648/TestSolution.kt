package com.zaze.kotlin.example.algorithm.n648

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


class TestSolution {

    @Test
    fun testReplaceWords() {
        val solution = Solution()
        assertEquals("the cat was rat by the bat", solution.replaceWords(listOf("cat", "bat", "rat"), "the cattle was rattled by the battery"))
        assertEquals("a a b c", solution.replaceWords(listOf("a", "b", "c"), "aadsfasf absbs bbab cadsfafs"))
    }
}