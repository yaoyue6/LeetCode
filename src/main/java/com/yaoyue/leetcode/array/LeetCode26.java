package com.yaoyue.leetcode.array;

import org.junit.Test;

public class LeetCode26 {

    @Test
    public void test() {
        int[] array = {1, 1, 2};
        removeDuplicates(array);

        for(int num : array) {
            System.out.print(num + "->");
        }
    }

    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int fast = 1, slow = 0;
        while(fast != nums.length) {
            if(nums[fast] == nums[slow]) {
                fast++;
            } else {
                if(fast != slow + 1) {
                    nums[slow + 1] = nums[fast];
                    nums[fast] = 0;
                }
                fast++;
                slow++;
            }
        }
        return slow + 1;
    }
}
