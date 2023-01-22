package com.zaze.kotlin.example.base

fun main() {
    var i = 0

    println(
        "let return ${
            i.let {
                println("let it: $it")
                "let"
            }
        }"
    )
    println(
        "run return ${
            i.run {
                println("run this: $this")
                "run"
            }
        }"
    )
    println(
        "apply return ${
            i.apply {
                println("apply this: $this")
                // 此处的返回值并不会使用，
                // 内部源码：return this
//                "apply"
            }
        }"
    )
}


abstract class BaseSingleton<in P, out T> {
    @Volatile
    private var instance: T? = null

    //               变化在这里，函数类型的属性
    //                  ↓              ↓
    protected abstract val creator: (P) -> T

    fun getInstance(param: P): T =
        instance ?: synchronized(this) {
            instance ?: creator(param).also { instance = it }
        }
}


class PersonManager private constructor(name: String) {
    companion object : BaseSingleton<String, PersonManager>() {
//        override val creator = { name: String ->
//            PersonManager(name)
//        }
        override val creator = ::PersonManager
    }
}