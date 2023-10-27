package com.zaze.kotlin.example.algorithm.n1631

import java.util.LinkedList

/**
 * 最小体力消耗路径(最平缓路径)
 * 1. 可上下左右移动
 * 2. 最大值 10^6
 * 找出路径中相邻格子的最小差值
 */
class Solution {
    // 定义4个移动方向，上下左右
    private var dirs = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(0, 1))
    fun minimumEffortPath(heights: Array<IntArray>): Int {
        return minimumEffortPath1(heights)
    }

    /**
     * 二分查找，MxN的图 可以对应 [0, mn) 区间内的整数，进行编号 (i, j)位置对应id = i * n + j
     * 假设存在 路径n，满足从左上到右下。n 的取值在 [left ~ right] 区间内，一开始取[0, 999999]
     * 我们先取 中间位置 x = (left + right) / 2 作为最短路径，广度遍历 看看是否能也能到达。
     *  若能到达，则记录路径长度，接着 在 [left ~ x) 内再次进行二分查找。
     *  若不能到达 则再 (x, right] 间 二分查找。
     * 直到找到最小满足条件的那个
     */
    private fun minimumEffortPath1(heights: Array<IntArray>): Int {
        val row = heights.size // 行
        val column = heights[0].size // 列
        var left = 0 // 最小值
        var right = 999999 // 最大值
        var ans = 0
        // 二分查找, 退出条件 left > right
        while (left <= right) {
            // 取二分的中间值作为 最小路径，判断是否还能到达右下
            val min = (left + right).shr(1) // 二分
            val queue = LinkedList<Pair<Int, Int>>()
            queue.push(0 to 0)
            val seen = BooleanArray(row * column) // 记录哪些位置已经走过了，过滤重复计算
            seen[0] = true
            while (queue.isNotEmpty()) {
                val (x, y) = queue.pop()
                // 遍历 上下左右四个操作
                repeat(dirs.size) {
                    // 下一个位置
                    val nextX = x + dirs[it][0]
                    val nextY = y + dirs[it][1]
                    // 对应的数组下标
                    val index = nextX * column + nextY
                    // 没有越界 && next位置之前还未走到过 && 该次行动的路径长度(高度差)<=min
                    if (nextX in 0 until row && nextY in 0 until column
                        && !seen[index]
                        && Math.abs(
                            heights[x][y] - heights[nextX][nextY]
                        ) <= min
                    ) {
                        // 路径可达，加入队列，这里只要确定可达即可，不用关心是否是最小
                        queue.push(nextX to nextY)
                        // 记录已经来过
                        seen[index] = true
                    }
                }
            }
            // 该次二分结束
            if (seen[row * column - 1]) { // 能到达右下角了
                // 先记录下路径，接着再看看有没有更小的路径
                ans = min
                right = min - 1
            } else { // 按照min路径长度，无法到达右下，那么往更大的路径长度中找。
                left = min + 1
            }
        }
        return ans
    }

    /**
     * 并查集思路
     * 1. 将 MxN图，进行编号，对应[0, mn) 区间的数字。(i, j)位置对应id = i * n + j
     * 2. 使用所有节点初始化并查集，此时它们彼此都不连通。
     * 3. 我们将相邻的两点组成一条边，两点之间的高度差值，作为边的权值。
     *    由于高度差取绝对值，所以是无向图， (x - 1, y) <-> (x, y) 连接为一条边
     *    (x, y - 1) <-> (x, y) 连接为一条边
     * 4. 将边按照权值 从小到达排序，依次开始连接这些边，也就是将对应两个节点在并查集中联合，并记录最大权重
     *    (x - 1, y) <-> (x, y) 对应  union(x * n - n + y, x * n + y)
     *    (x, y - 1) <-> (x, y) 对应  union(x * n + y - 1, x * n + y)
     * 5. 没次连接边之后 判断一下 最左上 和 最右下 是否联通，若联通了则中断遍历，此时记录的权重就是最小高度差。
     */
    private fun minimumEffortPath2(heights: Array<IntArray>): Int {
        return 0
    }
}