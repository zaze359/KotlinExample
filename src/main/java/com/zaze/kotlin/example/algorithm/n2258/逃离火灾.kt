package com.zaze.kotlin.example.algorithm.n2258

import java.util.*

/**
 * 0 表示草地。
 * 1 表示着火的格子。
 * 2 表示一座墙，你跟火都不能通过这个格子。
 * 火可以蔓延到非墙的所有相邻格子，有共同边，上下左右。
 * 每 1min 可以移动一格，同时火蔓延一次
 *
 * 起始位置 (0, 0)
 * 安全屋 (m - 1, n - 1)
 */
class Solution {
    companion object {
        const val MAX = 1e9.toInt() // 最大值 10^9

        // 定义4个移动方向，上下左右
        val dirs = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(0, 1))
    }

    /**
     * 起始位置 (0, 0)
     * 安全屋 (m - 1, n - 1)
     * 时间复杂度：O(n * m)，2次 BFS遍历所有的格子。
     * 空间复杂度: O(n * m)，多个数组，记录所有格子的状态。
     */
    fun maximumMinutes(grid: Array<IntArray>): Int {
        val n = grid.size
        val m = grid[0].size
        // BFS 扫描所有格子，计算所有节点被火蔓延到的时间。
        val fireTime = dealFireTime(grid)
        // 安全屋着火时间，火到安全屋的最短路径
        val roomFireTime = fireTime[n - 1][m - 1]
        // --- BFS 找出安全的最短路径，遍历过程最先安全到达安全屋的就是最短路径。
        // 等待时间wait; 安全屋着火时间(路径) x; 人到安全屋时间(路径)y。人和火可以同时到达
        // 1. 人和火的两者路径没有交集，wait = x - y
        // 2. 人和火的路径存在交集，假设最先重合路径长度为 n, 则 y - n + wait = x - n，得到 wait = x - y。
        //     此时交点相当于是安全屋，不过交点是不能同时达到的，需要特殊处理，判断交点的最短时间是不是x - 1，若是则 wait = x - y - 1
        // 所有 y 越小 wait 越大，所以只要找出安全的最短路径即可。
        val queue = LinkedList<Pair<Int, Int>>()
        queue.add(0 to 0)
        val visited = Array(n) {
            BooleanArray(m)
        }
        var time = 1
        var preFireTime = 0 // 记录路径的前一格的着火时间
        var max = -1
        while (queue.isNotEmpty()) {
            // 扫描一层
            repeat(queue.size) {
                val xy = queue.poll()
                // 记录一下前一格着火时间
                preFireTime = fireTime[xy.first][xy.second]
                // 遍历上下左右
                dirs.forEach { dir ->
                    val x = xy.first + dir[0]
                    val y = xy.second + dir[1]
                    if (x < 0 || x >= n || y < 0 || y >= m // 越界
                        || grid[x][y] == 2 // 墙
                        || visited[x][y] // 以及访问过了
                    ) {
                        return@forEach
                    }
                    if (x == n - 1 && y == m - 1) { // 找到安全屋了
                        // 记录这条路径的最大等待时间，还需要看看其他路径
                        max = maxOf(max, when {
                            fireTime[x][y] == MAX -> {
                                MAX
                            }

                            preFireTime == fireTime[x][y] - 1 -> { // 前一个格子不能同时到达
                                roomFireTime - time - 1
                            }

                            else -> { //
                                roomFireTime - time
                            }
                        })
                        return@forEach
                    }
                    visited[x][y] = true
                    if (fireTime[x][y] > time) { // 不着火，此路径可以继续
                        queue.add(x to y)
                    }
                }
            }
            time++
        }
        return max
    }

    /**
     * 先计算出所有格子的着火时间
     * 时间复杂度：O(n * m)
     */
    private fun dealFireTime(grid: Array<IntArray>): Array<IntArray> {
        val n = grid.size
        val m = grid[0].size
        // 记录格子着火的需要的最短时间
        val fireTime = Array(n) {
            IntArray(m) {
                MAX
            }
        }
        // 记录需要处理的格子坐标(x, y)
        val queue = LinkedList<Pair<Int, Int>>()
        // 遍历所有格子, 先找出一开始就着火的格子
        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] == 1) {
                    queue.add(i to j)
                    fireTime[i][j] = 0
                }
            }
        }
        var time = 1
        // BFS ，从着火位置开始扫描上下左右
        while (queue.isNotEmpty()) {
            // 扫描一层
            repeat(queue.size) {
                val xy = queue.poll()
                // 遍历上下左右
                dirs.forEach { dir ->
                    val x = xy.first + dir[0]
                    val y = xy.second + dir[1]
                    if (x in 0 until n
                        && y in 0 until m
                        && grid[x][y] == 0       // 0 表示草地
                        && fireTime[x][y] == MAX // 表示未处理
                    ) { // 变为着火
                        fireTime[x][y] = time
                        queue.add(x to y)
                    }
                }
            }
            time++
        }
        return fireTime
    }
}
