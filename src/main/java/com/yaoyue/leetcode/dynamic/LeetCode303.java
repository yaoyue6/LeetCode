package com.yaoyue.leetcode.dynamic;

/**
 * @description: 区域和检索 - 数组不可变
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/24 14:13
 **/
public class LeetCode303 {

    public int[] dp;

    /**
     * 使用缓存代替频繁计算操作
     * @param nums
     */
    public void NumArray(int[] nums) {
        dp = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++) {
            dp[i + 1] = dp[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return dp[j + 1] - dp[i];
    }
}
