package com.yaoyue.leetcode.dac;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 全排列
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/25 13:12
 **/
public class LeetCode46 {

    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0) {
            return list;
        }

        process(nums, 0);
        return list;
    }

    public void process(int[] nums, int index) {
        // 触发结束条件
        if(nums.length == index) {
            List<Integer> path = new ArrayList<>();
            for(int num : nums) {
                path.add(num);
            }
            list.add(path);
            return;
        }

        for(int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            // 进行选择
            process(nums, index + 1);
            // 撤销选择，消除后效性
            swap(nums, i, index);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }



    public List<List<Integer>> permute1(int[] nums) {
        if(nums == null || nums.length == 0) {
            return list;
        }

        List<Integer> path = new ArrayList<>();
        process(nums, path);
        return list;
    }

    public void process(int[] nums, List<Integer> path) {
        // 触发结束条件
        if(nums.length == path.size()) {
            list.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            // 排除重复选择
            if(!path.contains(nums[i])) {
                // 添加此选择
                path.add(nums[i]);
                // 进行下一次选择
                process(nums, path);
                // 移除此选择
                path.remove(path.size() - 1);
            }
        }
    }
}
