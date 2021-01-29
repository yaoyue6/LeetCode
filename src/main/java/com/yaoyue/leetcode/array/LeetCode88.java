package com.yaoyue.leetcode.array;

public class LeetCode88 {

    public void test() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, 3, nums2, 3);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        m--;
        n--;
        int len = m + n + 1;
        while(len >= 0 && m >= 0 && n >= 0) {
            nums1[--len] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }
        System.arraycopy(nums2, 0, nums1, 0, n + 1);
    }
}
