package com.zaze.kotlin.example.algorithm.n715

/**
 * Range模块是跟踪数字范围的模块
 * 这个范围是一个半开区间 [left, right)
 */
class RangeModule() {
    //    val map = HashMap<Int, Int>()
    private val tree = SegmentTree(0, 1e9.toInt())
    fun addRange(left: Int, right: Int) {
        tree.update(left, right - 1, 1)
    }

    fun queryRange(left: Int, right: Int): Boolean {
        return tree.query(left, right - 1).apply {
            println("update:($left, $right) $this")
        }
    }

    fun removeRange(left: Int, right: Int) {
        tree.update(left, right - 1, -1)
    }

}

/**
 * Your RangeModule object will be instantiated and called as such:
 * var obj = RangeModule()
 * obj.addRange(left,right)
 * var param_2 = obj.queryRange(left,right)
 * obj.removeRange(left,right)
 */

/**
 * 线段树,可以解决 区间和 问题，支持区间的增删改查
 * 非叶子节点是 它子节点的统计值，根据需求决定表示什么
 * 叶子节点 表示点，例如节点 [0, 0] [1, 1]，存储的是真正的数据。
 * 类似跳表、B+树
 */
class SegmentTree(
    // l,r 表示线段数处理的最大范围。只有知道范围才能执行
    val l: Int, val r: Int
) {
    // 根节点，表示 [0 ~ max] 区间
    private val root = Node(0)

    /**
     * [left]: 更新区间左边界
     * [right]: 更新区间右边界
     * [value]: 更新值
     */
    fun update(left: Int, right: Int, value: Int) {
        update(root, l, r, left, right, value)
    }

    private fun update(node: Node?, start: Int, end: Int, left: Int, right: Int, value: Int) {
        if (node == null) return
        if (left <= start && right >= end) { // 这个更新区间超出范围，那么整个区间都将被覆盖
            node.`val` = value
            node.add = value
            return
        }
        // 查找区间
        val mid = (start + end) shr 1
        // 后续要处理子节点，所以先下推
        // 优先处理子节点，父节点再根据子节点的状态来处理
        pushDown(node, start - mid + 1, end - mid)
        if (left <= mid) { // 左边存在重叠
            update(node.left, start, mid, left, right, value)
        }
        if (right > mid) { // 右边存在重叠
            update(node.right, mid + 1, end, left, right, value)
        }
        // 子节点处理完后，更新父节点
        pushUp(node)
    }

    fun query(left: Int, right: Int): Boolean {
        return query(root, l, r, left, right)
    }

    /**
     * 通过 二分 进行分区查找，最后在将所有和[left, right]区间重合部分的值进行合并
     */
    private fun query(node: Node?, start: Int, end: Int, left: Int, right: Int): Boolean {
        if (node == null) return false
        if (left <= start && right >= end) {
            return node.isCover()
        }
        var ans = true
        val mid = (start + end) shr 1
        // 下推，子节点先执行惰性操作，保证数据正确。
        pushDown(node, start - mid + 1, end - mid)
        if (left <= mid) { // 左边存在重叠
            ans = ans and query(node.left, start, mid, left, right)
        }
        if (right > mid) { // 右边存在重叠
            ans = ans and query(node.right, mid + 1, end, left, right)
        }
        return ans
    }

    /**
     * 向上更新
     * 子节点处理完后，更新父节点的值
     */
    private fun pushUp(node: Node?) {
        node?.`val` = if ((node?.left?.isCover() == true) && (node.right?.isCover() == true)) 1 else 0
    }

    /**
     * 向下更新子节点，子节点不存在时则新建。
     * 同时这里也将处理懒惰标记。
     * [leftNum]: 左子树节点数
     * [rightNum]: 右子树节点数
     */
    private fun pushDown(node: Node?, leftNum: Int, rightNum: Int) {
        if (node == null) return
        if (node.left == null) {
            node.left = Node(node.`val`)
        }
        if (node.right == null) {
            node.right = Node(node.`val`)
        }
        if (node.add == 0) return
        node.left?.let {
            it.`val` = node.add
            it.add = node.add
        }
        node.right?.let {
            it.`val` = node.add
            it.add = node.add
        }
        node.add = 0
    }

    data class Node(
        // <=0 区间不覆盖，> 0表示覆盖
        var `val`: Int,
        var left: Node? = null,
        var right: Node? = null,
        // 懒惰标记, 记录修改操作，表示该节点下的所以子节点都需要执行这个操作
        // 节点执行 childSize * add 次，操作执行后，清除该标记并，自上而下传递。
        var add: Int = 0
    ) {
        fun isCover(): Boolean {
            return `val` > 0
        }
    }
}