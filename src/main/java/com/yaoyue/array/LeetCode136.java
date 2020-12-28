package com.yaoyue.array;

/**
 * @description: 只出现过一次的数字
 * @author: WangDongXu (15224931482)
 * @date: 2020/12/28 11:18
 **/
public class LeetCode136 {

    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int result = 0;

        // 使用异或，任何数异或0，均为任何数，任何数异或自身，均为0
        for(int num : nums) {
            result ^= num;
        }
        return result;
    }
}
