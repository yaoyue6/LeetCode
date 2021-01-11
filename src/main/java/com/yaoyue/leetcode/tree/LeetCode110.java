package com.yaoyue.leetcode.tree;

import com.yaoyue.leetcode.tree.base.TreeNode;

/**
 * @description: 平衡二叉树
 * @author: WangDongXu (15224931482)
 * @date: 2020/12/4 17:11
 **/
public class LeetCode110 {

    /**
     * 给定一个二叉树，判断它是否是高度平衡的二叉树。
     * 本题中，一棵高度平衡二叉树定义为：
     *  一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1 。
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    public int height(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int leftHeight;
        int rightHeight;
        if((leftHeight = height(node.left)) == -1 || (rightHeight = height(node.right)) == -1 || (Math.abs(leftHeight - rightHeight) > 1)) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    /**
     * 解题思路：
     *  从底向上，依次遍历节点的左右子树差值是否大于1，如果大于1，则返回-1，否则继续向下遍历，直到根节点返回
     *  如果结果为-1，则为子树高度差超过1，因此返回false
     */
}
