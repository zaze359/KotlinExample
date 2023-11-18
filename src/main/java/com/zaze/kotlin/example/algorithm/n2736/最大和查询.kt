package com.zaze.kotlin.example.algorithm.n2736

import java.util.*

class Solution {
    fun maximumSumQueries(nums1: IntArray, nums2: IntArray, queries: Array<IntArray>): IntArray {
        val n = nums1.size
        val m = queries.size
        val ans = IntArray(m)
        // 将 nums1 和 nums2 合并
        val pairs = Array(n) {
            IntArray(2)
        }
        for (i in 0 until n) {
            pairs[i][0] = nums1[i]
            pairs[i][1] = nums2[i]
        }
        // 按照第一个元素 pair[i][0]，降序排序
        pairs.sortByDescending {
            it[0]
        }
        //
        // 将 queries的值和下标绑定
        val sortedQueries = Array(m) {
            IntArray(3)
        }
        queries.forEachIndexed { index, ints ->
            sortedQueries[index][0] = index
            sortedQueries[index][1] = ints[0]
            sortedQueries[index][2] = ints[1]
        }
        // 根据queries[i][0]， 降序排列
        sortedQueries.sortByDescending {
            it[1]
        }
        // 上述处理完后，sortedQueries[][1] 和 pairs[][0],
        // 即第一个表示值的元素都是按照降序排序
        // 所以若找到一个 pair[j] 满足 pair[j][0] >= x, 那么这个 pair[j][0] 也一定大于后续遍历的 x
        // 所以可以将之前匹配过程中，满足 num1>=x下的 num2的缓存下来。
        //
        // 栈的设计，用于保留遍历过程中满足 num1>=x 时的 num2以及对应的最大和。
        // stack[i][0]，存储 num2 = pair[j][1]；仅当比栈顶大时才会入栈，单调递增
        // stack[i][1]，存储和 = pair[j][0] + pair[j][1]，比当前和小的都会出栈，保留的都是和比当前大的，单调递减。
        // 最后一个元素表示栈顶，方便后续二分遍历
        val stack = LinkedList<IntArray>()
        // 遍历 sortedQueries
        var j = 0
        sortedQueries.forEachIndexed { index, ints ->
            val i = ints[0]
            val x = ints[1] // x 是降序排列的
            val y = ints[2] // y 乱序
            // 由于是降序，小于x 后面的就不用管了
            while (j < n && pairs[j][0] >= x) {
                val num1 = pairs[j][0] // num1 降序
                val num2 = pairs[j][1] // num2 乱序
                // 栈中存在数据，移除所有和比当前小的元素。
                // 由于 num1 是递减的，但是和变大了，所以 num2 一定是递增的。
                while (stack.isNotEmpty() && stack.last[1] <= (num1 + num2)) {
                    stack.removeLast()
                }
                // 检验 num2 是否更大，更大就保留，因为 y值列表是乱序的，所以需要将较大的保留，便于后面匹配。
                // 如果 num2 更小，由于栈顶的和也 >= 当前和，那么栈顶元素 完全可以替代当前的pairs[j]
                if (stack.isEmpty() || stack.last[0] < num2) {
                    stack.add(intArrayOf(num2, num1 + num2))
                }
                j++
            }
            // 二分查找
            val k = binarySearch(stack, y)
            ans[i] = if (k < stack.size) {
                stack[k][1]

            } else {
                -1
            }
        }
        return ans
    }

    private fun binarySearch(stack: LinkedList<IntArray>, y: Int): Int {
        var l = 0
        var r = stack.size
        // stack 第一个元素 单调递增
        while (l < r) {
            val mid = l + (r - l) / 2
            if (stack[mid][0] >= y) {
                r = mid
            } else {
                l = mid + 1
            }
        }
        return l
    }
}