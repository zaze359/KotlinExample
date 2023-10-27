package com.zaze.kotlin.example.algorithm.n1488

import java.util.*
import kotlin.collections.HashMap

/**
 * 你一个整数数组 rains, 下标 表示第几天， value 表示 第几个湖泊
 *
 * rains[i] > 0 表示第 i 天时，第 rains[i] 个湖泊会下雨。  ans[i] == -1
 * rains[i] == 0 表示第 i 天没有湖泊会下雨，你可以选择 一个 湖泊并 抽干 这个湖泊的水。ans[i] = 选择抽干的湖泊
 *
 */
class Solution {

    /**
     * 发生洪水再泄洪这样的方式倒推结果，类似处理散列冲突
     * 1. 记录晴天, 可以记录的前提是存在已满的湖泊。不会超过湖泊数。
     * 2. 下雨天先判断是否发生洪水，若发生则消耗一个晴天。选择的晴天 不能是湖泊满 之前日子。
     * 时间复杂度：O(n * 查询) 查询算法，泄洪对应的晴天
     * 空间复杂度: O(n)
     */
    fun avoidFlood(rains: IntArray): IntArray {
        if (rains.isEmpty()) return intArrayOf()
        // 记录每天的方案，不知道为什么不能是0，好像必须得抽一个，那么默认为 1 吧
        val ans = IntArray(rains.size) { 1 }
        // 记录晴天，入队出队O(1)
        val fineDays = LinkedList<Int>()
        // 记录已满湖泊 以及 充满的日期
        val lakeSet = HashMap<Int, Int>()
        // 湖泊号
        var num: Int
        for (i in rains.indices) {
            num = rains[i]
            when {
                num == 0 -> { // 晴天
                    if (lakeSet.size > fineDays.size) {
                        // 可以抽水的前提是，存在已满的湖泊
                        fineDays.add(i)
                    }
                }

                !lakeSet.contains(num) -> { // 湖泊未满，记录湖泊
                    ans[i] = -1
                    lakeSet[num] = i
                }

                fineDays.isEmpty() -> { // 发生洪水，且无晴天
                    return intArrayOf()
                }

                else -> { // 发生洪水, 有晴天可以抽干
                    // 当前正常处理
                    ans[i] = -1
                    val minIndex = lakeSet[num] ?: 0
                    // 更新一下日期
                    lakeSet[num] = i
                    // 选择的晴天，直接遍历了
                    run findFine@{
                        for (j in fineDays.indices) {
                            if (fineDays[j] > minIndex) { // 在湖泊满之后的日子
                                ans[fineDays[j]] = num
                                fineDays.removeAt(j)
                                return@findFine
                            }
                        } // 找不到，无法泄洪
                        return intArrayOf()
                    }
                }
            }
        }
        return ans
    }
}