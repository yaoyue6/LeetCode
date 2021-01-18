package com.yaoyue.leetcode.tree;

/**
 * @description: 不同的二叉搜索树
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/18 17:10
 **/
public class LeetCode96 {

    /**
     * 动态规划解法
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] result = new int[n + 1];
        result[0] = 1;
        result[1] = 1;
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                // 动态规划方程，以当前节点为中心，左边的为左子树，右边的为右子树，左右子树均为二叉搜索树，因此以当前节点为二叉搜索树时，可能会有result[i - 1] * result[n - i]种可能性
                result[i] += result[j - 1] * result[i - j];
            }
        }
        return result[n];
    }
}
