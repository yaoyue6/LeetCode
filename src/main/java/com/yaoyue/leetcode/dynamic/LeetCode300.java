package com.yaoyue.leetcode.dynamic;

/**
 * @description: 最长递增子序列
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/25 16:03
 **/
public class LeetCode300 {

    public void test() {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int num = lengthOfLIS(nums);
        System.out.println(num);
    }

    /**
     * 动态规划解法
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length + 1];
        dp[0] = 1;
        int max = 1;
        for(int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
