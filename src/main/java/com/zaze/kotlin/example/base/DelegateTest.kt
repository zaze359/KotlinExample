package com.zaze.kotlin.example.delegate

import kotlin.properties.ReadOnlyProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * 委托
 */
fun main() {
    val base = BaseImpl(10)
    val derived = Derived(base)
    derived.print()
    derived.printMessage()
}

interface Base {
    val message: String
    fun print()
    fun printMessage()
}

class BaseImpl(val x: Int) : Base {
    override val message: String
        get() = "BaseImpl message $x"

    override fun print() {
        println("BaseImpl print: $x")
    }

    override fun printMessage() {
        println("BaseImpl printMessage: $message")
    }
}

class Derived(b: Base) : Base by b {
    /**
     *
     */
    override val message: String
        get() = "Derived message"

    var delegate: String by MyDelegate()

    /**
     * 覆盖委托方法
     */
    override fun print() {
        println("Derived print : $delegate")
    }
}

/**
 * 自定义委托
 * val 使用 ReadOnlyProperty 重写 getValue 即可
 * var 使用 ReadWriteProperty 重写 getValue 和 getValue
 */
class MyDelegate : ReadWriteProperty<Derived, String> {
    private var value = "MyDelegate"
    override fun getValue(thisRef: Derived, property: KProperty<*>): String {
        println("MyDelegate getValue:  ${property.name}")
        return ""
    }

    operator fun provideDelegate(thisRef: Derived, property: KProperty<*>): ReadWriteProperty<Derived, String> {
        // 提供委托时 可以做的一些特殊处理，此处就打印以下日志直接返回自身了
        println("MyDelegate provideDelegate: ${property.name}")
        return this
    }

    override fun setValue(thisRef: Derived, property: KProperty<*>, value: String) {
        println("MyDelegate setValue: ${property.name} >> $value")
        this.value = value
    }
}

class Loader {
    operator fun provideDelegate(thisRef: Derived, property: KProperty<*>): ReadOnlyProperty<Derived, String> {
        return MyDelegate()
    }
}
