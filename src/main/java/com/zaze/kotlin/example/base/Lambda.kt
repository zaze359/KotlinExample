package com.zaze.kotlin.example.base

// 定义 Lambda 表达式
val sum1: (Int, Int) -> Int = { x: Int, y: Int ->
    x + y
}
val sum2: (Int, Int) -> Int = { x, y ->
    x + y
}
val sum3 = { x: Int, y: Int ->
    x + y
}


//fun foo(int: Int): () -> Unit = {
//    println(int)
//}

fun foo(x: Int): (y: Int) -> Unit = { y ->
    println("foo : ${sum1(x, y)}")
}

fun main() {
    var sum = 0
    listOf(1, 2, 3).forEach {
        sum += it
    }


    //        { x: Int -> println("aaa : $x") }(1)
//        sum(1, 2)
//        sum.invoke(1, 2)
//        arrayOf(1, 2, 3).forEach {
//            //            foo(it).invoke(1)
//            foo(it)(1)
//        }

//        aaa(1, { 1 })
    aaa(1, 1) {
        1
    }
}

fun aaa(a: Int = 1, c: Int, b: () -> Int): Int {
    return a + b()
}


