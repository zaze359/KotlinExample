package com.zaze.kotlin.example.algorithm.n1334

import com.zaze.kotlin.example.algorithm.base.Graph
import java.util.LinkedList
import java.util.PriorityQueue

/**
 * n 个
 */
class Solution {

    /**
     * [n]：n个城市
     * [edges]：edges[i] = [from, to, weight]，表示从from 到 to的路径长度，权重边
     * [distanceThreshold]：最大距离
     *
     * 找出 以某一个城市为中心，距离不超过 distanceThreshold 组成的城市圈中 包含城市最少的那个城市，相同选最大编号的城市。
     *
     * Dijkstra算法
     * 时间复杂度：最坏O(n^3)
     * 空间复杂度：O(n^2)
     */
    fun findTheCity(n: Int, edges: Array<IntArray>, distanceThreshold: Int): Int {
        // 创建图
        val graph = Graph(n)
        // 记录顶点到其他顶点的最短路径
        val vertexs = Array(n) {
            Array(n) {
                Graph.Vertex(it, Int.MAX_VALUE)
            }
        }
        // 添加边， O(n)
        edges.forEach {
            val from = it[0]
            val to = it[1]
            val weight = it[2]
            graph.addEdge(from, to, weight)
        }
        // 计算到其他顶点的最短距离
        // 最坏 O(n * n * n)
        for (i in 0 until n) {
            // 需要使用优先级队列，保证每次先从 最近的顶点 延展到其他顶点，保证出队顶点已经是最短路径
            val queue = PriorityQueue<Graph.Vertex> { l, r ->
                l.dist - r.dist
            }
            queue.add(vertexs[i][i])
            // 自身为 0
            vertexs[i][i].dist = 0
            // 记录所有边的访问状态，防止遍历到环时发生死循环
            val visited = BooleanArray(n)
            visited[i] = true
            // bfs, 处理最短路径
            // O(n * n)，关联n条边，每条边关联又n条边
            while (queue.isNotEmpty()) {
                // 获取 i 到 id 的 最短路径
                val vertex = queue.poll()
                val id = vertex.id
                // 处理 id 关联的所有边
                graph.getEdges(id).forEach { edge ->
                    // 计算 i -> id -> tId 的最短路径距离
                    val tId = edge.tId
                    // 获取 i 到 tId的 最短路径
                    val nextVertex = vertexs[i][tId]
                    // 比较 选取 最短路径
                    val distance = minOf(vertex.dist + edge.weight, nextVertex.dist)
                    if (distance in 1..distanceThreshold) { // 两边相加距离未超过最大距离，表示顶点可达
                        // 更新下最短路径
                        nextVertex.dist = distance
                        if (visited[tId]) {
                            // 顶点已经入队过，避免重复添加
                            return@forEach
                        }
                        // 新顶点，添加到队列中，处理和 tId 相关的边
                        queue.add(nextVertex)
                        visited[tId] = true
                    }
                }
            }
        }
        // 记录最少城市
        var minCities = Int.MAX_VALUE
        // 记录城市编号
        var cityId = 0
        // 遍历整个图
        for (i in 0 until n) {
            var cities = 0
            for (j in 0 until n) {
                if (vertexs[i][j].dist <= distanceThreshold) {
                    cities++
                }
            }
            if (cities in 0..minCities) {
                minCities = cities
                cityId = i
            }
        }
        return cityId
    }
}