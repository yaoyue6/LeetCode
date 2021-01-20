package com.yaoyue.leetcode.tree;

import com.yaoyue.leetcode.tree.base.TreeNode;

/**
 * @description: 
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/20 13:05
 **/
public class LeetCode404 {

    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        sumOfLeftLeaves(root, false);
        return sum;
    }

    /**
     * 还可以通过判断递归走势以及是否叶子节点来解题
     * @param root
     * @param flag
     */
    public void sumOfLeftLeaves(TreeNode root, boolean flag) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null && flag) {
            sum += root.val;
        }

        sumOfLeftLeaves(root.left, true);
        sumOfLeftLeaves(root.right, false);
    }
}
