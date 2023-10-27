package com.zaze.kotlin.example.algorithm.n137

/**
 * 给你一个整数数组 nums，
 * 除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。
 * 请你找出并返回那个只出现了一次的元素。
 * 要求 线性时间复杂度，常数级空间
 */
class Solution {

    /**
     * 位运算 + 取模
     * 我们要找出 那个单独元素，延续之前 异或 的思路
     * 若相同元素出现三次我们希望它变为0。
     * 每次多一个 n的状态流转：0 -> n -> nn -> nnn(0)
     * ---
     * 对于 相同的元素，它们的每一位数字都是相同的。
     * 由于重复出现3次，所以为 0 0 0 或 1 1 1
     * 位相加后 %3 = 0，因此若出现三次，则必然最后都为 0，元素的顺序并不影响计算结果。
     * 而对于单独出现的元素 位中还是原来的值
     * ---
     * 时间复杂度：O(n), 这里元素的位数固定的为 32.
     * 空间复杂度: O(1)
     */
    fun singleNumber2(nums: IntArray): Int {
        var ret = 0
        repeat(32) {
            // 将所有数字的 对应位 相加
            var sum = 0
            nums.forEach { num ->
                // 按位取
                sum += ((num shr it) and 1)
            }
            // 剩余的就是结果在该位上的值。
            // 左移 + 或运算
            if(sum % 3 != 0) {
                ret = ret or (1 shl it)
            }
        }
        return ret
    }

    /**
     * 数字电路
     * 核心就是通过设计一个门电路，一次性对所有位进行求值
     * 从而 节省 元素位数的时间消耗 变为 真正的 O(n)
     *
     * 使用 ab(00, 01, 10) 来表示余数 0, 1, 2
     * 根据每一位变换来，确认真值表 然后推导a, b公式。
     * ab x ab(new)
     * 00 0 00
     * 00 1 01
     * 01 0 01
     * 01 1 10
     * 10 0 10
     * 10 1 00
     *
     * b = ~a & (b ^ x)
     * a = ~b & (a ^ x)
     */
    fun singleNumber(nums: IntArray): Int {
        var a = 0
        var b = 0
        nums.forEach { num ->
            // 先计算 a
            b = a.inv() and (b xor num)
            // 在计算 b
            a = b.inv() and (a xor num)
        }
        return b
    }
}