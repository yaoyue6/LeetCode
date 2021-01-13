package com.yaoyue.practice.sort;

import java.util.Arrays;

/**
 * @description: 快速排序
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/13 14:46
 **/
public class QuickSort {

    public static void main(String[] args) {
        int[] array = {-2,3,-5};
        show(array);
        sort(0, array.length - 1, array);
        show(array);
    }

    /**
     * 快速排序
     * @param start
     * @param end
     * @param nums
     */
    public static void sort(int start, int end, int[] nums) {
        // 基准点
        int pivot = nums[(start + end) / 2];
        int l = start;
        int r = end;

        while(l < r) {
            while(nums[l] < pivot) {
                l++;
            }
            while(nums[r] > pivot) {
                r--;
            }

            // 如果左指针大于右指针，则证明基准点两侧已经有序
            if(l >= r) {
                break;
            }

            // 交换左右元素
            int temp = nums[r];
            nums[r] = nums[l];
            nums[l] = temp;

            // 如果数组中存在重复元素，当重复元素作为基准点时会造成死循环，因此利用下列代码跳过重复元素
            if(nums[l] == pivot) {
                r--;
            }
            if(nums[r] == pivot) {
                l++;
            }
        }

        if(l == r) {
            l++;
            r--;
        }

        if(l < end) {
            sort(l, end, nums);
        }
        if(r > start) {
            sort(start, r, nums);
        }
    }

    /**
     * 遍历数组
     * @param array
     */
    public static void show(int[] array) {
        for (int num : array) {
            System.out.print(num + "\t");
        }
        System.out.println();
    }
}
