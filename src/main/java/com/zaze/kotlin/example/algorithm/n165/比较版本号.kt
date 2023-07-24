package com.zaze.kotlin.example.algorithm.n165

/**
 * 比较版本号
 */
class Solution {
    fun compareVersion(version1: String, version2: String): Int {
//        return compareVersion1(version1, version2)
        return compareVersion2(version1, version2)
    }


    fun compareVersion1(version1: String, version2: String): Int {
        val version1A = version1.split(".").map(::removePreZero).toMutableList()
        val version2A = version2.split(".").map(::removePreZero).toMutableList()
        val offset = version1A.size - version2A.size
        when {
            offset > 0 -> {
                repeat(offset) {
                    version2A.add(0)
                }
            }
            offset < 0 -> {
                repeat(-offset) {
                    version1A.add(0)
                }
            }
            else -> {
            }
        }
        version1A.zip(version2A).onEach {
            val flag = it.first.compareTo(it.second)
            if (flag != 0) {
                return flag
            }
        }.run { return 0 }
    }

    /**
     * 去除前导零
     * 针对非字符 0 并且以0开头才需要处理
     */
    private fun removePreZero(str: String): Int {
        return str.toInt()
    }
        // 双指针
    fun compareVersion2(version1: String, version2: String): Int {
        val len1 = version1.length
        val len2 = version2.length
        var i = 0
        var j = 0
        while (i < len1 || j < len2) {
            var x = 0
            while (i < len1 && version1[i] != '.') {
                x = x * 10 + version1[i].digitToInt()
                i++
            }
            i++
            //
            var y = 0
            while (j < len2 && version2[j] != '.') {
                y = y * 10 + version2[j].digitToInt()
                j++
            }
            j++
            if (x != y) {
                return x.compareTo(y)
            }
        }
        return 0
    }
}