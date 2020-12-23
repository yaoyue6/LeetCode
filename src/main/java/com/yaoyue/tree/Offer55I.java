package com.yaoyue.tree;

import com.yaoyue.tree.base.TreeNode;

/**
 * @description: 二叉树的深度
 * @author: WangDongXu (15224931482)
 * @date: 2020/12/9 16:00
 **/
public class Offer55I {

    /**
     * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        return height(root);
    }
    public int height(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int left = height(node.left);
        int right = height(node.right);
        return Math.max(left, right) + 1;
    }
}
