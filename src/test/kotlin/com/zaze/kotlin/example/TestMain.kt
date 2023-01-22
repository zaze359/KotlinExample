package com.zaze.kotlin.example

import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

class TestMain {

    @Test
    fun testBubbleSort() {
        val result = bubbleSort(intArrayOf(6, 3, 2, 4, 5, 1))
        assertContentEquals(intArrayOf(1, 2, 3, 4, 5, 6), result)

        assertContentEquals(
            intArrayOf(6, 5, 4, 3, 2, 1),
            bubbleSort(arrays = intArrayOf(6, 3, 2, 4, 5, 1), compare = { f, s ->
                f < s
            })
        )
    }

}