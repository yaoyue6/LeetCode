package com.yaoyue.leetcode.primary.array;

/**
 * @description: 旋转数组
 * @author: WangDongXu (15224931482)
 * @date: 2020/11/25 12:31
 **/
public class Array03Test {

    public void test() {
        int[] nums = {1,2,3,4,5,6,7};
        rotate(nums, 3);
    }

    /**
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        // 总循环数，等于数组元素数时移动完成
        int count = 0;
        for (int i = 0; count < nums.length; i++) {
            // 当前待移动数的下标
            int current = i;
            // 当前位置，移动之前的值
            int pre = nums[i];
            do {
                // 移动之后，所在位置
                int next = (current + k) % nums.length;
                // 移动之后的值
                int temp = nums[next];
                // 交换元素
                nums[next] = pre;
                pre = temp;
                current = next;
                count++;
            } while (current != i);
        }
    }

    /**
     * 解题思路：环状替代
     */
}
