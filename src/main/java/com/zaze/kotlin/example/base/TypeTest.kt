package com.zaze.kotlin.example.base


fun main() {
//    println("type: ${getType<String>()}")

    var dest = arrayOfNulls<Number>(3)
    val src = arrayOf(1.0, 2.0, 3.0)
    copyIn(dest, src)
    copyOut(dest, src)
}

// ------------------------------------
@Deprecated(message = "废弃描述", ReplaceWith("使用xxx替代"), level = DeprecationLevel.ERROR)
inline fun <reified T> getType(): Class<T> {
    return T::class.java
}

// ------------------------------------
open class Fruit(val weight: Double)

// 约束范型T必须为 Fruit 的子类
class FruitPlate<T : Fruit>(val t: T)
interface Ground
class Watermelon(weight: Double) : Fruit(weight), Ground

// 约束 可以切长在地上的水果
fun <T> cut(t: T) where T : Fruit, T : Ground {}

// ------------------------------------
// 逆变；
// 此处 T 是Double
// <in T> 表示接收可以接收 Double的父类， Array<Number> 是 Array<Double> 的子类
inline fun <reified T> copyIn(dest: Array<in T>, src: Array<T>) {
    src.forEachIndexed { index, t ->
        dest[index] = t
    }
//    // 由于 in 修饰，此处时无法读取到正确的数值的，返回的是 Any?
//    val a: T = dest[0]
//    src[0] = a
    println("copyIn: ${T::class.java}")
}

// 协变；
// 此处 T 是Number
// <out T> 表示接收可以接收 Number 的子类，Array<Number> 是 Array<Double> 的父类
inline fun <reified T> copyOut(dest: Array<T>, src: Array<out T>) {
    src.forEachIndexed { index, t ->
        dest[index] = t
    }
//    val a:T = dest[0]
//    // 由于 out 修饰，此处无法赋值
//    src[0] = a
    println("copyOut: ${T::class.java}")
}

// ------------------------------------

open class Animal

class Cat : Animal()

class Dog : Animal()
// ------------------------------------