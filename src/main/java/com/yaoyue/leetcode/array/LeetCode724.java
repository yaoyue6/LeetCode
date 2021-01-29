package com.yaoyue.leetcode.array;

/**
 * @description: 寻找数组的中心索引
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/28 15:12
 **/
public class LeetCode724 {

    public int pivotIndex(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int total = 0;
        for(int num : nums) {
            total += num;
        }
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            // 中心索引两边的元素之和相等，因此索引左边之和的2倍 + 当前元素 = 总和，此处即为中心索引
            if(2 * sum + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }
}
