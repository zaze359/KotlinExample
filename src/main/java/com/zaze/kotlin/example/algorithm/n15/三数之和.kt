package com.zaze.kotlin.example.algorithm.n15

class Solution {
    /**
     * 从数组中选择三个数，它们和为0，组合不重复。
     * 时间复杂度：O(n^2) = 外部循环 O(n) * 内部双指针遍历O(n)
     */
    fun threeSum(nums: IntArray): List<List<Int>> {
        val size = nums.size
        if (size < 3) {
            return emptyList()
        }
        // 首先 从小到大 进行排序，目的是方便后续遍历去重
        //  自带排序算法 时间/空间复杂度都是 O(logn)
        val sortedNums = nums.sorted()
        val result = ArrayList<List<Int>>()

        // 记录组合的第一个数字。
        // 满足条件的组合 第一个数字必然是 <=0，所以赋值为一个大于0的任意数即可。
        var pre = 1

        var a = 0 // 第一个数
        var b = 0 // 第二个数
        var c = 0 // 第三个数
        // 外部循环遍历
        for (i in 0 until size - 2) {
            a = sortedNums[i]
            // 若第一个数就 > 0，那么后续就不可能存在 和为0的组合。
            if (a > 0) {
                break
            }
            // 去重： 第一个数字 和上一次相同，跳过
            if (a == pre) {
                continue
            }
            pre = a
            // 右指针
            var right = size - 1

            // -4 -1 -1 0 1 2
            // 开始查找所有符合条件的 b c
            // 双指针 O(n)
            for (left in i + 1 until size - 1) {
                b = sortedNums[left]
                // 去重：>=2 次循环时，若当前的 b 和之前的一样，那就跳过。
                if (left - i >= 2 && b == sortedNums[left - 1]) {
                    continue
                }
                // 反推 c的值，然后反向查找
                c = 0 - a - b
                // 若 c 太大，就继续往前找。
                while (right > left && sortedNums[right] > c) {
                    right--
                }
                // 左右指针重合，遍历结束
                if (right <= left) {
                    break
                }
                if (sortedNums[right] == c) { // 若刚好等于c，找到一个组合
                    result.add(listOf(a, b, c))
                }
            }
        }
        return result
    }
}