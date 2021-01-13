package com.yaoyue.practice.sort;

/**
 * @description: 归并排序
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/13 10:23
 **/
public class MergeSort {

    public static void main(String[] args) {
        int[] nums = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        int[] temp = new int[nums.length];
        mergeSort(0, nums.length - 1, nums, temp);
        show(nums);
    }

    /**
     * 归并排序算法
     * @param start
     * @param end
     * @param nums
     * @param temp
     */
    public static void mergeSort(int start, int end, int[] nums, int[] temp) {
        if(start < end) {
            int middle = (start + end) / 2;
            // 向左递归
            mergeSort(start, middle, nums, temp);
            // 向右递归
            mergeSort(middle + 1, end, nums, temp);

            // 合并
            merge(start, end, nums, temp);
        }
    }

    /**
     * 合并
     * @param start 起始地址
     * @param end 结束地址
     * @param nums 排序数组
     * @param temp 辅助数组
     */
    public static void merge(int start, int end, int[] nums, int[] temp) {
        // 辅助数组的指针
        int index = 0;
        // 存放待排序数组的中间地址
        int middle = (start + end) / 2;
        // 左数组的起始地址
        int i = start;
        // 右数组的起始地址
        int j = middle + 1;
        // 通过辅助数组合并左右数组，小的元素在前，大的元素在后
        while(i <= middle && j <= end) {
            temp[index++] = nums[i] > nums[j] ? nums[j++] : nums[i++];
        }

        // 此时可能的情况：
        // 1.右数组已经遍历完，左数组还没遍历完
        while(i <= middle) {
            temp[index++] = nums[i++];
        }
        // 2.左数组已经遍历完，右数组还没遍历完
        while(j <= end) {
            temp[index++] = nums[j++];
        }
        index = 0;
        // 通过已经排好序的辅助数组对排序数组进行赋值，注意，此处k <= end，因为end最多为nums.length - 1，所以k最大可等于end
        for(int k = start; k <= end; k++) {
            nums[k] = temp[index++];
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
