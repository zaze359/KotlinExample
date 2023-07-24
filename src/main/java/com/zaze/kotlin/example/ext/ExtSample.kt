package com.zaze.kotlin.example.ext

import com.zaze.kotlin.example.ext.ExtScopeInstance.append


fun main() {
    doExt(todo = {
        println("todo".append(" ext"))
    })
    // 这里调用的是 object 内部的拓展，它的作用域是全局的
    // 若将 object ExtScopeInstance注释则会报错, class内部的拓展仅能在class内访问
    "".append("")
}

fun doExt(todo: ExtScope.() -> Unit) {
    // object 可以直接访问
    ExtScopeInstance.todo()
    // class 需要创建实例访问
    ExtScopeClass().todo()
}

interface ExtScope {
    /**
     * 指定这个 String.doSome的作用域为 ExtScope
     */
    fun String.append(append: String): String
}
object ExtScopeInstance : ExtScope {
    override fun String.append(append: String) = this.let {
        "ExtScopeInstance.append: $it$append"
    }
}

class ExtScopeClass : ExtScope {
    override fun String.append(append: String) = this.let {
        "ExtScopeClass.append: $it$append"
    }
}