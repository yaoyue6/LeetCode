package com.yaoyue.practice.tree;

import com.yaoyue.practice.tree.base.TreeNode;

/**
 * @description: 判断是否是完全二叉树
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/17 20:46
 **/
public class TreeNodeTest06 {

    public class Info {
        /**
         * 是否是满二叉树
         */
        public boolean isFull;
        /**
         * 是否是完全二叉树
         */
        public boolean isCBT;
        /**
         * 当前子树的高度
         */
        public int height;

        public Info(boolean isFull, boolean isCBT, int height) {
            this.isFull = isFull;
            this.isCBT = isCBT;
            this.height = height;
        }
    }

    public boolean isCompleteBinaryTree(TreeNode root) {
        return isCBT(root).isCBT;
    }

    public Info isCBT(TreeNode node) {
        if (node == null) {
            return new Info(false, false, 0);
        }
        Info left = isCBT(node.left);
        Info right = isCBT(node.right);

        int height = Math.max(left.height, right.height) + 1;

        boolean isFull = left.isFull && right.isFull && left.height == right.height;
        boolean isCBT = false;

        if (isFull) {
            isCBT = true;
        } else {
            if (left.isCBT && right.isFull && left.height == right.height + 1) {
                isCBT = true;
            }
            if(left.isFull && right.isFull && left.height == right.height + 1) {
                isCBT = true;
            }
            if(left.isFull && right.isCBT && left.height == right.height + 1) {
                isCBT = true;
            }
        }

        return new Info(isFull, isCBT, height);
    }
}
