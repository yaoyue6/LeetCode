package com.yaoyue.leetcode.primary.array;

/**
 * @description: 加一
 * @author: WangDongXu (15224931482)
 * @date: 2020/11/25 20:53
 **/
public class Array07Test {

    /**
     * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        for(int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if(digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
    /**
     * 解题思路：除了999等全为9的数组之外，其他数组均不需要增加容量，全为9的数组+1之后变为第一个元素为1，其它均为0，数组容量+1
     */
}
