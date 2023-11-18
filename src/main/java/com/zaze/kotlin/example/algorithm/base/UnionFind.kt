package com.zaze.kotlin.example.algorithm.base

/**
 * 并查集 n 表示大小
 * 1. 将元素映射到数组下标。例如 M * N 的图，index = m * n + n
 * 2. 根节点：元素的父节点 = 元素自身
 * 3. 两个元素的父节点相同表示 这两个元素联通.
 */
class UnionFind(val n: Int) {
    // 记录每个节点的父节点。
    private val parent: IntArray

    // 每个节点的连通分量，即该节点作为根节点时的子树大小。
    private val size: IntArray

    init {
        // 初始化并查集
        parent = IntArray(n)
        size = IntArray(n) {
            1
        }
        // 一开始初始化为根节点，即自身的父节点 = 自身
        // 表示彼此之间不连通
        repeat(n) {
            parent[it] = it
        }
    }


    /**
     * 查询 x节点的根节点
     * 若 x的父节点 == x，则表示 x是根节点。
     * 在查找的过程中进行路径压缩
     */
    fun find(x: Int): Int {
        return if (parent[x] == x) {
            x
        } else {
            // 递归查找父节点的根节点
            find(parent[x]).also {
                // 路径压缩, 将parent 直接指向root, 这样下次就不必再递归。
                parent[x] = it
            }
        }
    }

    /**
     * 合并 x, y两个节点：即将一个节点的根节点 作为另一个节点根节点的父节点。
     */
    fun union(x: Int, y: Int): Boolean {
        val rootX = find(x)
        val rootY = find(y)
        if (rootX == rootY) { // 已经联通，返回false
            return false
        }
        // 连通分量小的合并到大的里面
        // x > y,将 y 合并到 x
        if (size[x] > size[y]) {
            // 将y的根节点的父节点执行 x的根节点。
            parent[rootY] = rootX
            // 更新 rootX 的连通分量
            size[rootX] += size[rootY]
        } else { // x < y,将 x 合并到 y
            parent[rootX] = rootY
            size[rootY] += size[rootX]
        }
        return true
    }

    /**
     * 两者的根节点相同时表示彼此之间联通，属于同一个集合
     */
    fun connected(x: Int, y: Int): Boolean {
        return find(x) == find(y)
    }

    /**
     * 返回 x 的连通分量
     */
    fun getSize(x: Int): Int {
        return size[x]
    }
}