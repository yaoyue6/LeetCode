package com.yaoyue.practice.dynamic;

/**
 * @description: 01背包问题
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/22 21:45
 **/
public class DynamicTest02 {

    /**
     * 递归解法
     * @param weight
     * @param value
     * @param index
     * @param rest
     * @return
     */
    public int process(int[] weight, int[] value, int index, int rest) {
        if (rest < 0) {
            return -1;
        }
        if (index == weight.length) {
            return 0;
        }

        int p1 = process(weight, value, index + 1, rest);
        int p2 = 0;
        if (rest - weight[index] >= 0) {
            p2 = process(weight, value, index + 1, rest - weight[index]);
        }
        return Math.max(p1, p2);
    }

    public int dpProcess(int[] weight, int[] value, int bag) {
        int[][] dp = new int[weight.length + 1][bag + 1];

        for (int i = weight.length - 1; i >= 0; i--) {
            for (int j = 0; j <= bag; j++) {
                // 直接从暴力解法改写
                dp[i][j] = Math.max(dp[i + 1][j], dp[i + 1][j - weight[i]]);
            }
        }
        return dp[0][bag];
    }
}
