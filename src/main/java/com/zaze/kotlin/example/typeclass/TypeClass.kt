package com.zaze.kotlin.example.typeclass

import com.zaze.kotlin.example.typeclass.BookShow.show
import com.zaze.kotlin.example.typeclass.ListFunctor.map
import com.zaze.kotlin.example.typeclass.ListFunctor.show
import com.zaze.kotlin.example.typeclass.ListFunctor.show2


/**
 * 高阶类型： 实质为用一个类型构造一个新的类型  例如  List<T>，可视为传入String类型, 构造出List<String>这个新类型， 同理高阶函数
 *     普通类型  String     kind = type
 *     高阶类型  List<T>    kind = type -> type
 *
 * 高阶类型的语言特性： Typeclass 个人理解 相当于一个特殊接口, 给’类型‘声名一些的行为
 * Kotlin 目前不支持高阶类型 可以使用扩展方实现支持Typeclass
 * 下方的Show<F>, 就是一个Typeclass ，添加了show方法
 *
 * 函子: 高阶类型之间的映射 ????
 */
fun main() {

    val a = { x: (Int) -> (Int) -> Int -> x(1) } // ((Int) -> (Int) -> Int) -> (Int) -> Int
    val b = { x: (Int) -> Int -> x(1) }       // ((Int) -> Int) -> Int
    val c = { c: Int -> c }                  // (Int) -> Int
    val d = { x: Int -> { y: Int -> x + y } }    // (Int) -> (Int) -> Int

//    println("a ${a(b(c))}")
    println("a ${a { (c) }}")
    println("a ${a(d)(2)}")
    println("b ${b({ x -> 10 })}")
    println("b ${b(c)}")
    println("c ${c(10)}")
    println("d ${d(10)(1)}")

    ListFunctor.run {
        println("ListFunctor ${
            Cons(1, Cons(2, Nil)).map {
                it.toString() + "map"
            }
        }")
    }
    println("ListFunctor ${
        Cons(1, Cons2(2)).map {
            it.toString() + "map"
        }
    }")

    Cons(Book("book1"), Cons(Book("book2"), Nil)).show(BookShow)
    Cons(Book("book1"), Cons(Book("book2"), Nil)).show2 {
        it.show()
    }
    BookListShow.run {
        Cons(Book("book1"), Cons(Book("book2"), Nil)).show()
    }
}
// ----------------------------------------------------------------------------

/**
 *  Kind<out F, out A> 为 类型构造器F 应用参数A后产生的类型
 */
interface Kind<out F, out A>

interface Functor<F> {

    fun <A, B> Kind<F, A>.map(f: (A) -> B): Kind<F, B>

    fun <A, B> Kind<F, A>.fold(init: B): ((B, A) -> B) -> B

    fun <A> Kind<F, A>.show(a: Show<A>): String

    fun <A> Kind<F, A>.show2(a: (A) -> String): String

}

sealed class List<out A> : Kind<List.K, A> {
    object K
}

object Nil : List<Nothing>()

data class Cons<A>(val head: A, val tail: List<A>) : List<A>()

data class Cons2<A>(val head: A) : List<A>()


fun <A> Kind<List.K, A>.unwrap(): List<A> = this as List<A>

object ListFunctor : Functor<List.K> {

    override fun <A, B> Kind<List.K, A>.map(f: (A) -> B): Kind<List.K, B> {
        return when (this) {
            is Cons -> {
                val t = this.tail.map(f).unwrap()
                Cons(f(this.head), t)
            }
            is Cons2 -> {
                Cons2(f(this.head))
            }
            else -> Nil
        }
    }

    /**
     * [init] 入参类型为 B
     * @return 返回一个函数 ((B, A) -> B) -> B   此函数的参数为 (B, A) -> B 函数， 返回值类型为 B
     */
    override fun <A, B> Kind<List.K, A>.fold(init: B): ((B, A) -> B) -> B = { f ->
        // 定义 fold0  入参为 一个A类型列表l 和 一个返回值类型B v
        // 若为 Cons 则 将head 和v 作为参数传入 (B, A) -> B 处理 得到一个B类型的新值， 然后将tail 和 生成的新值做为参数递归调用自身
        // 其他类型 则直接返回 v
        fun fold0(l: List<A>, v: B): B {
            return when (l) {
                is Cons -> {
                    fold0(l.tail, f(v, l.head))
                }
                else -> v
            }
        }
        fold0(this.unwrap(), init)
    }

    override fun <A> Kind<List.K, A>.show(a: Show<A>): String {
        val fa = this
        return "[" + ListFunctor.run {
            fa.fold(listOf<String>())() { r, i ->
                r + a.run {
                    i.show()
                }
            }.joinToString()
        } + "]"
    }

    override fun <A> Kind<List.K, A>.show2(a: (A) -> String): String {
        val fa = this
        return "[" + ListFunctor.run {
            fa.fold(listOf<String>())() { r, i ->
                r + a(i)
            }.joinToString()
        } + "]"
    }

}

// ----------------------------------------------------------------------------
// ----------------------------------------------------------------------------

interface Show<F> {
    fun F.show(): String
}

class Book(val name: String)

object BookShow : Show<Book> {

    /**
     * 再BookShow内 所有的Book类型
     */
    override fun Book.show(): String {
        return this.name
    }

}

/**
 * 定义泛型类 ListShow<A>, 输出 A 列表
 * 继承自 Show<Kind<List.K, A>>
 * [a] 参数表示 A 如何输出方式的实现
 */
abstract class ListShow<A>(val a: Show<A>) : Show<Kind<List.K, A>> {
    override fun Kind<List.K, A>.show(): String {
        val fa = this
        return "[" + ListFunctor.run {
            fa.fold(listOf<String>())() { r, i ->
                r + a.run {
                    i.show()
                }
            }.joinToString()
        } + "]"
    }

}

object BookListShow : ListShow<Book>(BookShow)