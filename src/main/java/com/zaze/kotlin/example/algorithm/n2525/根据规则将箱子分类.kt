package com.zaze.kotlin.example.algorithm.n2525

class Solution {

    fun categorizeBox(length: Int, width: Int, height: Int, mass: Int): String {
        val isBulky = length >= 10000 || width >= 10000 || height >= 10000 ||
                1L* length * width * height >= 1000000000
        return when {
            isBulky && mass >= 100 -> {
                "Both"
            }
            isBulky -> {
                "Bulky"
            }
            mass >= 100 -> {
                "Heavy"
            }
            else -> {
                "Neither"
            }
        }
    }

}