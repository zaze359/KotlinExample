package com.zaze.kotlin.example.algorithm.n2558

import java.util.PriorityQueue

class Solution {
    /**
     * 每次从最多的 礼物堆中 挑选礼物，留下平方根数量的礼物，最小到1
     * 返回 k 次后 剩余的礼物数
     *
     * 时间复杂度：O(klogn), n = gifts.size
     * 空间复杂度: O(n)
     */
    fun pickGifts(gifts: IntArray, k: Int): Long {
        // 使用 优先级队列，
        val queue = PriorityQueue<Int> { a, b ->
            // 改为大顶堆，降序
            b - a
        }
        // 数组建堆时间、空间复杂度 O(n),也可以自己写原地建堆O(1)
        queue.addAll(gifts.toList())
        // 每次需要重新进行堆化， O(k * logn)
        repeat(k) {
            val num = queue.poll()
            if (num == 1) { // 里面都是 1了，直接返回
                return gifts.size.toLong()
            }
            queue.offer(Math.sqrt(num.toDouble()).toInt())
        }
        var sum = 0L
        while (queue.isNotEmpty()) {
            sum += queue.poll()
        }
        return sum
    }
}