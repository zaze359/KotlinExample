package com.zaze.kotlin.example.algorithm.n2646

class Solution {

    /**
     * dfs + 动态规划
     * 时间复杂度：O(n * m), m = trips.size
     * 空间复杂度: O(n)
     */
    fun minimumTotalPrice(n: Int, edges: Array<IntArray>, price: IntArray, trips: Array<IntArray>): Int {
        val graph = Array<ArrayList<Int>>(n) {
            ArrayList()
        }
        edges.forEach {
            graph[it[0]].add(it[1])
            graph[it[1]].add(it[0])
        }
        //
        // dfs统计所有旅行过程中所有节点经过的次数
        val counts = IntArray(n)
        trips.forEach {
            dfs(it[0], -1, it[1], graph, counts)
        }
        // 总价格 = sum(节点次数 * 节点价格)
        // 动态规划，统计节点所需的最少费用
        val ans = dp(0, -1, price, graph, counts)
        return minOf(ans[0], ans[1])
    }

    /**
     * O(n)
     */
    private fun dfs(node: Int, parent: Int, target: Int, graph: Array<ArrayList<Int>>, counts: IntArray): Boolean {
        if (node == target) {
            counts[node]++
            return true
        }
        for (child in graph[node]) {
            if (child == parent) {
                // 往回遍历，忽略
                continue
            }
            if (dfs(child, node, target, graph, counts)) {
                // 可达
                counts[node]++
                return true
            }
        }
        return false
    }

    private fun dp(
        node: Int,
        parent: Int,
        price: IntArray,
        graph: Array<ArrayList<Int>>,
        counts: IntArray
    ): IntArray {
        val p = price[node] * counts[node]
        // 0 表示当前节点不打折， 1 当前节点打折
        val curPrice = intArrayOf(p, p / 2)
        for (child in graph[node]) {
            if (child == parent) {
                // 往回遍历，忽略
                continue
            }
            // 累加计算子树的费用
            val childPrice = dp(child, node, price, graph, counts)
            // 当前不打折，子树可打折，可不打折，选小的。
            curPrice[0] += minOf(childPrice[0], childPrice[1])
            // 当前打折，相邻节点无法打折
            curPrice[1] += childPrice[0]
        }
        return curPrice
    }
}