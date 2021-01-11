package com.yaoyue.leetcode.array;

/**
 * @description: 打家劫舍
 * @author: WangDongXu (15224931482)
 * @date: 2020/12/28 13:50
 **/
public class LeetCode198 {

    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int length = nums.length;

        if(nums == null || length == 0) {
            return 0;
        }

        if(length == 1) {
            return nums[0];
        }
        int[] result = new int[length];

        result[0] = nums[0];
        result[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < length; i++) {
            result[i] = Math.max(result[i - 1], result[i - 2] + nums[i]);
        }
        return result[length - 1];
    }

    /**
     * 解题思路：使用动态规划，动态规划方程：max[i] = Math.max(max[i - 2] + max[i], max[i - 1]);
     */
}
