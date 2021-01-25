package com.yaoyue.leetcode.dynamic;

/**
 * @description: 买卖股票的最佳时机
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/24 13:53
 **/
public class LeetCode121 {

    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;

        for(int price : prices) {
            min = Math.min(min, price);
            max = Math.max(max, price - min);
        }
        return max;
    }
}
