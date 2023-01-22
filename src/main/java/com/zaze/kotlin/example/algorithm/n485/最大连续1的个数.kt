package com.zaze.kotlin.example.algorithm.n485
fun main() {
    val result = Solution().findMaxConsecutiveOnes(intArrayOf(1,1,0,1))
    println("${result}")
}

class Solution {
    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        // 连续1的个数就是 2个0 之间的 数的个数
        // 2个0的位置也表示开区间,例如(1, 3)，区间的长度1就是1的个数
        var first = -1 // 第一个 0的位置
        var end = -1   // 第二个 0的位置
        //
        var maxValue = -1
        //
        var num : Int
        //
        var tmp : Int
        val size = nums.size
        for(i in 0 until size) {
            num = nums[i]
            if(num == 0 ) {
                when {
                    first < 0 -> { // 第1个0
                        first = i
                    }
                    end < 0 -> { // 第二个0
                        end = i
                        maxValue = end - first - 1
                    }
                    maxValue > 0 && maxValue > size - i -> {
                        // 大于剩余的数量 直接返回
                        return maxValue
                    }
                    else -> { // 第三个0
                        tmp = i - end - 1
                        if(tmp > maxValue) {
                            maxValue = tmp
                        }
                        first = end
                        end = i
                    }
                }
                }
        }
        return when {
            first == -1 -> { // 不存在0
                size
            }
            end == -1 -> { // 存在一个 0
                if(first >= size / 2) {
                    first
                } else {
                    size - first - 1
                }
            }
            else -> { // 计算最后一段1的长度
                tmp = size - end - 1
                if(tmp > maxValue) {
                    tmp
                } else {
                    maxValue
                }
            }
        }
    }
}