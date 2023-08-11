package com.zaze.kotlin.example.algorithm.n104

import com.zaze.kotlin.example.algorithm.TreeNode

class Solution {
    fun maxDepth(root: TreeNode?): Int {
        if(root == null) {
            return 0
        }
        val curMax = Math.max(maxDepth(root?.left), maxDepth(root?.right)) + 1

        var temp = root
        var deep = 0
        while(temp?.left != null || temp?.right != null ) {
            temp
        }

        return curMax
    }
}