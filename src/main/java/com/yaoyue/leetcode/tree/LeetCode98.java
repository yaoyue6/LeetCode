package com.yaoyue.leetcode.tree;

import com.yaoyue.leetcode.tree.base.TreeNode;

/**
 * @description: 验证二叉搜索树
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/20 16:55
 **/
public class LeetCode98 {

    /**
     * 递归解法
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        long max = Long.MAX_VALUE, min = Long.MIN_VALUE;
        return isBST(root, max, min);
    }

    public boolean isBST(TreeNode node, long max, long min) {
        if(node == null) {
            return true;
        }
        if(node.val <= min || node.val >= max) {
            return false;
        }
        return isBST(node.left, node.val, min) && isBST(node.right, max, node.val);
    }

    /**
     * 中序遍历解法，利用中序遍历特性：每次遍历的节点都是当前子树最大的节点，若当前节点大于之前最大的节点，则true
     * @param root
     * @return
     */
    long max = Long.MIN_VALUE;
    public boolean isValidBST2(TreeNode root) {
        if(root == null) {
            return true;
        }
        if(isValidBST(root.left)) {
            if(max < root.val) {
                max = root.val;
                return isValidBST(root.right);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
