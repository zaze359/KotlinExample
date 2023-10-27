package com.zaze.kotlin.example.algorithm.n260

/**
 * 有两个元素只出现一次，其余所有元素均出现两次
 * 线性时间复杂度
 * 常量额外空间
 *
 */
class Solution {

    /**
     * 位运算
     *
     * 题中为 成对出现，首先想到的是使用异或
     * 所有元素异或之后得到  x = a ^ b, 由于 a != b 所有 x != 0
     * 因此，x的二进制表示中，存在 一个或者多个 1。取最低位的 1即可，假定位置为 i。
     * 由于 1 是 异或的结果，所以在a 或者 b 的对应位中有且仅有一个是 1，另一个是 0
     * 不妨假定 ai = 1, bi = 0
     * 遍历找出所有 这个位为 1 的的所有数，里面包含a不包含b，那么和 x = a ^ b做异或，最终结果必然可以得到 b
     * 最后 x 和 b做异或 得到 a。(当然也可以在遍历中直接得到a, 不过这样需要多做好几次 异或操作)
     *
     * 时间复杂度：O(n) 需要遍历 两次
     */
    fun singleNumber(nums: IntArray): IntArray {
        var x = 0
        nums.forEach {
            x = x xor it
        }
        var i = 0 // 记录 为 1 的位置
        run loop@ {
            repeat(32) {
                i = it
                if ((x shr i) and 1 == 1) {
                    return@loop
                }
            }
        }
        var a = x
        nums.forEach {
            // 找出 对应 index为 1 的元素 进行异或
            if ((it shr i) and 1 == 1) {
                a = a xor it
            }
        }
        // 最后 x xor a 得到 b
        return intArrayOf(a, x xor a)
    }
}