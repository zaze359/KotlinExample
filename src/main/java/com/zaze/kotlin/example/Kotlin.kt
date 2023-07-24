package com.zaze.kotlin.example


/**
 * Description :
 *
 * @author : ZAZE
 * @version : 2018-12-04 - 0:11
 */

var sss: String? = null
fun main() {
//
//    Lambda.debug()
//    Vararg.debug()
//    Infix.debug()

//    Thread.sleep(1000L)
//    repeat(10, ::doSSS)
    val strList = listOf("1", "1", "1", "1", "1", "1", "1")


    with("") loop@{
        strList.map aa@{aa ->
            println("aa: $aa")
            if(aa === "1") {
                return@loop
            }
        }
    }

    run loop@{
        listOf(1, 2, 3).forEach { // 闭包：访问了 sum
            println("bb: $it")
            for (i in 0 until 3) {
                println("cc: $i")
                break
            }
            if(it == 2) {
                return@loop
            }
        }
    }



//    println(strList.fold(0, { r, t ->
//        println(r)
//        r + t.toInt()
//    }))

//    val set1 = setOf("1", "2")
//    val set2 = setOf("1", "2")
//    println("set1 set2 : ${set1 == set2} ${set1 === set2}")
//
//    println("GsonBuilder A : ${GsonBuilder().create().fromJson("{\"appId\":false}", B::class.java).a}")
//    println("GsonBuilder A : ${GsonBuilder().create().fromJson("{\"appId\":false}", HashMap::class.java)}")

//    // 非常好用的流式 API filter，flat，map 等等
//    val mstrList = strList.filter(h(::g, ::f))
//    println(mstrList)
//    mstrList.forEachIndexed{
//        index,value ->
//        println("$value = ${value.length}")
//    }
//    args.forEach(::println)
//    val p = Test::println
//    val t = Test()
//    args.forEach(t::println)
//    //扩展方法有一个隐含的参数--实例
//    //Kotlin1.1才开始支持
//    args.filter(String::isEmpty)
}

fun doSSS(i: Int) {
    println("s : $i")
    sss = "$i"
    Thread(Runnable {
        println("sss : $sss")
    }).start()
}

//// ------------------------------------------------------
//class Test {
//    fun println(any: Any) {
//        kotlin.io.println(any)
//    }
//}
//
//// ------------------------------------------------------
class MyInt(val value: Int) {
    fun show() {
        println(value)
    }
}
//
//// ------------------------------------------------------
//typealias G = (String) -> Int
//typealias F = (Int) -> Boolean
//typealias H = (String) -> Boolean
//
//
//fun g(s: String) = s.length
//fun f(x: Int) = x % 2 != 0
//
//
//fun h(g: G, f: F): H {
//    return { x -> f(g(x)) }
//}
//
//
//val display: (MyInt) -> Unit = MyInt::show'

data class A(
    var a: Boolean,
    val b: Boolean? = false
)