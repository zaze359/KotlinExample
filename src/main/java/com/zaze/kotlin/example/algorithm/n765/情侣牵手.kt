package com.zaze.kotlin.example.algorithm.n765

/**
 * n 对情侣坐在连续排列的 2n 个座位上
 * 0 ～ n - 1
 * 情侣编号: (0, 1) (2,3) (2n-2, 2n - 1)
 * n是偶数，2 <= n <= 30
 */
class Solution {

    /**
     * 将数组按照2个为一组进行映射，使用数组pair[n][2] 记录当前的配对状态。
     * 此时pair 数组中，每组内部交换一次就能保证当前组配对成功
     * 匹配条件: (first - second == 1) && (cur * 2 == second)
     * 匹配剩下重新组成新的组，原地更新pair即可
     *
     * 遍历
     * 时间复杂度: O(n)
     * 空间复杂度：O(n)
     */
    fun minSwapsCouples(row: IntArray): Int {
        val n = row.size
        if (n <= 2) return 0
        val m = n shr 1
        // 记录配对状态，记录每对中的配对情况, 例如 3, 2, 0, 1
        // pair[i] 表示第 i 对
        // 0: pair[0][0] = 1
        // 1: pair[0][1] = 0
        // 2: pair[1][0] = 3
        // 3: pair[1][1] = 2
        val pairs = Array(m) {
            IntArray(2)
        }
        var a: Int
        var b: Int
        var groupA: Int // a所在组
        var groupB: Int // b所在组
        var i = 0
        // O(n / 2)
        // 遍历，将各个组映射到实际的位置中，并保存另一半所在的实际组。
        while (i < n) {
            a = row[i]
            b = row[i + 1]
            // 组编号
            groupA = a shr 1
            groupB = b shr 1
            // 记录当前的搭配情况
            pairs[groupA][a % 2] = b
            pairs[groupB][b % 2] = a
            i += 2
        }
        var ans = 0
        // O(n/2)
        // 遍历pair ，只要将pair[i][0] 和 pair[i][1] 进行一次交换可以保证 pair[i] 配对成功
        // 配对剩下的两个人暂时形成一对，直接更新pair即可
        for (cur in pairs.indices) {
            val first = pairs[cur][0]
            val second = pairs[cur][1]
            if ((first - second == 1) && (cur * 2 == second)) {
                // 表示已经配对了
                continue
            }
            pairs[cur][0] = cur * 2 + 1
            pairs[cur][1] = cur * 2
            ans++
            // 配对剩下的两个暂时形成一对
            pairs[first / 2][first % 2] = second
            pairs[second / 2][second % 2] = first
        }
        return ans
    }
}