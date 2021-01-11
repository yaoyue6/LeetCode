package com.yaoyue.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 求众数II
 * @author: WangDongXu (15224931482)
 * @date: 2020/12/29 13:22
 **/
public class LeetCode229 {

    /**
     * 给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
     * @param nums
     * @return
     */
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();

        int count1 = 0, result1 = nums[0];
        int count2 = 0, result2 = nums[0];

        for(int num : nums) {
            if(result1 == num) {
                count1++;
            } else if(result2 == num) {
                count2++;
            } else if(count1 == 0) {
                result1 = num;
                count1 = 1;
            } else if(count2 == 0) {
                result2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;

        for(int num : nums) {
            if(num == result1) {
                count1++;
            } else if(num == result2) {
                count2++;
            }
        }

        if(count1 > nums.length / 3) {
            list.add(result1);
        }
        if(count2 > nums.length / 3) {
            list.add(result2);
        }
        return list;
    }

    /**
     * 解题思路：摩尔投票法进阶，由于需要判断出现次数大于 n/3 次的元素，因此最多有2个候选元素，采用摩尔投票法创建2个出现次数最多的候选元素
     * 统计出现频率，如果大于 n/3 ，就加入结果集
     */
}
