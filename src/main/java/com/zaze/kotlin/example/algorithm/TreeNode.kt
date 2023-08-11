package com.zaze.kotlin.example.algorithm

import java.util.LinkedList

/**
 * 树节点
 */
open class TreeNode(var `val`: Int) {

    var left: TreeNode? = null
    var right: TreeNode? = null

    companion object {
        private fun createNode(value: Int?): TreeNode? {
            return value?.let {
                TreeNode(it)
            } ?: null
        }

        /**
         * 给定一个数组 构建一颗二叉树
         * [list]: 数组数据
         */
        fun buildTree(list: List<Int?>): TreeNode? {
//            val queue = ArrayDeque<TreeNode?>()
            val queue = LinkedList<TreeNode?>()
            val root = createNode(list[0])?.also {
                queue.add(it)
            }
            var index = 0
            while (index < list.size) {
                val first = queue.poll()
                if (first != null) {
                    index++
                    if (index < list.size) {
                        first.left = createNode(list[index]).also {
                            queue.add(it)
                        }
                    }
                    index++
                    if (index < list.size) {
                        first.right = createNode(list[index]).also {
                            queue.add(it)
                        }
                    }
                }
            }
            return root
        }
    }

    override fun toString(): String {
        return "$`val`,${left?.`val`},${right?.`val`}"
    }

    /**
     * 按层序遍历输出,包括null
     * 广度优先
     */
    fun levelPrint(): String {
        // 用于记录待处理的节点
        val queue = LinkedList<TreeNode?>()
        // 首先添加自己
        queue.add(this)
        // 记录一下 空节点，若队列中都是空节点，那么就不必继续输出了，作用就是过滤末尾的所有空节点输出
        var nullCount = 0
        // 记录输出的节点值
        val outList = ArrayList<Int?>()
        while (queue.isNotEmpty()) {
            val levelSize = queue.size
            if (nullCount == levelSize) {
                // 队列中都是空节点
                break
            }
            repeat(levelSize) {
                // 取出自己，然后将左右节点加入到队列中
                val first = queue.poll()
                var needPrint = true
                // 只要自身不是null, 就添加 左右子节点到队列中
                if (first != null) {
                    queue.add(first.left)
                    queue.add(first.right)
                    if (first.left == null) {
                        nullCount++
                    }
                    if (first.right == null) {
                        nullCount++
                    }
                } else {
                    nullCount--
                }
                outList.add(first?.`val`)
            }
        }
        val builder = StringBuilder()
        outList.forEachIndexed { index, value ->
            when {
                value == null && index == outList.size - 1 -> {
                    // 去除末尾的 NULL
                }

                builder.isEmpty() -> {
                    builder.append("$value")
                }

                else -> {
                    builder.append(",$value")
                }
            }
        }
        return builder.toString()
    }

    /**
     * 按层序遍历输出
     * 广度优先
     */
    fun levelOrder(): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        var levelList = mutableListOf<Int>()
        // 用于记录需要输出的节点
        val queue = LinkedList<TreeNode>()
        // 首先添加自己
        queue.add(this)
        while (queue.isNotEmpty()) {
            val levelSize = queue.size
            // 当前在队列中的就是当前层的节点
            repeat(levelSize) {
                // 取出自己，然后将左右节点加入到队列中
                val first = queue.poll()
                levelList.add(first.`val`)
                // 添加 左右子节点到队列中
                first.left?.let {
                    queue.add(it)
                }
                first.right?.let {
                    queue.add(it)
                }
            }
            result.add(levelList)
            levelList = mutableListOf()
        }
        return result
    }

    /**
     * 前序遍历输出
     */
    fun preorder(): String {
        return when {
            left == null && right == null -> {
                "$`val`"
            }

            else -> {
                "$`val`,${left?.preorder()},${right?.preorder()}"
            }
        }
    }

    /**
     * 中序遍历
     */
    fun inorder(): String {
        return when {
            left == null && right == null -> {
                "$`val`"
            }

            else -> {
                "${left?.inorder()},$`val`,${right?.inorder()}"
            }
        }
    }


    /**
     * 后序遍历
     */
    fun postorder(): String {
        return when {
            left == null && right == null -> {
                "$`val`"
            }

            else -> {
                "${left?.postorder()},${right?.postorder()},$`val`"
            }
        }
    }
}