package com.zaze.kotlin.example.algorithm.n2003

class Solution {
    /**
     *  parents[i]: 记录树中节点i的父节点，
     *  nums[i]: 表示节点i的基因值,基因值互不相同
     *  ans[i]: 已节点i为根的子树 缺失的最小基因值 。
     *
     *  节点子树 缺失的最小值基因值
     *  - 子树中的基因值不包含1：那么一定是 1
     *  - 包含1：子树中查找最小基因值
     */
    fun smallestMissingValueSubtree(parents: IntArray, nums: IntArray): IntArray {
        val n = parents.size
        val ans = IntArray(n) {
            1
        }
        // 首先找到为 基因值 为 1 的节点。
        var node = -1
        // 记录节点的所有子节点
        val children = Array<MutableList<Int>>(n) {
            ArrayList()
        }
        for (i in nums.indices) {
            if (nums[i] == 1) { // 找到 1 节点了
                node = i
            }
            children[parents[i].coerceAtLeast(0)].add(i)
        }
        if (node < 0) { // 没有 1 的节点
            return ans
        }
        // 记录基因序列
        val geneSet = HashSet<Int>()
        val visited = BooleanArray(n) // 标记是否已经访问过
        //
        var temp = 1
        // dfs 遍历
        while (node != -1) {
            dfs(node, nums, children, geneSet, visited)
            while (geneSet.contains(temp)) {
                temp++
            }
            ans[node] = temp
            node = parents[node]
        }
        return ans
    }

    /**
     * 将子树的都添加到的基因序列  geneSet中
     */
    private fun dfs(
        node: Int,
        nums: IntArray,
        children: Array<MutableList<Int>>,
        geneSet: HashSet<Int>,
        visited: BooleanArray
    ) {
        if (visited[node]) { // 所在的子树一定已经处理过了
            return
        }
        visited[node] = true
        geneSet.add(nums[node])
        for (child in children[node]) {
            dfs(child, nums, children, geneSet, visited)
        }
    }
}