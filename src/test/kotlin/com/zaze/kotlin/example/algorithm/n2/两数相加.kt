package com.zaze.kotlin.example.algorithm.n2

import com.zaze.kotlin.example.algorithm.ListNode
import kotlin.test.Test
import kotlin.test.assertContentEquals

class TestSolution {
    @Test
    fun addTwoNumbers() {
        check(intArrayOf(2, 4, 3), intArrayOf(5, 6, 4), intArrayOf(7, 0, 8))
        check(intArrayOf(0), intArrayOf(0), intArrayOf(0))
        check(intArrayOf(9, 9, 9, 9, 9, 9, 9), intArrayOf(9, 9, 9, 9), intArrayOf(8, 9, 9, 9, 0, 0, 0, 1))
    }

    private fun check(l1Array: IntArray, l2Array: IntArray, answerArray: IntArray) {
        val solution = Solution()
        val l1: ListNode? = ListNode.buildNode(l1Array)
        val l2: ListNode? = ListNode.buildNode(l2Array)
        var answer: ListNode? = ListNode.buildNode(answerArray)
        var result = solution.addTwoNumbers(l1, l2)
        while (true) {
            val value1 = answer?.`val`
            val value2 = result?.`val`
            answer = answer?.next
            result = result?.next
            println("$value1 >> $value2")
            assert(value1 == value2)
            if (value1 == null && value2 == null) {
                return
            }
        }
    }
}