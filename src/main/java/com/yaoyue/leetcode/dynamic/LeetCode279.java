package com.yaoyue.leetcode.dynamic;

/**
 * @description: 完全平方数
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/25 17:28
 **/
public class LeetCode279 {

    public int numSquares(int n) {
        if(n <= 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            // 初始化，最坏情况：全是1
            dp[i] = i;
            for(int j = 0; i - j * j >= 0; j++) {
                // 状态转移方程
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
