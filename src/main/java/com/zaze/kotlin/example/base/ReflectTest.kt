package com.zaze.kotlin.example.base

import kotlin.reflect.KMutableProperty1
import kotlin.reflect.KProperty1
import kotlin.reflect.full.memberProperties


class ReflectTest {
    var name: String = "defalut"
}

fun main() {
    val obj = ReflectTest()
    printClass(obj)
    printMembers(obj)
}

fun printClass(obj: Any) {
    println("class is ${obj::class.simpleName}")
}

fun printMembers(obj: Any) {
    // memberProperties 是扩展函数，在反射库中
    obj::class.memberProperties.forEach {
        // 此处为 KProperty1
        // 调用 it.name 获取属性名
        // 调用 it.getter.call(obj) 获取属性值
        println("Property ${it.name} = ${it.getter.call(obj)}")
        if (it.name == "name"
            && it is KMutableProperty1 // 是否 var
            && it.getter.returnType.classifier == String::class // 属性类型 是否为String
            && it.setter.parameters.size == 2 // 一个是对象，一个是需要修改的值
        ) {
            // 调用 it.setter.call(obj) 修改属性值
            it.setter.call(obj, "modified")
            println("Property ${it.name} = ${it.getter.call(obj)}")
        }
    }
}