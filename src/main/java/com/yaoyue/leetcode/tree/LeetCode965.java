package com.yaoyue.leetcode.tree;

import com.yaoyue.leetcode.tree.base.TreeNode;

/**
 * @description: 单值二叉树
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/20 13:17
 **/
public class LeetCode965 {

    int val;
    public boolean isUnivalTree(TreeNode root) {
        if(root == null) {
            return false;
        }
        val = root.val;
        return univalTree(root);
    }

    public boolean univalTree(TreeNode node) {
        if(node == null) {
            return true;
        }
        if(node.val != val) {
            return false;
        }
        return univalTree(node.left) && univalTree(node.right);
    }
}
