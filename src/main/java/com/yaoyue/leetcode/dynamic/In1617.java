package com.yaoyue.leetcode.dynamic;

/**
 * @description: 连续数列
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/24 13:42
 **/
public class In1617 {

    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        int max = nums[0];
        int cur = nums[0];
        for(int i = 1; i < nums.length; i++) {
            cur = Math.max(nums[i], cur + nums[i]);
            max = Math.max(max, cur);
        }
        return max;
    }
}
