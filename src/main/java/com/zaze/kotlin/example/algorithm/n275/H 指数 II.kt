package com.zaze.kotlin.example.algorithm.n275

class Solution {

    /**
     * citations 已经按照 升序排列
     * 要求对数 时间复杂度 O(logn)
     *
     * 由于已经有序只需要查找，二分 符合 O(logn)
     * 找到 论文数和 引用数最接近的位置就是 h
     */
    fun hIndex(citations: IntArray): Int {
        if (citations.isEmpty()) return 0
        // 数组的左右指针
        var left = 0
        var right = citations.size - 1
        var mid: Int
//        var h = 0
        while (left <= right) {
            mid = left + ((right - left) shr 1)
            val count = citations.size - mid // 剩余论文数
            val ref = citations[mid] // 引用次数
            when {
                count == ref -> { // 此时一定是最大的。
                    return count
                }

                count > ref -> { // 如果h由 ref 决定，那么后面找，后面的ref 更大，
                    left = mid + 1
//                    h = maxOf(h, ref)
                }

                else -> { // h 由 count 决定，那么需要往前找，往前 count 变大
                    right = mid - 1
//                    h = maxOf(h, count)
                }
            }
        }
//        return h
        // 最后的结果 left 必然处于 mid 的右端
        return citations.size - left
    }
}