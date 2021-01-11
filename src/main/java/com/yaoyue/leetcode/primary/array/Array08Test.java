package com.yaoyue.leetcode.primary.array;

/**
 * @description: 移动零
 * @author: WangDongXu (15224931482)
 * @date: 2020/11/24 21:41
 **/
public class Array08Test {

    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int start = 0, end = 0;
        while(end < nums.length) {
            if(nums[end] != 0) {
                nums[start++] = nums[end];
            }
            end++;
        }

        for(int i = start; i < end; i++) {
            nums[i] = 0;
        }
    }
}
