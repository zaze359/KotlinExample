package com.zaze.kotlin.example.algorithm.n715

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import kotlin.test.BeforeTest

class RangeModuleTest {

    @Test
    fun queryRange() {
        val rangeModule = RangeModule()
        rangeModule.addRange(10, 20)
        rangeModule.removeRange(14, 16)
        assertTrue(rangeModule.queryRange(10, 14))
        assertFalse(rangeModule.queryRange(13, 15))
        assertTrue(rangeModule.queryRange(16, 17))

        rangeModule.addRange(17, 90)
        rangeModule.removeRange(26, 64) // 26 ~ 37
        rangeModule.addRange(38, 87)
        assertTrue(rangeModule.queryRange(41,84))
        assertTrue(rangeModule.queryRange(19,21))
        assertFalse(rangeModule.queryRange(23,30))
        assertFalse(rangeModule.queryRange(18,56))
        assertFalse(rangeModule.queryRange(23,39))
        assertFalse(rangeModule.queryRange(29,95))
    }
}