package com.zaze.kotlin.example.algorithm.n2

import com.zaze.kotlin.example.algorithm.ListNode

/**
 * 两个非空链表，表示两个非负整数，内部数字 逆序 排列。
 * 输出相同格式的 两数之和。
 */
class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        return when {
            l1 == null -> { // l1比较短，直接拼接即可
                l2
            }

            l2 == null -> { // l1 比较长，特殊处理一下 等于10的情况
                if (l1.`val` == 10) {
                    val newNode = ListNode(0)
                    // 再计算一次下一位
                    newNode.next = addTwoNumbers(l1.next, ListNode(1))
                    newNode
                } else {
                    l1
                }
            }

            else -> {
                val value = l1.`val` + l2.`val`
                val newNode: ListNode
                if (value < 10) {
                    newNode = ListNode(value)
                    newNode.next = addTwoNumbers(l1.next, l2.next)
                } else {
                    newNode = ListNode(value % 10)
                    if (l1.next == null) {
                        l1.next = ListNode(1)
                    } else { // 这里直接 + 1，最多等于10，不会超过10，下次循环再处理
                        l1.next?.`val` = (l1.next?.`val` ?: 0) + 1
                    }
                    // 递归相加下一个数
                    newNode.next = addTwoNumbers(l1.next, l2.next)
                }
                newNode
            }
        }
    }
}

