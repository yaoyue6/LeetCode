package com.yaoyue.leetcode.tree;

import com.yaoyue.leetcode.tree.base.TreeNode;

/**
 * @description: 二叉搜索树的最小绝对差
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/20 11:20
 **/
public class LeetCode530 {

    int min;
    TreeNode pre;

    /**
     * 中序遍历解题，定义后继节点
     * @param root
     * @return
     */
    public int getMinimumDifference(TreeNode root) {
        min = Integer.MAX_VALUE;
        minimumDifference(root);
        return min;
    }

    public void minimumDifference(TreeNode node) {
        if(node == null) {
            return;
        }

        minimumDifference(node.left);
        if(pre == null) {
            pre = node;
        } else {
            min = Math.min(min, Math.abs(pre.val - node.val));
            pre = node;
        }
        minimumDifference(node.right);
    }
}
