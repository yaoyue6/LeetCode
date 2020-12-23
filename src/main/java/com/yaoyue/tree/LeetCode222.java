package com.yaoyue.tree;

import com.yaoyue.tree.base.TreeNode;

/**
 * @description: 完全二叉树的节点个数
 * @author: WangDongXu (15224931482)
 * @date: 2020/12/15 17:25
 **/
public class LeetCode222 {

    public static void main(String[] args) {
        LeetCode222 test = new LeetCode222();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        System.out.println(test.countNodes(node1));
    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
