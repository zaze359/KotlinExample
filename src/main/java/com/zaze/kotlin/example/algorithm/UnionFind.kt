package com.zaze.kotlin.example.algorithm

/**
 * 并查集 n 表示大小
 */
class UnionFind(val n: Int) {
    val parent: IntArray
    val size: IntArray

    init {
        // 初始化并查集
        parent = IntArray(n)
        size = IntArray(n) {
            1
        }
        // 一开始都是根节点，彼此之间不连通
        repeat(n) {
            parent[it] = it
        }
    }


    /**
     * 查询 x节点的根节点
     * 若 x的父节点 == x，则表示 x是根节点。
     * 在查找的过程中进行路径压缩，即将parent指向root
     */
    fun find(x: Int): Int {
        return if (parent[x] == x) x else find(parent[x]).also {
            parent[x] = it
        }
    }

    /**
     * 合并两个节点
     * 将一个节点的根节点 作为另一个节点根节点的父节点。
     * 这里将 x的根节点，作为 y的根节点的父节点
     */
    fun union(x: Int, y: Int): Boolean {
        val rootX = find(x)
        val rootY = find(y)
        if (rootX == rootY) { // 已经联通，返回false
            return false
        }
        // x的根节点 作为 y的根节点的 父节点
        parent[rootY] = rootX
        return true
    }

    /**
     * 两者的根节点相同时表示彼此之间联通，属于同一个集合
     */
    fun connected(x: Int, y: Int): Boolean {
        return find(x) == find(y)
    }
}