package com.zaze.kotlin.example.algorithm.n1466

class Solution {

    /**
     * 遍历统计 + dfs
     * 时间复杂度：O(n)
     * 时间复杂度：O(n)
     */
    fun minReorder(n: Int, connections: Array<IntArray>): Int {
        // 记录节点所有相连的边
        val graph = Array<ArrayList<IntArray>>(n) {
            ArrayList()
        }
        connections.forEach {
            // 实际存在的边，标记为1
            graph[it[0]].add(intArrayOf(it[1], 1))
            // 实际不存在的方向，标记为0
            graph[it[1]].add(intArrayOf(it[0], 0))
        }
        // dfs 遍历 图，若指向的边为1， 则需要变向
        return dfs(0, -1, graph)
    }

    private fun dfs(form: Int, parent: Int, graph: Array<ArrayList<IntArray>>): Int {
        var ans = 0
        for (edge in graph[form]) {
            val node = edge[0]
            if (node == parent) { // 回滚
                continue
            }
            // dfs 直到 叶子节点
            // 若边为1，则需要变向一次，0则不需要
            ans += edge[1] + dfs(node, form, graph)
        }
        return ans
    }
}