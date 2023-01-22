package com.zaze.kotlin.example.algorithm.n566

fun main() {
    // val mat = arrayOf(intArrayOf(1, 2), intArrayOf(3, 4))
    val mat = arrayOf(intArrayOf(1, 2))
    val result = Solution().matrixReshape(mat, 1, 2)

    for (r in result) {
        for (c in r) {
            println("${c}")
        }
    }

}

class Solution {
    fun matrixReshape(mat: Array<IntArray>, r: Int, c: Int): Array<IntArray> {
        val m = mat.size
        if (m == 0) {
            return mat
        }
        val n = mat[0].size
        val max: Int = m * n
        if (r * c != max) {
            return mat
        }

        var position: Int
        val result = Array(size = r, init = {
            val array = IntArray(c)
            val offset = it * c
            for (i in 0 until c) {
                position = offset + i
                array[i] = mat[position / n][position % n]
            }
            array
        })
        return result
    }
}