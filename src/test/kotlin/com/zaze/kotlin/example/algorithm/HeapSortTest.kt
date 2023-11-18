package com.zaze.kotlin.example.algorithm

import com.zaze.kotlin.example.algorithm.base.HeapSort
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class HeapSortTest {

    @Test
    fun insert() {
        println("------------- insert")
        val array = arrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6)
        val heap = HeapSort(array.size)
        array.forEach {
            heap.insert(it)
        }
        val ret = IntArray(heap.count)
        repeat(heap.count) {
            ret[it] = heap.getTop()
            heap.removeTop()
        }
        assertContentEquals(intArrayOf(6, 5, 5, 4, 3, 3, 2, 2, 1), ret)
    }

    @Test
    fun sort() {
        println("------------- sort")
        val heap = HeapSort(intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6))
        assertContentEquals(intArrayOf(1, 2, 2, 3, 3, 4, 5, 5, 6), heap.sorted())
    }
}