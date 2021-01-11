package com.yaoyue.leetcode.array;

/**
 * @description: 使用最小花费爬楼梯
 * @author: WangDongXu (15224931482)
 * @date: 2020/12/23 16:32
 **/
public class LeetCode746 {

    /**
     * 数组的每个索引作为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
     * 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
     * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        int f0 = 0, f1 = 0;
        for(int i = 0; i < cost.length; i++) {
            int temp = cost[i] + Math.min(f0, f1);
            f0 = f1;
            f1 = temp;
        }
        return Math.min(f0, f1);
    }

    /**
     * 解题思路：斐波那契数列一把梭
     */
}
