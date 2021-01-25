package com.yaoyue.leetcode.dynamic;

/**
 * @description: 连续子数组的最大和
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/24 13:59
 **/
public class Offer42 {

    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int cur = nums[0];
        for(int i = 1; i < nums.length; i++) {
            cur = Math.max(nums[i], nums[i] + cur);
            max = Math.max(max, cur);
        }
        return max;
    }
}
