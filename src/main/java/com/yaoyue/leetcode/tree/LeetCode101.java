package com.yaoyue.leetcode.tree;

import com.yaoyue.leetcode.tree.base.TreeNode;

/**
 * @description: 对称二叉树
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/15 15:18
 **/
public class LeetCode101 {

    /**
     * 给定一个二叉树，检查它是否是镜像对称的。
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        return judge(root.left, root.right);
    }

    public boolean judge(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return true;
        }
        if(left == null) {
            return false;
        }
        if(right == null) {
            return false;
        }
        if(left.val != right.val) {
            return false;
        }
        return judge(left.left, right.right) && judge(left.right, right.left);
    }
}
