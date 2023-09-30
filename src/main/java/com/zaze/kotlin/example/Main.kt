package com.zaze.kotlin.example

import com.zaze.kotlin.example.test.Red


class A1 {
    var a = 0
    fun a() {
        Runnable { a = 4 }
        Runnable { a = 4 }.run()
        Runnable { a = 4 }.run()
        Runnable { a = 4 }.run()
        b({})
    }


    fun b(b: ()-> Unit) {

    }
}

fun main() {
//    println("sub: ${"11".subSequence(1, "11".length)}")
//    println("sub: ${"112222".take(2)}")
//    "112222".repeat(2)

//    println("a: ${splitByOperator("x+5-3+x=6+x-2")}")

//    println("ssr+: ${avg(55, 20, 7)}")
//    println("ur: ${avg(65, 16, 6)}")
//    println("ur+: ${avg(65, 16, 6)}")
//    println("scrolls: ${8 / avg(65, 16, 6)}")
//    println("scrolls: ${8 / avg(55, 20, 7)}")

//    println("char a: " + 'a'.code)
//    println("char b: " + 'b'.code)
//    println("aaaa: ${aaa(2, 3)}")

//    repeat(10) {
//        println("repeat: $it start")
//        if(it == 2) return@repeat
//        println("repeat: $it end")
//    }

    var a = 2
    object : Runnable {
        override fun run() {
            a = 3
        }
    }

//    val result = Sort.bubbleSort(intArrayOf(6, 3, 2, 4, 5, 1))

//    val color = Red()
//    color.p()
}

// 快速求幂测试
fun aaa(a: Int, n: Int): Int {
    var indexNum = a // 底数
    var pow = n // 幂次
    var ret = 1 // 结果
    while (pow > 0) {
        if (pow and 1 == 1) {
            // 奇数表示多出一个 indexNum，单独 和之前的结果 乘算一下
            ret = ret * indexNum
            println("ret: $ret")
        }
        // 每次将 幂次/2
        pow = pow shr 1
        // 将底数平方一下
        // 2n = 2(n/2 + n/2) = 2(n/2) * 2(n/2)
        indexNum *= indexNum
    }
    return ret
}

private fun avg(a: Int, b: Int, c: Int): Float {
    val s = a * b * c
    return (5 * s / a + 2 * s / b + s / c).toFloat() / s
}

private fun splitByOperator(list: String) =
    list.split("(?=[+-])".toRegex()).filter { it.isNotEmpty() }
