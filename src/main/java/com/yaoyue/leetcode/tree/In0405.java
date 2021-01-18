package com.yaoyue.leetcode.tree;

import com.yaoyue.leetcode.tree.base.TreeNode;

/**
 * @description: 合法的二叉搜索树
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/18 14:20
 **/
public class In0405 {

    /**
     * 实现一个函数，检查一棵二叉树是否为二叉搜索树。
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        return isBST(root).isBST;
    }

    public class Info {
        public boolean isBST;
        public int max;
        public int min;

        public Info(boolean isBST, int max, int min) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
        }
    }

    /**
     * 树形dp解法
     * @param node
     * @return
     */
    public Info isBST(TreeNode node) {
        if(node == null) {
            return null;
        }
        Info left = isBST(node.left);
        Info right = isBST(node.right);

        int max = node.val;
        int min = node.val;
        boolean isBST = false;

        if((left == null ? true : left.isBST) && (right == null ? true : right.isBST) && (left == null ? true : left.max < node.val) && (right == null ? true : right.min > node.val)) {
            isBST = true;
            max = right == null ? node.val : right.max;
            min = left == null ? node.val : left.min;
        }
        return new Info(isBST, max, min);
    }


    public boolean isValidBST1(TreeNode root) {
        return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * 递归解法
     * @param node
     * @param min
     * @param max
     * @return
     */
    public boolean isBST(TreeNode node, long min, long max) {
        if(node == null) {
            return true;
        }

        if (node.val >= max || node.val <= min) {
            return false;
        }
        return isBST(node.left, min, node.val) && isBST(node.right, node.val, max);
    }

    long max = Long.MIN_VALUE;

    /**
     * 中序遍历
     * @param node
     * @return
     */
    public boolean isValidBST2(TreeNode node) {
        if(node == null) {
            return true;
        }

        if(isValidBST2(node.left)) {
            if(max >= node.val) {
                return false;
            } else {
                max = node.val;
                return isValidBST2(node.right);
            }
        }
        return false;
    }
}
