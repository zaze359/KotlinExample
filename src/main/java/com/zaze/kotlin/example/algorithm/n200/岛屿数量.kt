package com.zaze.kotlin.example.algorithm.n200

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 */
class Solution {
    /**
     * DFS
     * 1. 遍历到1时 就进行深搜，深搜的结果的就是岛屿的区域。
     * 2. 将这些遍历过的元素置为0.
     * 深搜触发的次数就是 岛屿的个数
     *
     * 时间复杂度：O(MN)， MN为行列数
     * 空间复杂度:
     *  最好：O(1)，全是水
     *  最坏：O(MN)，全是陆地，递归栈大小 M*N
     * BFS 同理， 搜索次数就是 岛屿数。
     */
    fun numIslands(grid: Array<CharArray>): Int {
        if (grid.isEmpty()) return 0
        var landNum = 0
        for (row in grid.indices) {
            for (col in grid[row].indices) {
                if (grid[row][col] == '1') {
                    landNum++
                    dfs(grid, row, col)
                }
            }
        }
        return landNum
    }

    private fun dfs(grid: Array<CharArray>, row: Int, column: Int) {
        if (row < 0 || column < 0
            || grid.size <= row || grid[row].size <= column
            || grid[row][column] == '0') return
        // 遍历过的节点置为 '0'
        grid[row][column] = '0'
        // 处理上下左右
        dfs(grid, row - 1, column)
        dfs(grid, row + 1, column)
        dfs(grid, row, column - 1)
        dfs(grid, row, column + 1)
    }
}