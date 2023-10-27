package com.zaze.kotlin.example.algorithm.n2316

import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class SolutionTest {
    @Test
    fun countPairs() {
        val solution = Solution()
        assertEquals(
            0,
            solution.countPairs(
                3,
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(0, 2),
                    intArrayOf(1, 2),
                )
            )
        )
        assertEquals(
            14,
            solution.countPairs(
                7,
                arrayOf(
                    intArrayOf(0, 2),
                    intArrayOf(0, 5),
                    intArrayOf(2, 4),
                    intArrayOf(1, 6),
                    intArrayOf(5, 4),
                )
            )
        )
    }
}

class UnionFind(val n: Int) {
    // 记录每个节点的父节点。
    private val parent: IntArray

    //
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