package com.zaze.kotlin.example.algorithm.n1402

class Solution {

    /**
     * 返回 最大 like-time 系数 总和
     * time[i] * satisfaction[i]
     * 可以按 任意 顺序安排做菜的顺序， 可以舍弃不做某些菜
     *
     * 先按照满意度从小到大排序。那么每做一道 负满意度的菜，都会使得后续 菜 time系数都增加 1,
     * 假设只做 >=0的菜 1x1, 2x2, 3x3
     * 做一道<0的菜时变为 -1x1, 1x2, 2x3, 3x4。
     * 正数部分增加1 + 2 + 3。负数部分同理 -1。
     * 因此 只要负满意度的增长幅度小于正满意度的增长幅度，那么做负满意度的菜就有收益的。
     *
     * 贪心
     * 复杂度取决于排序算法, 使用快排则是如下
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(1)
     */
    fun maxSatisfaction2(satisfaction: IntArray): Int {
        if (satisfaction.isEmpty()) return 0
        val n = satisfaction.size - 1
        // 从大到小排序
        // 表示做了几道菜。
        var time = 0
        // 所有正数和，每做一道 负满意度菜 可以增加一个 完整的正数和
        var sumPositive = 0
        // 某一个时刻负数和，每新做一道负菜，变换量为 之前的负数和 + 新菜的负值
        var sumNavigation = 0
        satisfaction.sort()
        // 倒序处理
        for (i in n downTo 0) {
            val num = satisfaction[i]
            if (num >= 0) {
                sumPositive += num
                time++
            } else {
                // 做这道菜的变换量
                sumNavigation += num
                if (sumNavigation + sumPositive > 0) { // 依然有收益
                    time++
                } else { // 后续负增量过大，不用管了
                    break
                }
            }
        }
        // 倒序遍历，计算总值
        var ret = 0
        repeat(time) {
            ret += satisfaction[n - it] * (time - it)
        }
        return ret
    }

    /**
     * 优化 贪心
     */
    fun maxSatisfaction(satisfaction: IntArray): Int {
        if (satisfaction.isEmpty()) return 0
        // 数和，表示 做一道菜产生的变化量 >0 有收益
        var sum = 0
        // 每做一个道菜，结果变换 sum
        var ret = 0
        satisfaction.sort()
        for (i in satisfaction.size-1 downTo 0) {
            sum += satisfaction[i]
            if(sum > 0) { // 有收益
                ret += sum
            } else {
                break
            }
        }
        return ret
    }
}