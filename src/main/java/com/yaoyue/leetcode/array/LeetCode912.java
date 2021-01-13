package com.yaoyue.leetcode.array;

/**
 * @description: 排序数组
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/12 11:19
 **/
public class LeetCode912 {

    /**
     * 选择排序
     * @param nums
     * @return
     */
    public int[] selectSort(int[] nums) {
        int min = 0;
        int temp = 0;
        for(int i = 0; i < nums.length; i++) {
            min = i;
            for(int j = i; j < nums.length; j++) {
                if(nums[j] < nums[min]) {
                    min = j;
                }
            }
            if(i != min) {
                temp = nums[i];
                nums[i] = nums[min];
                nums[min] = temp;
            }
        }
        return nums;
    }

    /**
     * 插入排序交换法
     * @param nums
     * @return
     */
    public int[] insertSort1(int[] nums) {
        int temp = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = i; j > 0 && nums[j] < nums[j - 1]; j--) {
                temp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = temp;
            }
        }
        return nums;
    }

    public int[] insertSort2(int[] nums) {
        int insertIndex = 0;
        int insertValue = 0;
        for(int i = 0; i < nums.length; i++) {
            insertIndex = i - 1;
            insertValue = nums[i];
            while(insertIndex > 0 && nums[insertIndex + 1] < nums[insertIndex]) {
                nums[insertIndex] = nums[insertIndex + 1];
            }
            nums[insertIndex + 1] = insertValue;
        }
        return nums;
    }

    /**
     * 希尔排序交换式
     * @param nums
     */
    public int[] exchangeShellSort(int[] nums) {
        int n = nums.length;
        int temp = 0;

        // 分组的步长
        for(int step = n; step > 0; step /= 2) {
            // 遍历各分组
            for(int i = step; i < n; i++) {
                // 遍历某个分组，进行元素比较
                for(int j = i - step; j >= 0; j -= step) {
                    // 为什么使用j + step，需要进行分组内的比较，但使用j - step可能会数组下标越界，出现负数，因此使用j + step
                    if(nums[j] > nums[j + step]) {
                        temp = nums[j];
                        nums[j] = nums[j + step];
                        nums[j + step] = temp;
                    }
                }
            }
        }
        return nums;
    }

    /**
     * 归并排序
     * @param start
     * @param end
     * @param nums
     * @param temp
     */
    public void mergeSort(int start, int end, int[] nums, int[] temp) {
        if(start < end) {
            int middle = (start + end) / 2;
            mergeSort(start, middle, nums, temp);
            mergeSort(middle + 1, end, nums, temp);
            merge(start, end, nums, temp);
        }
    }

    public void merge(int start, int end, int[] nums, int[] temp) {
        int middle = (start + end) / 2;
        int i = start;
        int j = middle + 1;
        int index = 0;
        while(i <= middle && j <= end) {
            temp[index++] = nums[i] > nums[j] ? nums[j++] : nums[i++];
        }
        while(i <= middle) {
            temp[index++] = nums[i++];
        }
        while(j <= end) {
            temp[index++] = nums[j++];
        }
        index = 0;
        for(int k = start; k <= end; k++) {
            nums[k] = temp[index++];
        }
    }

    /**
     * 快速排序
     * @param start
     * @param end
     * @param nums
     */
    public void quickSort(int start, int end, int[] nums) {
        int pivot = nums[(start + end) / 2];
        int l = start;
        int r = end;
        while(l < r) {
            while(pivot > nums[l]) {
                l++;
            }
            while(pivot < nums[r]) {
                r--;
            }

            if(l >= r) {
                break;
            }

            // 异或代替移位
            nums[l] = nums[r] ^ nums[l];
            nums[r] = nums[r] ^ nums[l];
            nums[l] = nums[r] ^ nums[l];

            if(pivot == nums[l]) {
                r--;
            }
            if(pivot == nums[r]) {
                l++;
            }
        }

        if(l == r) {
            l++;
            r--;
        }
        if(l < end) {
            quickSort(l, end, nums);
        }
        if(r > start) {
            quickSort(start, r, nums);
        }
        if(l < end) {
            quickSort(l, end, nums);
        }
    }
}
