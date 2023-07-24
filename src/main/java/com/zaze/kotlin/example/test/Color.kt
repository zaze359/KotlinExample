package com.zaze.kotlin.example.test

import java.util.*

interface Color {
    val id: Long
    val color: String
    fun p() {
        println("color: $color")
    }
}

class Red(override val id: Long = UUID.randomUUID().mostSignificantBits) : Color {
    override val color: String
        get() = "red"
}
