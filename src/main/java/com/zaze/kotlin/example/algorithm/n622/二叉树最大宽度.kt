package com.zaze.kotlin.example.algorithm.n622

import com.zaze.kotlin.example.algorithm.TreeNode
import java.util.*


class Solution {
    /**
     * 使用广度遍历，记录节点下标 来计算宽度。
     * 宽度 = 当前层最右边下标 - 当前层最左边下标
     */
    fun widthOfBinaryTree(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        var width = 1
//        var levelList = mutableListOf<Int>()
        // 用于记录待处理的节点 和 下标
        val queue = LinkedList<Pair<TreeNode, Int>>()
        // 首先添加自己，初始下标记为 1 方便计算
        // left = 2n, right = 2n + 1;
        queue.add(Pair(root, 1))
        while (queue.isNotEmpty()) {
            val levelSize = queue.size
            // 当前在队列中的就是当前层的节点
            repeat(levelSize) {
                // 取出自己，然后将左右节点加入到队列中
                val pair = queue.poll()
                // 添加 左右子节点到队列中
                pair.first.left?.let {
                    queue.add(Pair(it, pair.second * 2))
                }
                pair.first.right?.let {
                    queue.add(Pair(it, pair.second * 2 + 1))
                }
            }
            // 没有下一层数据了，直接返回
            if (queue.isEmpty()) {
                break
            }
            // 在队列中的都是下一层的数据，因此可以计算下一层的宽度了。
            // 取最大
            width = Math.max(width, queue[queue.size - 1].second - queue[0].second + 1)
        }
        return width
    }
}