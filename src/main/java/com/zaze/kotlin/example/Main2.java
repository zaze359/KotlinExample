package com.zaze.kotlin.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main2 {

    public int solution(int n, int m) {
        // 表示 i+1 位在和为 j 的个数
        int[][] dp = new int[n][m + 1];
        // 初始
        Arrays.fill(dp[0], 1, Math.min(m, 9) + 1, 1);

        // 循环处理
        for (int i = 1; i < n; i++) {
            int left = 0;
            for (int j = 1; j <= Math.min((i + 1) * 9, m); j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][left];
                while (j - left > 9) {
                    left++;
                }
            }
        }
        return dp[n - 1][m];
    }

    List<String> ans = new ArrayList<>();

    public void dfs(int n, int m) {
        dfs(n, m, true, "");
    }

    public int count = 0;

    public void dfs(int n, int m, boolean flag, String curr) {
        count++;
        if (m > 9 * n) {
            return;
        }
        if (n == 1) {
            ans.add(curr + m);
        } else {
            for (int i = (flag ? 1 : 0); i <= 9 && m >= i; i++) {
                dfs(n - 1, m - i, false, curr + i);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Main2().solution(10, 30));
    }
}

