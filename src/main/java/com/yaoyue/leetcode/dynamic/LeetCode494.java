package com.yaoyue.leetcode.dynamic;

/**
 * @description: 目标和
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/25 13:42
 **/
public class LeetCode494 {

    /**
     * 穷举法
     * @param nums
     * @param S
     * @return
     */
    public int findTargetSumWays(int[] nums, int S) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        return process(nums, 0, S);
    }

    public int process(int[] nums, int index, int target) {
        if(index == nums.length) {
            return target == 0 ? 1 : 0;
        }

        return process(nums, index + 1, target - nums[index]) + process(nums, index + 1, target + nums[index]);
    }
}
