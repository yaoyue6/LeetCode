package com.yaoyue.leetcode.array;

/**
 * @description: 容器盛水问题
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/28 10:04
 **/
public class Offer128 {

    public long maxWater (int[] arr) {
        // write code here
        if(arr == null || arr.length == 0) {
            return 0;
        }
        int left = 0, right = arr.length - 1;
        long sum = 0;
        int mark = Math.min(arr[left], arr[right]);
        while(left < right) {
            if(arr[left] < arr[right]) {
                left++;
                if(mark > arr[left]) {
                    sum += mark - arr[left];
                } else {
                    mark = Math.min(arr[left], arr[right]);
                }
            } else {
                right--;
                if(mark > arr[right]) {
                    sum += mark - arr[right];
                } else {
                    mark = Math.min(arr[left], arr[right]);
                }
            }
        }
        return sum;
    }
}
