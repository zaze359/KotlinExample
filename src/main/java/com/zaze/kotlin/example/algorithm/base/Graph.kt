package com.zaze.kotlin.example.algorithm.base

import java.util.*
import kotlin.collections.ArrayList

/**
 * 有向有权图
 * 以邻接表的形式表示
 */
class Graph(
    // 顶点数
    val v: Int
) {
    /**
     *  邻接表
     *  从记录顶点出去的边
     */
    private val adj = Array(v) {
        LinkedList<Edge>()
    }

//    /**
//     * 逆邻接表
//     * 记录指向顶点的边
//     */
//    private val reverseAdj = Array(v) {
//        LinkedList<Edge>()
//    }

    fun addEdge(from: Int, to: Int, weight: Int) {
        // 0 -> 1, 2, 3
        adj[from].add(Edge(from, to, weight))
        // 1 <- 0, 2
        adj[to].add(Edge(to, from, weight))
    }

    /**
     * 返回所有 id 指出的边
     */
    fun getEdges(id: Int): List<Edge> {
        return adj[id]
    }
//
//    /**
//     * 返回所有 指向顶点 id 的边
//     */
//    fun getInEdges(id: Int): List<Edge> {
//        return reverseAdj[id]
//    }

    /**
     * 求 s 到 t 的最短路径
     */
    fun dijkstra(s: Int, t: Int) {

    }

    /**
     * 权重边
     */
    data class Edge(
        // 来源
        val sId: Int,
        // 目标
        val tId: Int,
        // 权重
        val weight: Int,
    )

    /**
     * dijkstra算法使用
     * 记录到 顶点id 的距离
     */
    data class Vertex(
        val id: Int, // 顶点id
        // 到 id的距离
        var dist: Int,
    )
}