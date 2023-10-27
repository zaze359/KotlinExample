package com.zaze.kotlin.example.algorithm.n36

/**
 * 判断一个 9 x 9 的数独是否有效
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次
 */
class Solution {
    /**
     * 9x9 数量固定，所以是 O(1)
     * 时间复杂度：O(1)
     * 空间复杂度：O(1)
     */
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        // 记录数字出现的次数
        val rows = Array(9) { IntArray(9) }
        val columns = Array(9) { IntArray(9) }
        // 3x3 宫格，9x9里面右 3x3个子宫格组成
        val subBoard = Array(3) { Array(3) { IntArray(9) } }
        for (row in board.indices) {
            for (col in board[row].indices) {
                val c = board[row][col]
                if (c != '.') { // . 表示空位
                    // 1 ~ 9，对应 0 ~ 8
                    val num = c - '1'
                    rows[row][num]++
                    columns[col][num]++
                    // 3个为一组
                    subBoard[row / 3][col / 3][num]++
                    if (rows[row][num] > 1 || columns[col][num] > 1 || subBoard[row / 3][col / 3][num] > 1) {
                        return false
                    }
                }
            }
        }
        return true
    }
}