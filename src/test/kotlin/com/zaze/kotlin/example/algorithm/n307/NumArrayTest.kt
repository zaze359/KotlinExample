package com.zaze.kotlin.example.algorithm.n307

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class NumArrayTest {

    @Test
    fun sumRange() {
        val numArray = NumArray(intArrayOf(1, 3, 5))
        assertEquals(9, numArray.sumRange(0, 2))
        numArray.update(1, 2)
        assertEquals(8, numArray.sumRange(0, 2))
    }
}