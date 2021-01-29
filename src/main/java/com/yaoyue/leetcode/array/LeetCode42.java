package com.yaoyue.leetcode.array;

/**
 * @description: 接雨水
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/28 10:13
 **/
public class LeetCode42 {

    /**
     * 双指针解法
     * @param height
     * @return
     */
    public int trap(int[] height) {
        if(height == null || height.length == 0) {
            return 0;
        }

        // 左右指针边界
        int left = 0, right = height.length - 1;
        int sum = 0;
        // 基准线
        int mark = Math.min(height[left], height[right]);

        while(left < right) {
            // 如果左边界较短，则左边界右移
            if(height[left] < height[right]) {
                left++;
                // 如果此时基准线比当前左边界大，则证明此时左边必定存在比左边界更高的元素，因此加上基准线比左边界大的部分
                if(mark > height[left]) {
                    sum += mark - height[left];
                } else {
                    // 如果此时基准线比当前左边界小，则证明在当前情况下，此处可能无法盛水，重新定义基准线
                    mark = Math.min(height[left], height[right]);
                }
            } else {
                right--;
                // 如果此时基准线比当前右边界大，则证明此时右边必定存在比右边界更高的元素，因此加上基准线比右边界大的部分
                if(mark > height[right]) {
                    sum += mark - height[right];
                } else {
                    // 如果此时基准线比当前右边界小，则证明在当前情况下，此处可能无法盛水，重新定义基准线
                    mark = Math.min(height[left], height[right]);
                }
            }
        }
        return sum;
    }
}
