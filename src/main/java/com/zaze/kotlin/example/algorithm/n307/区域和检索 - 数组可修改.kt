package com.zaze.kotlin.example.algorithm.n307

/**
 */
class NumArray(nums: IntArray) {
    private val tree: SegmentTree

    init {
        tree = SegmentTree(0, nums.size)
        nums.forEachIndexed { index, i ->
            tree.update(index, index, i)
        }
    }

    /**
     * 更新数组的值
     */
    fun update(index: Int, `val`: Int) {
        tree.update(index, index, `val`)
    }

    /**
     * 返回区间 [left, right] 间的和。
     */
    fun sumRange(left: Int, right: Int): Int {
        return tree.query(left, right)
    }

}

/**
 * Your NumArray object will be instantiated and called as such:
 * var obj = NumArray(nums)
 * obj.update(index,`val`)
 * var param_2 = obj.sumRange(left,right)
 */


/**
 * 线段树,可以解决 区间和 问题，支持区间的增删改查
 * 非叶子节点是 它子节点的统计值，根据需求决定表示什么
 * 叶子节点 表示点，left = right的区间 例如节点 [0, 0] [1, 1]
 * 类似跳表、B+树
 *
 * 时间复杂度:
 */
class SegmentTree(
    // l,r 表示线段数处理的最大范围。只有知道范围才能执行
    val l: Int, val r: Int
) {
    // 根节点，表示 [0 ~ max] 区间
    // 此处用链表实现，节省空间。
    private val root = Node(0)

    /**
     * [left]: 更新区间左边界
     * [right]: 更新区间右边界
     * [value]: 更新值
     */
    fun update(left: Int, right: Int, value: Int) {
        update(root, l, r, left, right, value)
    }

    /**
     * 时间复杂度：O(logn)，不超过树的高度
     * 由于是链表实现，所以需要使用二分的方式，找到位于 [left, right]区间的节点
     * 这里找到最上层的节点即可，同时给这些节点打上惰性标记，记录这些节点的子节点需要执行的操作，避免一次性更新大量的节点。
     * 后续遍历节点时，需要进行的处理：
     * 1. 下推：不存在子节点则添加子节点，根据节点的惰性标记更新左右子节点的值，并给子节点打上惰性标记，暂时不处理子节点下的子节点。
     * 2. 上推：清除节点自身的惰性标记，根据左右子节点的新值重新计算自身的值。
     */
    private fun update(node: Node?, start: Int, end: Int, left: Int, right: Int, value: Int) {
        if (node == null) return
        if (left <= start && right >= end) { // 这个区间包含在更新区间内，这里直接更新为目标值即可，并打上惰性标记
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

    fun query(left: Int, right: Int): Int {
        return query(root, l, r, left, right)
    }

    /**
     * 同更新
     * 使用二分查找，找到位于 [left, right]区间的节点
     * 区别就是 查询不存在更新，所以只需要下推处理惰性标记即可
     *
     * 时间复杂度：O(logn)，不超过树的高度
     */
    private fun query(node: Node?, start: Int, end: Int, left: Int, right: Int): Int {
        if (node == null) return 0
        if (left <= start && right >= end) {
            return node.`val`
        }
        var ans = 0
        val mid = (start + end) shr 1
        // 下推，子节点先执行惰性操作，保证数据正确。
        pushDown(node, start - mid + 1, end - mid)
        if (left <= mid) { // 左边存在重叠
            ans += query(node.left, start, mid, left, right)
        }
        if (right > mid) { // 右边存在重叠
            ans += query(node.right, mid + 1, end, left, right)
        }
        return ans
    }

    /**
     * 向上更新
     * 子节点处理完后，更新父节点的值
     */
    private fun pushUp(node: Node?) {
        node?.`val` = (node?.left?.`val` ?: 0) + (node?.right?.`val` ?: 0)
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
            it.`val` += node.add * leftNum
            it.add = node.add
        }
        node.right?.let {
            it.`val` += node.add * rightNum
            it.add = node.add
        }
        node.add = 0
    }

    data class Node(
        // 记录区间 [left, right] 的和
        var `val`: Int,
        var left: Node? = null,
        var right: Node? = null,
        // 懒惰标记, 记录修改操作，表示该节点下的所以子节点都需要执行这个操作
        // 节点执行 childSize * add 次，操作执行后，清除该标记并，自上而下传递。
        var add: Int = 0
    )
}