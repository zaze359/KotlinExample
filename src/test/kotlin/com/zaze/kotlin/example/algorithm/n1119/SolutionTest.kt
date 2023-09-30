package com.zaze.kotlin.example.algorithm.n1119

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun removeVowels() {
        val solution = Solution()
        assertEquals("112234567889999k9999k23kk", solution.removeVowels("ae1122io3ua4e5i6o7u8a89e9i9o9uk9a9e9i9ouaaekai23kkou"))
        assertEquals("", solution.removeVowels("aeiou"))
        assertEquals("111222333444555", solution.removeVowels("a111e222i333o444u555"))
    }
}