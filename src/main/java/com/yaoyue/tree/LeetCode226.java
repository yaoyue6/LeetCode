package com.yaoyue.tree;

import com.yaoyue.tree.base.TreeNode;

/**
 * @description: 翻转二叉树
 * @author: WangDongXu (15224931482)
 * @date: 2020/12/10 17:42
 **/
public class LeetCode226 {

    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
