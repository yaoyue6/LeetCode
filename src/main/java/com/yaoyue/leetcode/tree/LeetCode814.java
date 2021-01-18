package com.yaoyue.leetcode.tree;

import com.yaoyue.leetcode.tree.base.TreeNode;

/**
 * @description: 二叉树剪枝
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/18 11:04
 **/
public class LeetCode814 {

    public TreeNode pruneTree(TreeNode root) {
        // 如果最后返回的结果为false，则整棵树都会被剪掉
        return cutTree(root) ? root : null;
    }

    public boolean cutTree(TreeNode node) {
        if(node == null) {
            return false;
        }

        boolean left = cutTree(node.left);
        boolean right = cutTree(node.right);

        // 处理左子树返回的结果
        if(!left) {
            node.left = null;
        }
        // 处理右子树返回的结果
        if(!right) {
            node.right = null;
        }
        // 当前子树只需要对左、右子树返回的结果进行处理，并判断当前节点应返回的数据
        return node.val == 1 || left || right;
    }
}
