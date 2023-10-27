package com.zaze.kotlin.example.algorithm.n2512

import java.util.*
import kotlin.Comparator
import kotlin.collections.HashMap

class Solution {
    /**
     * 哈希表
     * [positive_feedback]: 正面评语, 3分
     * [negative_feedback]: 负面评语, -1 分
     * [report]: 学生评语
     * [student_id]: 学生id
     * 求 前 k名
     */
    fun topStudents(
        positive_feedback: Array<String>,
        negative_feedback: Array<String>,
        report: Array<String>,
        student_id: IntArray,
        k: Int
    ): List<Int> {
        val map = HashMap<String, Int>()
        positive_feedback.forEach {
            map[it] = 3
        }
        negative_feedback.forEach {
            map[it] = -1
        }
        var tempScore: Int
        // 保存学生id 以及 对应的评分
        val tempArray = Array(student_id.size) {
            IntArray(2)
        }
        for (i in report.indices) {
            tempScore = 0
            report[i].split(" ").forEach { word ->
                tempScore += map[word] ?: 0
            }
            tempArray[i] = intArrayOf(tempScore, student_id[i])
        }
        tempArray.sortWith { a, b ->
            if (a[0] == b[0]) { // 分数相同
                a[1] - b[1] // stdId升序排列
            } else { // 分数降序排序
                b[0] - a[0]
            }
        }
        val ret = ArrayList<Int>()
        for (i in 0 until k) {
            ret.add(tempArray[i][1])
        }
        return ret
    }
}