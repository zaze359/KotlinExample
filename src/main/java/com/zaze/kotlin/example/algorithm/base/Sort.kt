package com.zaze.kotlin.example.algorithm.base


object Sort {
    /**
     * 冒泡排序
     * 时间复杂度 O(n^2)：
     *  最好 有序:O(n)
     *  最坏 逆序:O(n^2)
     * 空间复杂度：O(1)
     * [nums]: 待排序数组
     * [compare]: 指定比较方式，默认从小到大 升序输出
     */
    fun bubbleSort(nums: IntArray, compare: (Int, Int) -> Boolean = { f, s -> f > s }): IntArray {
        // 遍历次数，n-1, n-2 ... 1
        // 倒序遍历：表示需要比对的次数
        for (end in (nums.size - 1) downTo 1) {
            var flag = false // 标记是否发生数据交换
            // 顺序遍历：前后相邻两数进行比对
            for (begin in 0 until end) {
                if (compare(nums[begin], nums[begin + 1])) {
                    flag = true
                    // 前一个大于后一个，交换
                    val temp = nums[begin]
                    nums[begin] = nums[begin + 1]
                    nums[begin + 1] = temp
                }
            }
            // 没有数据交换，表示已经有序，可以直接返回
            if (!flag) return nums
        }
        return nums
    }
    //
    //
    //

    /**
     * 插入排序，从小到大 升序输出
     * 时间复杂度 O(n^2):
     *   最好:O(n)
     *   最坏:O(n^2)
     * 空间复杂度 O(1)
     * 相比冒泡排序，它的常量更小，即操作次数更少，所以更快
     */
    fun insertionSort(nums: IntArray): IntArray {
        if (nums.size <= 1) return nums
        for (i in 1 until nums.size) {
            val value = nums[i]
            // 进行向前比较，查找到插入的位置，即 <= value的前一个位置
            // j 指向比较位置
            var j = i - 1
            while (j >= 0) {
                // 若value小于前面的值，则暂时记录 作为插入位置。
                // 同时搬移数据
                if (value < nums[j]) {
                    nums[j + 1] = nums[j]
                } else { // 当前 j位置的值 <= value，跳出循环
                    break
                }
                --j
            }
            // 当前 arrays[j] <= value
            // 插入j的后面
            nums[j + 1] = value
        }
        return nums
    }
    //
    //
    //

    /**
     * 选择排序，从小到大 升序输出
     * 时间复杂度 O(n^2):
     *   最好:O(n)
     *   最坏:O(n^2)
     * 空间复杂度 O(1)
     * 相比插入排序，它是不稳定的排序算法
     */
    fun selectionSort(nums: IntArray): IntArray {
        if (nums.size <= 1) return nums
        for (i in nums.indices) {
            var minIndex = i
            for (j in (i + 1) until nums.size) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j
                }
            }
            // 和最小值进行交换
            val temp = nums[i]
            nums[i] = nums[minIndex]
            nums[minIndex] = temp
        }
        return nums
    }
    //
    //
    //

    // region 归并排序
    /**
     * 归并排序，从小到大 升序输出，不稳定排序算法
     * 时间复杂度 O(nlogn)
     * 空间复杂度 O(n)
     */
    fun mergeSort(nums: IntArray): IntArray {
        if (nums.size <= 1) {
            return nums
        }
        return actualMergeSort(nums, 0, nums.size - 1)
    }
    //
    //
    //

    /**
     * 递归执行
     */
    private fun actualMergeSort(nums: IntArray, start: Int, end: Int): IntArray {
        if (start > end) {
            return intArrayOf()
        }
        if (start == end) {
            return intArrayOf(nums[start])
        }
        val mid = (start + end) / 2
        return merge(actualMergeSort(nums, start, mid), actualMergeSort(nums, mid + 1, end))
    }
    //
    //
    //

    /**
     * 合并两个有序数组
     */
    private fun merge(nums1: IntArray, nums2: IntArray): IntArray {
        if (nums1.isEmpty()) return nums2
        if (nums2.isEmpty()) return nums1
        val retArr = IntArray(nums1.size + nums2.size)
        var p1 = 0
        var p2 = 0
        var num1: Int
        var num2: Int
        while (p1 < nums1.size || p2 < nums2.size) {
            num1 = if (p1 < nums1.size) nums1[p1] else Int.MAX_VALUE
            num2 = if (p2 < nums2.size) nums2[p2] else Int.MAX_VALUE
            retArr[p1 + p2] = if (num1 <= num2) {
                p1++
                num1
            } else {
                p2++
                num2
            }
        }
        return retArr
    }
    //
    //
    // endregion 归并排序

    // region  快速排序
    /**
     * 快速排序，不稳定排序算法
     * 时间复杂度 O(nlogn)
     * 空间复杂度 O(1)
     */
    fun quickSort(nums: IntArray): IntArray {
        return actualQuickSort(nums, 0, nums.size - 1)
    }

    /**
     * 递归执行
     */
    private fun actualQuickSort(nums: IntArray, start: Int, end: Int): IntArray {
        if (start > end) {
            return intArrayOf()
        }
        if (start == end) {
            return intArrayOf(nums[start])
        }
        val pivot = partition(nums, start, end)
        actualQuickSort(nums, start, pivot - 1)
        actualQuickSort(nums, pivot + 1, end)
        return nums
    }

    /**
     * 分区函数，使用交换法处理分区并返回分区点
     */
    private fun partition2(nums: IntArray, start: Int, end: Int): Int {
        // 内部使用类似选择排序的方式进行分区、比对、交换
        // 获取分区操作的分区比较点
        val pivot = makePivot(nums, start, end)
        var i: Int = start // 指向已分区插入节点位置
        for (j in start..end) {
            if (nums[j] <= pivot) {
                // <= pivot，加入到已分区末尾
                // 交换
                swap(nums, i, j)
                if (j != end) {
                    // 不是最后一位，就后移一位
                    // 遍历到最后时，必然等于pivot，此时交换即可，且i就是分区点
                    i++
                }
            }
        }
        return i
    }

    /**
     * 分区函数，移位法
     */
    private fun partition(nums: IntArray, start: Int, end: Int): Int {
        var left = start
        var right = end
        // 选取分区点，暂存了这个值，此时left相当于空（废弃值）
        // 这样我们就有一个位置可以灵活处理，从后面找一个值直接填充而不必交换。
        val pivot = nums[left]
        while (left < right) {
            // left 指向用于填充的空位
            // right 指向右遍历
            // 从后面筛选一个比pivot小的值
            while (left < right && nums[right] > pivot) {
                right--
            }
            // 将right放到left，此时right相当于空位
            // left指向下一个, 下一步考虑 从 left 找一个大值来填充right
            if (left < right) {
                nums[left++] = nums[right]
            }
            // left 指向左遍历点
            // right 指向用于填充的空位
            // 找一个比pivot大的值
            while (left < right && nums[left] < pivot) {
                left++
            }
            // 将 left 放到 right，此时 left 相当于空位
            // right 指向先一个，下一步考虑从 right 找一个小值来填充 left
            if (left < right) {
                nums[right--] = nums[left]
            }
        }
        // 两指针交汇处就是分区点，此时那个位置是一个废弃值，重新赋值为 pivot
        nums[left] = pivot
        return left
    }

    /**
     * 获取分区操作的分区比较点。
     * 1. 直接获取最后一个
     * 2. 三数取中，根据start、mid、end，选取中间大小的数字作为分区点，将中数放到最后即可
     * 3. 随机
     */
    private fun makePivot(nums: IntArray, start: Int, end: Int): Int {
        if (start - end <= 1) {
            return nums[end]
        }
        val mid = (start + end) / 2
        // 1
        if (nums[start] > nums[mid]) {
            swap(nums, start, mid)
        }
        // 2, 此时 start最小
        if (nums[start] > nums[end]) {
            swap(nums, start, end)
        }
        // 若 mid 为中数，所以后end交换
        if (nums[mid] < nums[end]) {
            swap(nums, mid, end)
        }
        return nums[end]
    }

    private fun swap(nums: IntArray, i: Int, j: Int) {
        val temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
    }
    //
    //
    // endregion 快速排序
    /**
     *  计数排序
     *  时间复杂度：O(n)
     *  空间复杂度：这里直接修改了原数组，所以是O(m) m表示数据范围 max - min
     */
    fun countingSort(nums: IntArray): IntArray {
        if (nums.size <= 1) return nums
        // 确定数据范围，即查询最大值
        var max = nums[0]
        var min = nums[0]
        for (i in 1 until nums.size) {
            if (nums[i] > max) {
                max = nums[i]
            }
            if (nums[i] < min) {
                min = nums[i]
            }
        }
        // 映射到数组，[0, max - min]
        // 对于正整数，其实可以直接无脑[0, max]，不过这样不支持负数，也会可能浪费内存
        // 添加这步主要是为了支持负数，同时也较少申请的内存，比如[1000000 ~ 1000100]只要101的长度即可
        //
        max -= min
        // 进行计数
        // (0,1,2,0,1,2,2) 转为 (2,2,3)
        val countArray = IntArray(max + 1)
        nums.forEach {
            // 映射到数组下标
            countArray[it - min]++
        }
        // 计数累加
        // (2,2,3) 转为 (2,4,7)
        for (i in 1 until countArray.size) {
            countArray[i] += countArray[i - 1]
        }
        // (2,4,7) 可以和数组下标边界。
        // 0~1; 2~3; 4~6
        var left = 0
        var right: Int
        for (i in countArray.indices) {
            right = countArray[i] - 1
            for (j in left..right) {
                // 还原时重新加上min即可。
                nums[j] = i + min
            }
            left = right + 1
        }
        // (0,0,1,1,2,2,2)
        return nums
    }
}