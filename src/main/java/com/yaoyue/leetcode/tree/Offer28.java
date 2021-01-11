package com.yaoyue.leetcode.tree;

import com.yaoyue.leetcode.tree.base.TreeNode;

/**
 * @description: 对称的二叉树
 * @author: WangDongXu (15224931482)
 * @date: 2020/12/9 14:15
 **/
public class Offer28 {

    /**
     * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        return check(root.left, root.right);
    }

    public boolean check(TreeNode LNode, TreeNode RNode) {
        if(LNode == null && RNode == null) {
            return true;
        }
        if(RNode == null || LNode == null || LNode.val != RNode.val) {
            return false;
        }
        return check(LNode.left, RNode.right) && check(RNode.left, LNode.right);
    }

    /**
     * 解题思路：当左节点和右节点同时为null，则返回true，如果左节点或右节点不为null，则返回false，如果左节点和右节点的值不对应，则返回false
     */
}
