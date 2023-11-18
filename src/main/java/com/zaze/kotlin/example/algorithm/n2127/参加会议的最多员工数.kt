package com.zaze.kotlin.example.algorithm.n2127

import java.util.LinkedList


/**
 * - 一张 圆形 的桌子，可以坐下 任意数目 的员工
 * - 邀请名单上有 n 位员工,  员工编号为 0 到 n - 1
 * - 每位员工都有一位 喜欢 的员工（不是自己），当且仅当 他被安排在喜欢员工的旁边，他才会参加会议
 * 求能参加会议的 最多员工数
 */
class Solution {
    /**
     * favorite[i]: 表示第i位员工喜欢的员工
     *
     * 最多员工数：
     * 1. 环>=3 , 此时已经形成闭环，无法在插入其他人。最大的有向环大小 就是 最多。
     * 2. 环=2， 相当于将两条单向链路 顶点联通，从而也符合要求。特定是两端还可以结合其他的2环。所有2环所在的链长度和
     *
     * 拓扑排序(Kahn算法) + 动态规划
     *
     * 利用拓扑排序，找出所有不在环中节点。
     * 动态规划 记录  节点的最大链路长度
     *
     * 时间复杂度：O(n), 多次线性遍历
     * 空间复杂度：O(n)，多个线性的数组。
     */
    fun maximumInvitations(favorite: IntArray): Int {
        val n = favorite.size
        // 统计各个节点的入度
        val inDegree = IntArray(n)
        favorite.forEachIndexed { index, i ->
            // index -> i
            inDegree[i]++
        }
        val queue = LinkedList<Int>()
        // 找出所有入度为0的节点。这些就是边缘顶点
        inDegree.forEachIndexed { index, i ->
            if (i == 0) {
                queue.add(index)
            }
        }
        // 状态数组 记录从边缘顶点到达节点i 所经过的最大节点数。
        // 最终是为了知道 环上节点所相连的环外节点的最大路径长度。即邀请这个员工时 至少能有多少人来。
        val dp = IntArray(n) { 1 }
        val visited = BooleanArray(n) {
            false
        } // 记录哪些节点被遍历到了，即不在环中
        // BFS
        while (queue.isNotEmpty()) {
            val i = queue.poll() // 当前遍历的节点
            visited[i] = true // 标记，防止重复访问
            val f = favorite[i] // 喜欢对象
            // 选择 最大的一个。
            dp[f] = maxOf(dp[i] + 1, dp[f])
            // 入度减1，表示删除了 i 节点
            inDegree[f]--
            if (inDegree[f] == 0) { // 入度变为0
                queue.add(f)
            }
        }

        var maxRing = 0
        var maxLine = 0
        // 遍历环上的节点，计算最大环，以及所有2环链路和。
        repeat(n) {
            if (visited[it]) { // 不在环中, 下一个
                return@repeat
            }
            // 在环中， 此时需要特殊处理 环=2的情况
            visited[it] = true
            var next = favorite[it] // 喜欢对象
            if (it == favorite[next]) {// 互相喜欢，环=2
                maxLine += dp[next] + dp[it]
                visited[next] = true
                return@repeat
            }
            // 环 >= 3，需要遍历计算出环的大小
            var tempRing = 2
            while (favorite[next] != it) { // 重新遍历回当前节点表示走完环
                tempRing++
                visited[next] = true
                // 找出下一个
                next = favorite[next]
            }
            maxRing = maxOf(tempRing, maxRing)
        }
        return maxOf(maxLine, maxRing)
    }
}