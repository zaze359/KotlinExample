package com.zaze.kotlin.example.algorithm.n1094

class Solution {

    /**
     * [capacity]: 最大车载数
     * [trips]: 拼车信息数组
     *  trips[0]: 人数
     *  trips[1]: 上车位置
     *  trips[2]: 下车位置
     *
     *  若整个trips 过程都能成功拼车，返回 true
     *
     * 遍历 + 差分数组
     *
     * 时间复杂度: O(n + k)， k是最远距离
     * 空间复杂度: O(k)
     */
    fun carPooling(trips: Array<IntArray>, capacity: Int): Boolean {
        // 找出最远下车位置
        var max = 0
        trips.forEach {
            max = maxOf(max, it[2])
        }
        // 差分数组，存储 前后位置 的人数变化量
        val diff = IntArray(max + 1)
        trips.forEach {
            diff[it[1]] += it[0] // 上车
            diff[it[2]] -= it[0] // 下车
        }
        // 顺序遍历，累加就表示对应位置的人数。
        var count = 0
        diff.forEach {
            count += it
            if (count > capacity) return false
        }
        return true
    }
}