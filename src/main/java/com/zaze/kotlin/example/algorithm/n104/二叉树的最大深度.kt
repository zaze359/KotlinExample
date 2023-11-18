package com.zaze.kotlin.example.algorithm.n104

import com.zaze.kotlin.example.algorithm.base.TreeNode

class Solution {
    /**
     * 深度优先搜索
     */
    fun maxDepth(root: TreeNode?): Int {
        if(root == null) {
            return 0
        }
        // 存在子节点，深度 + 1
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1
    }
}