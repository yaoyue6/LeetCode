package com.yaoyue.leetcode.primary.array;

/**
 * @description: 只出现一次的数字
 * @author: WangDongXu (15224931482)
 * @date: 2020/11/25 19:20
 **/
public class Array05Test {

    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int num = 0;
        for(int i = 0; i < nums.length; i++) {
            num ^= nums[i];
        }
        return num;
    }

    /**
     * 解题思路：
     *  任何数异或自身，结果均为0，任何数异或不等于自身的数，结果均为1，任何数异或0，结果均为任何数，异或满足交换律
     */
}
