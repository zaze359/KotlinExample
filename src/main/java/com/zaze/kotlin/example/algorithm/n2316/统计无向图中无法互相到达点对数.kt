package com.zaze.kotlin.example.algorithm.n2316

import com.zaze.kotlin.example.algorithm.UnionFind

/**
 * 返回 无法互相到达 的不同 点对数目
 */
class Solution {
    /**
     * 使用并查集
     * 时间复杂度：
     * 空间复杂度：O(n)
     */
    fun countPairs(n: Int, edges: Array<IntArray>): Long {
        val unionFind = UnionFind(n)
        edges.forEach {
            unionFind.union(it[0], it[1])
        }
        var unPair = 0L
        for (i in 0 until n) {
            // 累加所有节点 不连通的节点数。
            unPair += n - unionFind.getSize(unionFind.find(i))
        }
        // 由于是无向图， 所以 (1, 2)不连通 和 (2, 1)不连通 为同一条边需要除以2
        return unPair / 2
    }
}