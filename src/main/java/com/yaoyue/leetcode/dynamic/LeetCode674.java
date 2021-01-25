package com.yaoyue.leetcode.dynamic;

/**
 * @description: 最长递增子序列
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/24 11:49
 **/
public class LeetCode674 {

    public int findLengthOfLCIS(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int max = 1;
        int cur = 1;
        for(int i = 1; i < nums.length; i++) {
            // 也可以替换为 cur = nums[i] > nums[i - 1] ? cur + 1 : 1;
            if(nums[i - 1] < nums[i]) {
                cur++;
            } else {
                cur = 1;
            }
            max = Math.max(cur, max);
        }
        return max;
    }
}
