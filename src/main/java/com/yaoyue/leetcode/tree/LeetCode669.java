package com.yaoyue.leetcode.tree;

import com.yaoyue.leetcode.tree.base.TreeNode;

/**
 * @description: 修剪二叉树
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/20 13:51
 **/
public class LeetCode669 {

    /**
     * 解题思路：如果当前节点比左边界小，则向右递归，直到比左边界大的节点为止；如果当前节点比右边界大，则向左递归，直到比右边界小的节点为止，再次递归，重构二叉树
     * @param root
     * @param low
     * @param high
     * @return
     */
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null) {
            return null;
        }

        if(low > root.val) {
            return trimBST(root.right, low, high);
        }
        if(high < root.val) {
            return trimBST(root.left, low, high);
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
