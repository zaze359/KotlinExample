package com.zaze.kotlin.example.algorithm.n283

fun main() {

    val nums : IntArray = intArrayOf(2, 1, 0, 3, 0, 12, 1)
    // Solution().moveZeroes(nums)
    Solution().moveZeroes2(nums)
    for(num in nums) {
        print("${num} ")
    }
    println()
}

class Solution {
    fun moveZeroes(nums: IntArray): Unit {
        val size = nums.size
        var position = 0 // 记录数组中 待填充非0数据的位置
        // 循环读取数组中的值
        for(num in nums) {
            if(num == 0) {
                // num == 0 忽略不必处理
            } else {
                // 将对应的 非0 数据填充到数组中
                nums[position] = num
                // 指向下一个位置
                position ++
            }
        }
        // 将数组中后面的数据都赋值为0
        for(i in position until size) {
            nums[i] = 0
        }
    }

    fun moveZeroes2(nums: IntArray){
        val size = nums.size
        var position = 0 // 记录数组中 待填充非0数据的位置
        var num : Int
        for(i in 0 until size) {
            num = nums[i]
            if(num == 0) {
                // num == 0 忽略不必处理
                continue
            }
            // 交换
            if(position != i) {
                nums[position] = num
                nums[i] = 0
            }
            position ++ 
        }
    }
}