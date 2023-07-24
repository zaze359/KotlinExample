package com.zaze.kotlin.example.algorithm

/**
 * 八皇后问题：皇后直接不能互相攻击，横直斜。
 * n 表示 n个皇后， NxN的棋盘
 */
class SolutionNQueens {
    private lateinit var positionArray: IntArray
    private var n = 0

    var row = 0
    var column = 0
    fun solveNQueens(n: Int): List<List<String>> {
        this.n = n
        positionArray = IntArray(n)

        val queuesList = ArrayList<IntArray>()
        val tableArray = Array(n) { IntArray(n) { 0 } }
        // 跳出条件
        // 1. 层级满了
        // 2. 遍历到最后也没找到满足条件的解
        while (row <= n || column <= n) {
            if (row == n) { // 层级满，找到一个解
                queuesList.add(positionArray.clone())
                // 向上回溯找其他解
                backtrack()
            } else if (row > 0 && column == n) {
                // 没找到满足的解，向上回溯继续寻找
                backtrack()
            }
            if (column >= n || row >= n) {
                // 回溯完 依然处于跳出条件
                break
            }
            if (check(row, column)) { // 满足条件
                // 记录位置
                positionArray[row] = column
                // 更新
                tableArray[row][column] = 1
                // 处理下一行
                row++
                column = 0
            } else {
                column ++
            }
        }

        println("----------------------")
        println("queuesList: ${queuesList.size}")
        queuesList.forEach { queue ->
            println("----------------------")
            queue.forEach {
                print("$it ")
            }
            println()
            println("----------------------")
            tableArray.forEachIndexed { p, first ->
                first.forEachIndexed { i, v ->
                    if (queue[p] == i) {
                        print("1 ")
                    } else {
                        print("0 ")
                    }
                }
                println()
            }
        }
        return generateBoard(queuesList)
    }
    private fun backtrack() {
        column = positionArray[--row]
        while ((column >= n - 1) && row > 0) {
            // 往上回溯，找到还能继续往后遍历的行
            column = positionArray[--row]
        }
        column++
    }

    private fun generateBoard(queuesList: ArrayList<IntArray>): List<List<String>> {
        val result = ArrayList<List<String>>()
        queuesList.forEach { queue ->
            val list = ArrayList<String>()
            for (i in 0 until n) {
                val chars = CharArray(n) {
                    '.'
                }
                chars[queue[i]] = 'Q'
                list.add(String(chars))
            }
            result.add(list)
        }
        return result
    }

    /**
     * 检测在列、对角线是否存在交集。
     * 同一行一般不用检测，因为每次添加一个就下移一行。
     */
    private fun check(row: Int, column: Int): Boolean {
        // 左上的空格
        var leftUp = column - 1
        // 右上的空格
        var rightUp = column + 1
        for (i in row - 1 downTo 0) { // 向上一层层检查
            // 同列上是否存在交集
            if (positionArray[i] == column) return false
            // 检查对角线，即左上的空格和右上的空格
            // 左上是否存在交集
            if (leftUp >= 0 && positionArray[i] == leftUp) return false
            // 右上是否存在交集
            if (rightUp < n && positionArray[i] == rightUp) return false
            leftUp--
            rightUp++
        }
        return true
    }
}