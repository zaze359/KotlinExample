package com.zaze.kotlin.example.algorithm.n2477

class Solution {
    /**
     * dfs
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    fun minimumFuelCost(roads: Array<IntArray>, seats: Int): Long {
        if (roads.isEmpty()) return 0
        val n = roads.size
        // 构建图, 节点数 = 边数 + 1
        val graph = Array<ArrayList<Int>>(n + 1) {
            ArrayList()
        }
        roads.forEach { // 双向
            graph[it[0]].add(it[1])
            graph[it[1]].add(it[0])
        }
        // 人从叶子节点开始逐层向根节点移动。节点的人数 = 子树的大小
        // 耗油量 = 节点的人数 / 座位
        //
        // 总耗油量 = 各个节点向父节点移动的耗油量
        // 根节点开始 dfs，自底向上累计耗油
        return dfs(0, 0, seats, graph).second
    }

    private fun dfs(from: Int, to: Int, seats: Int, graph: Array<ArrayList<Int>>): Pair<Int, Long> {
        var sum = 1 // 人数
        var ans = 0L // 耗油，个子树之和
        for (node in graph[from]) { // 遍历各个子树
            if (node == to) continue
            val temp = dfs(node, from, seats, graph)
            // 累计节点人数
            sum += temp.first
            // 累计已耗油
            ans += temp.second
        }
        return if (from != to) { // 起始点不同，表示当前节点的人需要移动
            // 向上取整
            Pair(sum, ans + (sum + seats - 1) / seats)
        } else {
            Pair(sum, ans)
        }
    }
}