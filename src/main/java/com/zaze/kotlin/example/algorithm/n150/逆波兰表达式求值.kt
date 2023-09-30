package com.zaze.kotlin.example.algorithm.n150

import java.util.*

/**
 * 正常的算术表达是中序 a+b，逆波兰是后序 ab+, 同时逆波兰不需要括号
 * 输入: 逆波兰表示法的算术表达式
 * 输出: 计算结果
 */
class Solution {
    /**
     * [tokens]: ["2","1","+","3","*"]
     */
    fun evalRPN(tokens: Array<String>): Int {
        val stack = Stack<Int>()
        tokens.forEach {
            when (it) {
                "+" -> {
                    stack.push(stack.pop() + stack.pop())
                }

                "-" -> {
                    stack.push(-stack.pop() + stack.pop())
                }

                "*" -> {
                    stack.push(stack.pop() * stack.pop())
                }

                "/" -> {
                    val first = stack.pop()
                    val second = stack.pop()
                    stack.push(second / first)
                }

                else -> {
                    stack.push(it.toInt())
                }
            }
        }
        return stack.pop()
    }
}