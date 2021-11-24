package com.zaze.kotlin.example;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public static final int maxNumber = 9;

    // 长度表示递归深度
    public static int length = 20;
    public static int count = 16;

    public static long[][] cacheArray = new long[length][count];
    public static Map<String, List<String>> cacheMap = new HashMap<>();

//    public static List<Integer, List<String>> list = new ArrayList<>();

    public static boolean useCache = false;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(new Main2().solution(length, count));
        com.zaze.kotlin.example.Main2 math = new com.zaze.kotlin.example.Main2();
        math.dfs(length, count);
        System.out.println("time: " + (System.currentTimeMillis() - start) + "; count: " + math.count);
        start = System.currentTimeMillis();
        System.out.println(needMore(1, count, length - 1));
        System.out.println("time: " + (System.currentTimeMillis() - start) + "; eCount: " + eCount);
    }

    private static long eCount = 0;

    public static long needMore(int defaultV, int needNumber, int loopCount) {
        eCount++;
        if (loopCount <= 0) {
            if (needNumber > maxNumber) {
                // 表示不够，需返回上层消费
//                System.out.print("表示不够，需返回上层消费");
                return 0;
            } else {
//                System.out.println("最后一位: " + builder.toString());
//                String key = loopCount + "_" + needNumber;
//                List<String> list = cacheMap.get(key);
//                if(list == null){
//                    list = new ArrayList<>();
//                }
//                cacheMap.put(loopCount + "_" + needNumber, needNumber);
                return 1;
            }
        }
        long count = 0;
        int max = Math.min(needNumber, maxNumber);
        int nextLoop = loopCount - 1;
        for (int i = defaultV; i <= max; i++) {
            int nextNeed = needNumber - i;
            long hasNumber = cacheArray[nextLoop][nextNeed];
            if (hasNumber == 0) {
                Map<String, String> map = new HashMap<>();
                hasNumber = needMore(0, nextNeed, nextLoop);
                cacheArray[nextLoop][nextNeed] = hasNumber;
            } else {
//                System.out.println("命中缓存[" + nextLoop + "]" + "[" + nextNeed + "]: " + hasNumber);
            }
            if (hasNumber > 0) {

            }
            count += hasNumber;
        }
        return count;
    }


    public static long needMore2(int defaultV, int needNumber, int loopCount, StringBuilder builder) {
        if (loopCount <= 0) {
            if (needNumber > maxNumber) {
                // 表示不够，需返回上层消费
//                System.out.print("表示不够，需返回上层消费");
                return 0;
            } else {
                builder.append(needNumber);
//                System.out.println("最后一位: " + builder.toString());
                return 1;
            }
        }
        long count = 0;
        int max;
        if (needNumber > maxNumber) {
            max = maxNumber;
        } else {
            max = needNumber;
        }
        int nextLoop = loopCount - 1;

        for (int i = defaultV; i <= max; i++) {
            StringBuilder temp = new StringBuilder(builder.toString());
            temp.append(i);
            int nextNeed = needNumber - i;

            long hasNumber;
            if (useCache) {
                hasNumber = cacheArray[nextLoop][nextNeed];
            } else {
                hasNumber = 0;
            }
            if (hasNumber == 0) {
//                Map<String, String> map = new HashMap<>();
                hasNumber = needMore(0, nextNeed, nextLoop);
                cacheArray[nextLoop][nextNeed] = hasNumber;
            } else {
//                System.out.println("命中缓存: " + builder.toString());
            }
            count += hasNumber;
        }
        return count;
    }


//    public boolean isCovered(int[][] ranges, int left, int right) {
//        int count = 0;
//        int[] hasArray = new int[right];
//        for (int[] range : ranges) {
//            int fLeft = range[0];
//            int fRight = range[range.length - 1];
//            if (fLeft > right || fRight < left) {
//                // 不相交
//                continue;
//            }
//            int start;
//            int end;
//            if (fLeft >= left) {
//                start = fLeft;
//                if (fRight >= right) {
//                    end = right;
//                } else {
//                    end = fRight;
//                }
//            } else {
//                start = left;
//                if (fRight >= right) {
//                    return true;
//                } else {
//                    end = fRight;
//                }
//            }
//            for (int i = start; i < end; i++) {
//
//            }
//        }
//    }
}