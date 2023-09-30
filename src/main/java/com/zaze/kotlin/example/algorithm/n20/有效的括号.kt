package com.zaze.kotlin.example.algorithm.n20

import java.util.Stack

/**
 * '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效
 */
class Solution {

    /**
     * 顺序遍历字符
     * 若是有效的括号，当出现右括号时,那么前一个字符必然是对应的左括号，如果我们去除这匹配的一对，后续的字符也根据前面的规律进行处理，最后应该得到一个空字符。
     * 所以可以利用栈来实现
     * 1. 左括号加入到栈中
     * 2. 是右括号就取出栈顶，当栈顶是对应的左括号时表示成对。
     *
     */
    fun isValid(s: String): Boolean {
        // 奇数，直接返回
        if (s.length % 2 == 1) return false
        //
        val stack = Stack<Char>()
        s.forEach {
            when {
                it == '(' || it == '[' || it == '{' -> { // 遇到左括号加入到栈中
                    stack.push(it)
                }

                stack.isEmpty() -> return false
                it == ')' -> {
                    if (stack.pop() != '(') return false
                }

                it == ']' -> {
                    if (stack.pop() != '[') return false
                }

                it == '}' -> {
                    if (stack.pop() != '{') return false
                }

                else -> return false
            }
        }
        // 遍历结束后，栈中应该为空才符合
        return stack.isEmpty()
    }
}