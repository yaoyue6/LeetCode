package com.yaoyue.array;

/**
 * @description: 最大子序和
 * @author: WangDongXu (15224931482)
 * @date: 2020/12/28 11:05
 **/
public class LeetCode53 {

    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int pre = 0, max = 0;
        for(int num : nums) {
            // 相当于滚动数组，如果num大于pre + num，则从num重新开始计算
            pre = Math.max(pre + num, num);
            // 获得pre和max中的最大值
            max = Math.max(pre, max);
        }
        return max;
    }
}
