package com.zaze.kotlin.example

import java.util.LinkedList
import java.util.Stack
import java.util.concurrent.ConcurrentLinkedQueue
import java.util.concurrent.LinkedBlockingQueue


interface MyQueue {
    fun enqueue(data: Data)
    fun poll(): Data?
}

class MyConcurrentLinkedQueue : MyQueue {
    private val queue = ConcurrentLinkedQueue<Data>()

    override fun enqueue(data: Data) {
        queue.add(data)
    }

    override fun poll(): Data? {
        return queue.poll()
    }
}

/**
 * 阻塞队列方式
 */
class MyLinkedBlockingQueue : MyQueue {
    private val queue = LinkedBlockingQueue<Data>()

    override fun enqueue(data: Data) {
        queue.add(data)
    }

    override fun poll(): Data? {
        return queue.poll()
    }
}

class MyLinkedList : MyQueue {
    private val queue = LinkedList<Data>()

    @Synchronized
    override fun enqueue(data: Data) {
        queue.add(data)
    }

    @Synchronized
    override fun poll(): Data? {
        return queue.poll()
    }
}

class MyStack : MyQueue {
    private val queue = Stack<Data>()

    override fun enqueue(data: Data) {
        queue.add(data)
    }

    override fun poll(): Data? {
        return try {
            queue.pop()
        } catch (e: Throwable) {
            null
        }
    }
}

class Producer {
    fun produce(queue: MyQueue) {
        repeat(100) {
            println("produce: $it")
            queue.enqueue(Data("$it"))
        }
    }
}

class Consumer(val name: String) {
    fun consume(queue: MyQueue) {
        while (true) {
            queue.poll()?.let {
                println(">>> $name consume: ${it.content}")
            }
        }
    }
}

data class Data(val content: String)

fun main() {
//    val queue = MyConcurrentLinkedQueue()
//    val queue = MyLinkedBlockingQueue()
    val queue = MyLinkedList()
//    val queue = MyStack()

    val producer = Producer()
    Thread {
        producer.produce(queue)
    }.start()
    Thread {
        Consumer("1").consume(queue)
    }.start()
    Thread {
        Consumer("2").consume(queue)
    }.start()
//    Thread.sleep(10_000L)
}