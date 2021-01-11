package com.yaoyue.leetcode.primary.array;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 两个数组的交集 II
 * @author: WangDongXu (15224931482)
 * @date: 2020/11/25 21:22
 **/
public class Array06Test {

    @Test
    public void test() {
        int[] nums1 = {4, 9, 5, 4, 4};
        int[] nums2 = {9, 4, 9, 8, 4};
        int[] intersect = intersect(nums1, nums2);
        for (int num : intersect) {
            System.out.println(num);
        }
    }

    /**
     * 给定两个数组，编写一个函数来计算它们的交集。
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        // 调换顺序，较短数组在前，较长数组在后
        if(nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        Map<Integer, Integer> map = new HashMap<>();
        // 较短数组的数值加入哈希表中
        for(int num : nums1) {
            if(map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        int[] result = new int[nums1.length];
        int temp = 0;

        // 如果较长数组中含有一致的数，则抵消，同时value - 1，value为0之后，从哈希表中删除此数
        for(int num : nums2) {
            if(map.containsKey(num)) {
                if(map.get(num) > 0) {
                    result[temp++] = num;
                    map.put(num, map.get(num) - 1);
                } else {
                    map.remove(num);
                }

            }
        }
        return Arrays.copyOfRange(result, 0, temp);
    }

    /**
     * 解题思路：利用哈希表记录较短数组中的数值及出现的次数，之后遍历较长数组，判断数组中是否含有一致的数，如果有，则抵消，同时加入到结果数组中
     */
}
