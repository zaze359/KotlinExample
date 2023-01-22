package com.zaze.kotlin.example

fun main() {
//    println("sub: ${"11".subSequence(1, "11".length)}")
//    println("sub: ${"112222".take(2)}")
//    "112222".repeat(2)

    println("a: ${splitByOperator("x+5-3+x=6+x-2")}")
}

private fun splitByOperator(list: String) =
    list.split("(?=[+-])".toRegex()).filter { it.isNotEmpty() }

/**
 * 冒泡排序
 */
fun bubbleSort(arrays: IntArray, compare: (Int, Int) -> Boolean = { f, s -> f > s }): IntArray {
    for (end in (arrays.size - 1) downTo 1) {
        for (begin in 0 until end) {
            if (compare(arrays[begin], arrays[begin + 1])) {
                val temp = arrays[begin]
                arrays[begin] = arrays[begin + 1]
                arrays[begin + 1] = temp
            }
        }
    }
    return arrays
}