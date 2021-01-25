package com.yaoyue.leetcode.dynamic;

/**
 * @description: 三步问题
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/24 14:30
 **/
public class In0801 {

    public int waysToStep(int n) {
        if(n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        // 动态规划方程推导：因为上楼梯的可能性为1、2、3，则最后一步可能会迈1、2、3步，因此当前可能性为dp[i - 1] + dp[i - 2] + dp[i - 3]
        for(int i = 4; i <= n; i++) {
            dp[i] = (dp[i - 1] + (dp[i - 2] + dp[i - 3]) % 1000000007) % 1000000007;
        }
        return dp[n];
    }
}
