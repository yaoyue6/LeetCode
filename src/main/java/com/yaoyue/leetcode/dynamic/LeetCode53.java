package com.yaoyue.leetcode.dynamic;

/**
 * @description: 最大子序和
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/23 15:19
 **/
public class LeetCode53 {

    /**
     * 动态规划方程：cur = Math.max(num, num + cur);
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        // 当前能取到的最大子序和
        int cur = 0;
        // 数组中能取到的最大子序和
        int max = nums[0];
        for(int num : nums) {
            cur = Math.max(num, num + cur);
            max = Math.max(max, cur);
        }
        return max;
    }
}
