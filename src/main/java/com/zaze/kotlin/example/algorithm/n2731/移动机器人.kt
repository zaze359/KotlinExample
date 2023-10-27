package com.zaze.kotlin.example.algorithm.n2731

/**
 * 机器人分布在一条无限长的数轴上, 用下标从 0 开始的整数数组 nums 表示
 * 指令字符串 s，L 向左，R向右
 * - 机器人相撞后就改变移动方向
 *   这里可以认为是穿透，机器人发生了交换。
 *   同时这里也限制了 最终结果应该是 左小右大，升序排列
 *
 *
 * 求 d秒后所有机器人间 两两距离之和
 *
 */
class Solution {
    companion object {
        private const val MOD = 1000000007
    }

    fun sumDistance(nums: IntArray, s: String, d: Int): Int {
        val n = nums.size
        val tempNums = LongArray(n)
        s.toCharArray().forEachIndexed { index, c ->
            tempNums[index] = if (c == 'R') {
                nums[index] + d * 1L
            } else {
                nums[index] - d * 1L
            }
        }
        var ret = 0L
        tempNums.sort()
        // 例如(1, 3, 5, 7) 长度 n, 那么 nums[i - 1] ~ nums[i] 会计算几次？
        // n = 4
        // 若 i = 1；(1, 3) 这段距离会被 [1,3] [1,5] [1,7]  这些计算， 3 次 。
        // 若 i = 2; (3,5) 会被 [1, 5], [1,7], [3,5], [3, 7] ， 4次
        // 若 i = 3; (5,7) 会被 [1, 7], [3,7], [5,7] , 3次
        // 规律就是 [0 ~ i) 这 i个数字 和 [i, n) 间的组合。即 i * (n - i)
        for (i in 1 until n) {
            ret += (tempNums[i] - tempNums[i - 1]) * (n - i) % MOD * i % MOD
            ret %= MOD
        }
        return (ret % MOD).toInt()
    }
}