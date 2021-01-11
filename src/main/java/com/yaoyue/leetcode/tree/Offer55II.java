package com.yaoyue.leetcode.tree;

import com.yaoyue.leetcode.tree.base.TreeNode;

/**
 * @description: 平衡二叉树
 * @author: WangDongXu (15224931482)
 * @date: 2020/12/8 20:54
 **/
public class Offer55II {

    /**
     * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        return height(root) == -1 ? false : true;
    }

    public int height(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int leftHeight, rightHeight;

        if((leftHeight = height(node.left)) == -1 || (rightHeight = height(node.right)) == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    /**
     * 解题思路：自底向上，依次遍历，如果有左子树或右子树的高度差大于1，返回false，否则，返回左子树和右子树之间的大值 + 1
     */
}
