package com.zaze.kotlin.example.algorithm.n2736

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import kotlin.test.assertContentEquals

class SolutionTest {

    @Test
    fun maximumSumQueries() {
        val solution = Solution()
//        assertContentEquals(
//            intArrayOf(6, 10, 7),
//            solution.maximumSumQueries(
//                nums1 = intArrayOf(4, 3, 1, 2), nums2 = intArrayOf(2, 4, 9, 5), queries = arrayOf(
//                    intArrayOf(4, 1),
//                    intArrayOf(1, 3),
//                    intArrayOf(2, 5),
//                )
//            )
//        )
        assertContentEquals(
            intArrayOf(9, 9, 9),
            solution.maximumSumQueries(
                nums1 = intArrayOf(3, 2, 5), nums2 = intArrayOf(2, 3, 4), queries = arrayOf(
                    intArrayOf(4, 4),
                    intArrayOf(3, 2),
                    intArrayOf(1, 1),
                )
            )
        )
//        assertContentEquals(
//            intArrayOf(-1),
//            solution.maximumSumQueries(
//                nums1 = intArrayOf(2, 1), nums2 = intArrayOf(2, 3), queries = arrayOf(
//                    intArrayOf(3, 3),
//                )
//            )
//        )

//        assertContentEquals(
//            intArrayOf(),
//            solution.maximumSumQueries(
//                nums1 = intArrayOf(4, 3, 1, 2), nums2 = intArrayOf(2, 4, 9, 5), queries = arrayOf(
//                    intArrayOf(),
//                    intArrayOf(),
//                    intArrayOf(),
//                )
//            )
//        )
    }
}