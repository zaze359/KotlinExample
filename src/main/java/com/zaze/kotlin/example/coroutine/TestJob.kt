package com.zaze.kotlin.example.coroutine

import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun main() = runBlocking{
    val job = launch {
        1
        println("launch job: ${this.coroutineContext[Job]}")
    }
    println("job : $job")
    println("runBlocking job: ${coroutineContext[Job]}")
}