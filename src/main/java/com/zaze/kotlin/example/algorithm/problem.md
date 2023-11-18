# 习题分类

## 数组

* [有序数组的平方](https://leetcode.cn/problems/squares-of-a-sorted-array/description/)
    * 双指针
* [合并两个有序数组](https://leetcode.cn/problems/merge-sorted-array/)
    * 双指针尾遍历
* [多数元素](https://leetcode.cn/problems/majority-element/description/)
* [缺失的第一个正数](https://leetcode.cn/problems/first-missing-positive/)
    * 哈希表
    * 置换
* [数组中的第K个最大元素](https://leetcode.cn/problems/kth-largest-element-in-an-array/description/)
    * 快速排序
    * 堆排序
* [移除元素](https://leetcode.cn/problems/remove-element/description/)
    * 双指针
* [移动机器人](https://leetcode.cn/problems/movement-of-robots/description/)
    * 排序 + 贡献法
* [奖励最顶尖的 K 名学生](https://leetcode.cn/problems/reward-top-k-students/description/)
    * 哈希表
* [找出数组的串联值](https://leetcode.cn/problems/find-the-array-concatenation-value/description/)
    * 双指针
* [删除有序数组中的重复项](https://leetcode.cn/problems/remove-duplicates-from-sorted-array/description/)
    * 顺序遍历 + 移位
    * 双指针
* [删除有序数组中的重复项 II](https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/description/)
    * 顺序遍历 + 移位
* [避免洪水泛滥](https://leetcode.cn/problems/avoid-flood-in-the-city/description/)
    * 哈希表 + 查询
* [轮转数组](https://leetcode.cn/problems/rotate-array/description/)
    * 取模 + 位移 + 交换
    * 额外数组 + 赋值
* [同积元组](https://leetcode.cn/problems/tuple-with-same-product/description/)
    * 哈希表 + 组合
* [做菜顺序]()
    * 排序 + 动态规划
    * 排序 + 贪心
* [H 指数](https://leetcode.cn/problems/h-index/solutions/869042/h-zhi-shu-by-leetcode-solution-fnhl/)
    * 排序
    * 计数排序
    * 二分搜索
* [数组中两个数的最大异或值](https://leetcode.cn/problems/maximum-xor-of-two-numbers-in-an-array/)
    * 哈希表 + 位运算
* [K 个元素的最大和](https://leetcode.cn/problems/maximum-sum-with-exactly-k-elements/description/)
  * 贪心 + 等差数列求和

---

## 链表

* [环形链表](https://leetcode.cn/problems/linked-list-cycle/)
    * 哈希表
    * 快慢指针
* [反转链表](https://leetcode.cn/problems/UHnkqh/)
* [链表的中间节点](https://leetcode.cn/problems/middle-of-the-linked-list/)
    * 快慢指针
* [合并两个有序链表](https://leetcode.cn/problems/merge-two-sorted-lists/)
* [合并 K 个升序链表](https://leetcode.cn/problems/merge-k-sorted-lists/)
    * 暴力遍历
    * 分治
    * 最小堆/优先级队列

## 栈

* [有效的括号](https://leetcode.cn/problems/valid-parentheses/)
* [最长有效的括号](https://leetcode.cn/problems/longest-valid-parentheses/)
* [逆波兰表达式求值](https://leetcode.cn/problems/evaluate-reverse-polish-notation/description/)

## 队列

* [设计循环队列](https://leetcode.cn/problems/design-circular-queue/)
* [设计循环双端队列](https://leetcode.cn/problems/design-circular-deque/)
* [滑动窗口最大值](https://leetcode.cn/problems/sliding-window-maximum/)
    * 单调队列
    * 大顶堆(优先级队列)

---

# 堆

* [从数量最多的堆取走礼物](https://leetcode.cn/problems/take-gifts-from-the-richest-pile/description/)
    * 大顶堆(优先级队列)

---

## 树

* [二叉树的层序遍历](https://leetcode.cn/problems/binary-tree-level-order-traversal/description/)
    * BFS
* [二叉树的右视图](https://leetcode.cn/problems/binary-tree-right-side-view/description/)
    * BFS/DFS
* [二叉树的层平均值](https://leetcode.cn/problems/average-of-levels-in-binary-tree/description/)
    * BFS/DFS
* [二叉树的锯齿形层序遍历](https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/description/)
    * BFS
* [二叉树最大宽度](https://leetcode.cn/problems/maximum-width-of-binary-tree/)
    * BFS
* [二叉树的最大深度](https://leetcode.cn/problems/maximum-depth-of-binary-tree/)
    * DFS
* [判断是不是平衡二叉树](https://leetcode.cn/problems/ping-heng-er-cha-shu-lcof/)
* [实现 Trie (前缀树) ](https://leetcode.cn/problems/QC3q1f/)
* [单词替换](https://leetcode.cn/problems/replace-words/)
    * 构建 Trie 树
* [翻转二叉树](https://leetcode.cn/problems/invert-binary-tree/description/)
    * BFS/DFS
* [验证二叉搜索树](https://leetcode.cn/problems/validate-binary-search-tree/description/)
    * 中序遍历
* [路径总和](https://leetcode.cn/problems/path-sum/description/)
    * BFS/DFS

## 线段树(区间问题)

* [Range 模块](https://leetcode.cn/problems/range-module/description/)
    * 有序集合TreeMap + 二分查询
    * 线段树
* [区域和检索 - 数组可修改](https://leetcode.cn/problems/range-sum-query-mutable/description/)
    * 线段树
    * 分块处理

---

## 图

* [岛屿数量](https://leetcode.cn/problems/number-of-islands/description/)
    * BFS/DFS
    * 并查集
* [有效的数独](https://leetcode.cn/problems/valid-sudoku/description/)
    * 遍历 + 计数。
* [统计无向图中无法互相到达点对数](https://leetcode.cn/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/description/)
    * 并查集
    * 深搜
* [参加会议的最多员工数](https://leetcode.cn/problems/maximum-employees-to-be-invited-to-a-meeting/description/)
    * 拓扑排序 + 动态规划
* [逃离火灾](https://leetcode.cn/problems/escape-the-spreading-fire/description/)
    * BFS
    * 二分
* [阈值距离内邻居最少的城市](https://leetcode.cn/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/description/)
  * Dijkstra，单源最短路径 
  * Floyd

---

## 递归

* [斐波那契数列](https://leetcode.cn/problems/fei-bo-na-qi-shu-lie-lcof/)
* [掷骰子等于目标和的方法数](https://leetcode.cn/problems/find-the-punishment-number-of-an-integer/description/)
    * DFS

## 贪心

* [最小和分割](https://leetcode.cn/problems/split-with-minimum-sum/description/)

## 动态规划

* [斐波那契数列](https://leetcode.cn/problems/fei-bo-na-qi-shu-lie-lcof/)
* [最长有效的括号](https://leetcode.cn/problems/longest-valid-parentheses/)
* [正则表达式匹配](https://leetcode.cn/problems/regular-expression-matching/)
* [最小路径和](https://leetcode.cn/problems/minimum-path-sum/description/)
* [零钱兑换](https://leetcode.cn/problems/coin-change/description/)
* [乘积最大子数组](https://leetcode.cn/problems/maximum-product-subarray/description/)
* [三角形最小路径和](https://leetcode.cn/problems/triangle/description/)
* [掷骰子等于目标和的方法数](https://leetcode.cn/problems/number-of-dice-rolls-with-target-sum/description/)

## 二分查找

* [二分查找](https://leetcode.cn/problems/binary-search/)
* [x 的平方根](https://leetcode.cn/problems/sqrtx/description/)
* [最小体力消耗路径](https://leetcode.cn/problems/path-with-minimum-effort/description/)
* [咒语和药水的成功对数](https://leetcode.cn/problems/successful-pairs-of-spells-and-potions/description/)

## 并查集

* [最小体力消耗路径](https://leetcode.cn/problems/path-with-minimum-effort/description/)
* [情侣牵手](https://leetcode.cn/problems/couples-holding-hands/description/)
    * 并查集
    * 贪心

## 字符串

* [反转字符串](https://leetcode.cn/problems/reverse-string/description/)
    * 双指针
* [反转字符串中的单词](https://leetcode.cn/problems/reverse-words-in-a-string/description/)
* [最常见的单词](https://leetcode.cn/problems/most-common-word/)
    * 哈希表
* [删去字符串中的元音](https://leetcode.cn/problems/remove-vowels-from-a-string/solutions/)
    * 哈希表
* [字符串转换整数 (atoi)](https://leetcode.cn/problems/string-to-integer-atoi/)
    * 状态机
* [环和杆](https://leetcode.cn/problems/rings-and-rods/description/)
    * 位运算
    * 哈希表
* [最长平衡子字符串](https://leetcode.cn/problems/find-the-longest-balanced-substring-of-a-binary-string/description/)
    * 遍历 + 计数

## 位运算

* [只出现一次的数字](https://leetcode.cn/problems/single-number/description/)
    * 异或
    * 哈希表
* [只出现一次的数字 II](https://leetcode.cn/problems/single-number-ii/description/)
    * 位运算 + 取模
    * 数字电路-门
    * 哈希表
* [只出现一次的数字 III](https://leetcode.cn/problems/single-number-iii/description/)
    * 位运算
    * 哈希表
* [重复的DNA序列](https://leetcode.cn/problems/repeated-dna-sequences/)
    * 哈希表
    * 位运算 + 哈希表 + 滑动窗口
* [最大单词长度乘积](https://leetcode.cn/problems/maximum-product-of-word-lengths/description/)
    * 哈希表
    * 位运算

## 其他

* [倍数求和](https://leetcode.cn/problems/sum-multiples/description/)
    * 遍历
    * 数学：等差求和 + 容斥
* [最大和查询](https://leetcode.cn/problems/maximum-sum-queries/description/)
  * 排序 + 单调栈 + 二分