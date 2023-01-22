package com.zaze.kotlin.example.algorithm.n640

/**
 * 求解方程
 */
class Solution {
    private val operationSet = setOf('+', '-')
    fun solveEquation(equation: String): String {
        return equation.split("=")
            .takeIf { it.size == 2 }
            ?.let {
                val left = deal(it[0])
                val right = deal(it[1])
                val xCount = left.first - right.first
                val numCount = right.second - left.second
                if (xCount == 0) {
                    Pair(0, numCount)
                } else {
                    Pair(1, numCount / xCount)
                }
            }
            ?.let {
                when {
                    it.first > 0 -> {
                        "x=${it.second}"
                    }
                    it.first == 0 && it.second == 0 -> {
                        "Infinite solutions"
                    }
                    else -> {
                        "No solution"
                    }
                }
            }
            ?: throw IllegalArgumentException()

    }

    /**
     * first x count
     * second num count
     */
    fun deal(equation: String): Pair<Int, Int> {
        var i = 0
        var j = 0
        var xCount = 0
        var numCount = 0
        var operation = '+'
        while (i < equation.length && j < equation.length) {
            var temp = ""
            if (operation in operationSet) {
                while (i < equation.length && equation[i] !in operationSet) {
                    temp += equation[i]
                    i++
                }
            }
            j = i
            i++
            when {
                temp.isEmpty() -> {

                }
                temp.contains("x") -> {
                    xCount += addSign(operation, temp.substring(0, temp.length - 1).takeIf {
                        it.isNotEmpty()
                    }?.toInt() ?: 1)
                }
                else -> {
                    numCount += addSign(operation, temp.toInt())
                }
            }
            if (j < equation.length) {
                operation = equation[j]
            }
        }
        return Pair(xCount, numCount)
    }

    private fun addSign(operation: Char, num: Int): Int {
        return if (operation == '+') {
            num
        } else {
            -num
        }
    }
}