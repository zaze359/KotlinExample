package com.zaze.kotlin.example.delegate

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * 委托
 */
fun main() {
    val b = BaseImpl(10)
    val derived = Derived(b)
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

    val delegate: String by MyDelegate()

    /**
     * 覆盖委托方法
     */
    override fun print() {
        println("Derived print : $delegate")
    }
}

class MyDelegate : ReadOnlyProperty<Derived, String> {
    override fun getValue(thisRef: Derived, property: KProperty<*>): String {
        return "$thisRef >> ${property.name}"
    }

//    operator fun provideDelegate(thisRef: Derived, property: KProperty<*>): ReadOnlyProperty<Derived, T> {
//        checkProperty(thisRef, property.name)         …… // 属性创建
//    }
//
//    operator fun getValue(derived: Derived, property: KProperty<*>): String {
//        return "$derived >> ${property.name}"
//    }
}

class Loader {
    operator fun provideDelegate(thisRef: Derived, property: KProperty<*>): ReadOnlyProperty<Derived, String> {
        return MyDelegate()
    }
}
