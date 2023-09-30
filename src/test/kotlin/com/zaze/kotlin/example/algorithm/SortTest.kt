package com.zaze.kotlin.example.algorithm

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import kotlin.test.assertContentEquals

class SortTest {

    @Test
    fun bubbleSort() {
        assertContentEquals(intArrayOf(1, 2, 3), Sort.bubbleSort(intArrayOf(3, 2, 1)))
        assertContentEquals(
            intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9),
            Sort.bubbleSort(intArrayOf(8, 4, 7, 9, 5, 6, 3, 2, 1))
        )
    }

    @Test
    fun insertionSort() {
        assertContentEquals(intArrayOf(1, 2, 3), Sort.insertionSort(intArrayOf(3, 2, 1)))
        assertContentEquals(
            intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9),
            Sort.insertionSort(intArrayOf(8, 4, 7, 9, 5, 6, 3, 2, 1))
        )
    }

    @Test
    fun selectionSort() {
        assertContentEquals(intArrayOf(1, 2, 3), Sort.selectionSort(intArrayOf(3, 2, 1)))
        assertContentEquals(
            intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9),
            Sort.selectionSort(intArrayOf(8, 4, 7, 9, 5, 6, 3, 2, 1))
        )
    }

    @Test
    fun mergeSort() {
        assertContentEquals(intArrayOf(1, 2, 3), Sort.mergeSort(intArrayOf(3, 2, 1)))
        assertContentEquals(
            intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9),
            Sort.mergeSort(intArrayOf(8, 4, 7, 9, 5, 6, 3, 2, 1))
        )
    }

    @Test
    fun quickSort() {
        assertContentEquals(intArrayOf(1, 2, 3), Sort.quickSort(intArrayOf(3, 2, 1)))
        assertContentEquals(
            intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9),
            Sort.quickSort(intArrayOf(8, 4, 7, 9, 5, 6, 3, 2, 1))
        )
    }

    @Test
    fun countingSort() {
        assertContentEquals(intArrayOf(1, 2, 3), Sort.countingSort(intArrayOf(3, 2, 1)))
        assertContentEquals(
            intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9),
            Sort.countingSort(intArrayOf(8, 4, 7, 9, 5, 6, 3, 2, 1))
        )
        assertContentEquals(
            intArrayOf(-3, -1, 0, 4, 5, 6, 7, 8, 9),
            Sort.countingSort(intArrayOf(8, 4, 7, 9, 5, 6, -3, 0, -1))
        )
    }


}