package com.zaze.kotlin.example.algorithm.n136

/**
 * 一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。
 * 找出那个只出现了一次的元素。
 * 要求 线性时间复杂度的算法 O(n)
 * 只使用常量额外空间 O(1)
 */
class Solution {
    /**
     * 位运算
     * 异或
     *  - 任何数和 0 做异或，结果仍然是原来的数
     *  - 任何数和其自身做异或,结果为0
     *  - 异或运算 满足交换律和结合律
     *  可得 单数出现最后还是自身，偶数出现就是0
     *
     *  每次多一个n 的状态流程: 0 -> n -> nn(0)
     *
     *  由于仅存在一个数是单数，其他都出现两次是偶数
     *
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    fun singleNumber(nums: IntArray): Int {
        // 异或 偶数为0，单数保留
        var ret = 0
        nums.forEach {
            ret = ret xor it
        }
        return ret
    }

    /**
     * 哈希表记录，值存在就删除。
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    fun singleNumber2(nums: IntArray): Int {
        val set = HashSet<Int>()
        nums.forEach {
            if (set.contains(it)) {
                set.remove(it)
            } else {
                set.add(it)
            }
        }
        // 由于仅有一个元素出现一起，其他都成对出现，所以最后仅剩余一个
        return set.single()
    }
}