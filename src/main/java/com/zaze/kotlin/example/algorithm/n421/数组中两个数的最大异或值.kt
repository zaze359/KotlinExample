package com.zaze.kotlin.example.algorithm.n421

class Solution {
    /**
     * Int 32位，高位符合，0～30 表示数字，
     * a ^ b = x，那么 a = x ^ b
     */
    fun findMaximumXOR(nums: IntArray): Int {
        // 异或的结果，一位位处理
        var max = 0
        val tempSet = HashSet<Int>()
        // 从高位开始判断
        for (i in 30 downTo 0) {
            tempSet.clear()
            nums.forEach {
                // max = num[i] >> i ^ num[j] >> i
                // 因此 num[i] >> i = max ^ num >> j
                tempSet.add(it shr i)
            }
            // 假设当前位异或结果为 1.
            max = (max shl 1) + 1
            // 检查是否存在满足条件的组合，并且依然符合前几个高位的
            var found = false
            run find@{
                nums.forEach {
                    if (tempSet.contains(max xor (it shr i))) {
                        found = true
                        return@find
                    }
                }
            }

            if (!found) { // 找不到满足前置条件，并且当前位能为1的组合
                max -= 1
            }
        }
        return max
    }
}