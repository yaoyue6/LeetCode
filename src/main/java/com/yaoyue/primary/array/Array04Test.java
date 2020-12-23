package com.yaoyue.primary.array;


import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 存在重复元素
 * @author: WangDongXu (15224931482)
 * @date: 2020/11/24 21:25
 **/
public class Array04Test {

    @Test
    public void Test() {
        int[] nums = {3, 1};
        System.out.println(containsDuplicate(nums));
    }

    /**
     * 给定一个整数数组，判断是否存在重复元素。
     * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int num : nums) {
            if(!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}
