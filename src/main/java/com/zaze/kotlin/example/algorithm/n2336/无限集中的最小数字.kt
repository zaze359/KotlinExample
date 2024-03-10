package com.zaze.kotlin.example.algorithm.n2336

import java.util.TreeSet

/**
 * 无限集，元素不可重复。
 * TreeSet：有序，不可重复，红黑树，基于Treemap实现
 */
class SmallestInfiniteSet() {
    // 记录无限集的最小值
    var topNum = 1

    // 记录添加的值, 这里的值一定是小于topNum的
    var set = TreeSet<Int>()


    /**
     * 空间复杂度，O(k)，不超过操作次数
     * O(logm), m是 set的长度， 不超过操作次数
     */
    fun popSmallest(): Int {
        return if (set.isNotEmpty()) { // 去除添加队列中的最小值。
            set.pollFirst()!!
        } else {
            val num = topNum
            topNum++
            num
        }
    }

    fun addBack(num: Int) {
        if (num < topNum) { // 值不存在
            set.add(num)
        }
        // 当 set 数量过多时，尝试将元素恢复回无限集中
//        var last = set.pollLast()
//        while (last == topNum - 1) {
//            set.remove(last)
//            topNum--
//            last = set.pollLast()
//        }
    }

}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * var obj = SmallestInfiniteSet()
 * var param_1 = obj.popSmallest()
 * obj.addBack(num)
 */