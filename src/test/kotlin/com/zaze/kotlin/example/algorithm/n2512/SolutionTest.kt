package com.zaze.kotlin.example.algorithm.n2512

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SolutionTest {

    @Test
    fun topStudents() {
        val solution = Solution()
        assertEquals(
            listOf(2, 1), solution.topStudents(
                positive_feedback = arrayOf("smart", "brilliant", "studious"),
                negative_feedback = arrayOf("not"),
                report = arrayOf("this student is not studious", "the student is smart"),
                student_id = intArrayOf(1, 2),
                k = 2
            )
        )
    }
}