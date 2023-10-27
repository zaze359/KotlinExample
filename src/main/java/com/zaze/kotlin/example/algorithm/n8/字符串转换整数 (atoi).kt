package com.zaze.kotlin.example.algorithm.n8

/**
 * 字符串转换整数
 */
class Solution {


    /**
     * DFA 自动机
     */
    fun myAtoi(s: String): Int {
        val automaton = Automaton()
        run loop@{
            s.forEach {
                if (!automaton.atoi(it)) {
                    return@loop
                }
            }
        }
        return automaton.get()
    }

}

private class Automaton {
    private var state: State = State.Start
    private var sign = 1
    private var num = 0L

    fun get(): Int {
        return sign * num.toInt()
    }

    fun atoi(c: Char): Boolean {
        val newState = state.update(dealChar(c))
        when (newState) {
            is State.Signed -> {
                sign = newState.sign
            }

            is State.Num -> {
                num = num * 10 + newState.num
                if (num > Int.MAX_VALUE) {
                    num = if(sign > 0) Int.MAX_VALUE.toLong() else Int.MAX_VALUE + 1L
                    state = State.End
                    return false
                }
            }

            else -> {
            }
        }
        state = newState
        return true
    }

    private fun dealChar(c: Char): State {
        return when (c) {
            ' ' -> {
                State.Start
            }

            '+' -> {
                State.Signed(1)
            }

            '-' -> {
                State.Signed(-1)
            }

            in '0'..'9' -> {
                State.Num(c - '0')
            }

            else -> {
                State.End
            }
        }
    }

    sealed interface State {
        /**
         * 状态变化方程
         */
        fun update(next: State): State

        /**
         * 开始
         */
        object Start : State {
            override fun update(next: State): State {
                return when (next) {
                    Start -> {
                        Start
                    }

                    is Signed -> {
                        next
                    }

                    is Num -> {
                        next
                    }

                    End -> {
                        End
                    }
                }
            }
        }

        /**
         * 符号
         */
        data class Signed(val sign: Int) : State {
            override fun update(next: State): State {
                return when (next) {
                    Start -> {
                        End
                    }

                    is Signed -> {
                        End
                    }

                    is Num -> {
                        next
                    }

                    End -> {
                        End
                    }
                }
            }
        }

        /**
         * 数字
         */
        data class Num(val num: Int) : State {
            override fun update(next: State): State {
                return when (next) {
                    Start -> {
                        End
                    }

                    is Signed -> {
                        End
                    }

                    is Num -> {
                        next
                    }

                    End -> {
                        End
                    }
                }
            }
        }

        /**
         * 结束
         */
        object End : State {
            override fun update(next: State): State {
                return End
            }
        }
    }
}