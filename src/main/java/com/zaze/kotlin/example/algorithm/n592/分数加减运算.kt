package com.zaze.kotlin.example.algorithm.n592

import kotlin.math.abs

class Solution {

    fun fractionAddition(expression: String): String {
        return expression.split("(?=[+-])".toRegex())
            .filter { it.isNotEmpty() }
            .map { fraction ->
                val args = fraction.split("/").filter { it.isNotEmpty() }.map { it.toInt() }
                Pair(args[0], args.takeIf { args.size == 2 }?.get(1) ?: 1)
            }.fold(Expression(0, 1)) { total, p ->
                // 直接通分 将分数相加，不必求最小公倍数
                total.copy(
                    numerator = total.numerator * p.second + p.first * total.denominator,
                    denominator = total.denominator * p.second
                )
            }.simple().toString()
    }

    /**
     * 辗转相除法，求最大公约数
     */
    fun gcd(a: Int, b: Int): Int {
        var (big, small) = if (a > b) a to b else b to a

        while (small != 0) {
            val temp = small
            small = big % small
            big = temp
        }
        return big
    }

    private fun Expression.simple(): Expression {
        val gcd = gcd(abs(this.numerator), this.denominator)
        return this.copy(numerator = this.numerator / gcd, denominator = this.denominator / gcd)
    }

    data class Expression(val numerator: Int, val denominator: Int) {

        override fun toString(): String {
            return "$numerator/$denominator"
        }
    }
}