package com.zaze.kotlin.example.algorithm.n2661

class Solution {

    /**
     * mat 表示元素的行列
     *
     * 超出元素arr[i] 所在的行或者列都被涂色的元素，返回最小下标的那个。
     * 即顺序遍历时先满足要求的就先返回。
     *
     * 遍历 + 计数
     *
     * 时间复杂度：O(m * n)
     * 空间复杂度：O(m * n)
     */
    fun firstCompleteIndex(arr: IntArray, mat: Array<IntArray>): Int {
        val m = mat.size
        val n = mat[0].size
        // numPoint 保存所有数字的位置，下标代表数字
        val numPoint = Array(m * n + 1) {
            IntArray(2)
        }

        for (row in 0 until m) {
            for (column in 0 until n) {
                // 记录数字所在的行列
                val num = mat[row][column]
                numPoint[num][0] = row
                numPoint[num][1] = column
            }
        }
        // 统计行列被上色的数量
        val rowCount = IntArray(m)
        val columnCount = IntArray(n)
        arr.forEachIndexed { index, num ->
            val row = numPoint[num][0]
            val column = numPoint[num][1]
            // 上色
            rowCount[row]++
            columnCount[column]++
            // 若果一行中的每一列都上色，或者 一列中的每一行都上色了
            if (rowCount[row] == n || columnCount[column] == m) {
                return index
            }
        }
        return -1
    }
}