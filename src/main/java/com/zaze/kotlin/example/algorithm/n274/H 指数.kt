package com.zaze.kotlin.example.algorithm.n274

/**
 * h指数：至少  h 篇论文，并且每篇论文 至少 被引用 h 次
 * 最大为 论文数 n
 */
class Solution {
    /**
     * 排序
     *
     * 按照引用数排序，这样 第 n 篇论文的 一定至少被引用了 citations[n - 1] 次
     * 这样 引用数 和 剩余论文数的最小值 就是 h指数
     *
     * 复杂度 取决于 排序算法. O(nlogn)
     *
     */
    fun hIndex2(citations: IntArray): Int {
        if (citations.isEmpty()) return 0
        // 从小到大排序
        citations.sort()
        var h = 0
        citations.forEachIndexed { index, ref ->
            // 剩余数 = 当前 + 后续
            val remaining = citations.size - index
            if (ref > remaining) {
                // 引用次数大于剩余论文数，此时后续就一定不满足 条件。
                // 此时返回 之前计算得到的h 和  剩余数的最大值
                return maxOf(h, remaining)
            }
            // 此时取 引用数 和 剩余论文数的最小值即可。
            h = minOf(ref, remaining)
        }
        return h
    }

    /**
     * 排序改
     */
    fun hIndex3(citations: IntArray): Int {
        if (citations.isEmpty()) return 0
        // 从小到大排序
        citations.sort()
        var h = 0
        for (i in citations.size - 1 downTo 0) {
            if (citations[i] > h) { // 引用次数大于 h
                // 找到一篇 至少引用了 h + 1 次的论文
                h++
            } else {
                return h
            }
        }
        return h
    }

    /**
     * 二分查找
     *
     * h 指数最大为 论文数 n，[0, n]
     * 通过二分的方式取值 来验证是否满足 h指数的特性。
     *
     * 时间复杂度: O(nlogn) logn 次 完整的遍历
     * 空间复杂度：O(1)
     *
     */
    fun hIndex(citations: IntArray): Int {
        if (citations.isEmpty()) return 0
        var left = 0
        var right = citations.size
        var mid = 0
        while (left < right) {
            var count = 0
            // 二分，+ 1 向上取整，防止死循环， 0， 1
            mid = (left + right + 1) shr 1
            citations.forEach {
                if (it >= mid) { // 记录 引用数 >= mid 的数量
                    count++
                }
            }
            when {
                count >= mid -> { // h >= mid
                    left = mid
                }

                else -> { // h <mid
                    right = mid - 1
                }
            }
        }
        return left
    }

    /**
     * 计数排序
     * 分配 counter[n + 1], 每个桶记录 引用次数为i 的论文的数量， 数组最后一个元素记录 >= n 的数量
     *
     */
}