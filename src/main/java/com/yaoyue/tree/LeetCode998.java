package com.yaoyue.tree;

import com.yaoyue.tree.base.TreeNode;

/**
 * @description: 最大二叉树 II
 * @author: WangDongXu (15224931482)
 * @date: 2020/12/11 18:39
 **/
public class LeetCode998 {

    /**
     * 最大树定义：一个树，其中每个节点的值都大于其子树中的任何其他值。
     * 给出最大树的根节点 root。
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null || root.val < val) {
            TreeNode temp = new TreeNode(val);
            temp.left = root;
            return temp;
        }
        TreeNode right = insertIntoMaxTree(root.right, val);
        root.right = right;
        return root;
    }

    /**
     * 解题思路：如果待添加节点比根节点大，则添加到最左边，否则一直向右递归
     */
}
