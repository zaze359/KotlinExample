package com.zaze.kotlin.example.base


// sum1 和 sum2 是等同的
fun sum1(x: Int, y: Int): Int {
    return x + y
}

fun sum2(x: Int, y: Int) = x + y

class Book(val name: String)

fun main() {
    // 引用函数赋值给函数类型的变量
    val sum: (Int, Int) -> Int = ::sum1
    // 引用构造函数：(String) -> Book
    val newBook = ::Book
    println(newBook("book").name)
    //  Book::name 引用类中成员变量; (Book) -> String
    val bookNames = listOf(Book("book1"), Book("book2"))
        .map(Book::name)
    println(bookNames)


    val bookNames2 = listOf(Book("book1"), Book("book2"))
        .map(fun(book: Book): String {
            return book.name
        })


    val bookNames3 = listOf(Book("book1"), Book("book2"))
        .map { book ->
            book.name
        }

}

