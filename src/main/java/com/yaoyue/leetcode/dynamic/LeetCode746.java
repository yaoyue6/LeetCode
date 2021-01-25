package com.yaoyue.leetcode.dynamic;

/**
 * @description: 使用最小花费爬楼梯
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/24 13:56
 **/
public class LeetCode746 {

    public int minCostClimbingStairs(int[] cost) {
        int f0 = 0, f1 = 0;
        for(int i = 0; i < cost.length; i++) {
            int temp = cost[i] + Math.min(f0, f1);
            f0 = f1;
            f1 = temp;
        }
        return Math.min(f0, f1);
    }
}
