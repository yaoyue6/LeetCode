package com.yaoyue.leetcode.array;

/**
 * @description: 两个只出现奇数次的数字
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/13 17:31
 **/
public class LeetCode136II {

    /**
     *
     * @param nums
     * @return
     */
    public int[] twoSingleNumber(int[] nums) {
        // 两个数的异或结果
        int eor = 0;
        for(int num : nums) {
            eor ^= num;
        }

        // 存储的是从右往左第一个1
        int a = eor ^ (~eor + 1);
        // 存储一个出现奇数次的数字
        int b = 0;
        for (int i = 0; i < nums.length; i++) {
            // (a & nums[i]) != 0 ：不为0时，则证明异或结果在1的一方
            if((a & nums[i]) != 0) {
                b ^= nums[i];
            }
        }
        return new int[]{b, b ^ eor};
    }
}
