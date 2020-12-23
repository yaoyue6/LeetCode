package com.yaoyue.tree;

import com.yaoyue.tree.base.TreeNode;

/**
 * @description: 二叉搜索树的第k大节点
 * @author: WangDongXu (15224931482)
 * @date: 2020/12/7 20:56
 **/
public class Offer54 {

    int num, result;

    /**
     * 给定一棵二叉搜索树，请找出其中第k大的节点。
     * @param root
     * @param k
     * @return
     */
    public int kthLargest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        num = k;
        infixOrder(root);
        return result;
    }

    public void infixOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        infixOrder(node.right);

        if (num == 0) {
            return;
        }

        if(--num == 0) {
            result = node.val;
        }
        infixOrder(node.left);
    }

    /**
     * 解题思路：二叉搜索树在进行中序遍历时，是从小到大的顺序，因此第k大的节点可通过中序遍历的倒序算出，即右中左
     */
}
