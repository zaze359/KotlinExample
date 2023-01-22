package com.zaze.kotlin.example.coroutine

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun main() = runBlocking{
    val job = launch {
        1
    }
}