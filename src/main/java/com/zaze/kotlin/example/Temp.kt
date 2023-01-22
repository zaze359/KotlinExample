package com.zaze.kotlin.example

import java.util.UUID


fun main() {
    val color = Red()
    color.p()
}

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
