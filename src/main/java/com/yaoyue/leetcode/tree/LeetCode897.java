package com.yaoyue.leetcode.tree;

import com.yaoyue.leetcode.tree.base.TreeNode;

/**
 * @description: 递增顺序查找树
 * @author: WangDongXu (15224931482)
 * @date: 2020/12/8 20:37
 **/
public class LeetCode897 {

    TreeNode cur;

    /**
     * 给你一个树，请你 按中序遍历 重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
     * @param root
     * @return
     */
    public TreeNode increasingBST(TreeNode root) {
        if(root == null) {
            return null;
        }
        TreeNode ans = new TreeNode(0);
        cur = ans;
        inOrder(root);
        return ans.right;
    }

    public void inOrder(TreeNode node) {
        if(node == null) {
            return;
        }
        // cur为当前节点的下一个节点，node.left为当前节点的上一个节点
        inOrder(node.left);
        node.left = null;
        cur.right = node;
        cur = node;
        inOrder(node.right);
    }
}
