package com.yaoyue.primary.array;

/**
 * @description: 删除排序数组中的重复项
 * @author: WangDongXu (15224931482)
 * @date: 2020/11/24 20:14
 **/
public class Array01Test {

    /**
     * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if(nums == null && nums.length <= 0) {
            return -1;
        }
        int left = 0, right = 0;
        while(right < nums.length) {
            if(nums[left] != nums[right]) {
                nums[++left] = nums[right];
            }
            right++;
        }
        return left + 1;
    }
}
