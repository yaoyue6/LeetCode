package com.yaoyue.practice.tree;

import com.yaoyue.practice.tree.base.TreeNode;

/**
 * @description: 二叉树中两节点的最大距离
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/16 21:01
 **/
public class TreeNodeTest04 {

    public class Info {
        /**
         * 当前节点所在层
         */
        public int height;
        /**
         * 当前子树的最大距离
         */
        public int maxDistance;

        public Info(int height, int maxDistance) {
            this.height = height;
            this.maxDistance = maxDistance;
        }
    }

    /**
     * 计算当前树的最大距离
     * @param root
     * @return
     */
    public int getMaxDistance(TreeNode root) {
        return maxDistance(root).maxDistance;
    }

    /**
     * 两种情况：
     *  1、经过根节点：两节点一个在左子树，一个在右子树
     *  2、不经过根节点：两节点均在左子树或均在右子树
     * @param node
     * @return
     */
    public Info maxDistance(TreeNode node) {
        if (node == null) {
            return new Info(0, 0);
        }
        // 获得左子树的高度及最大距离信息
        Info left = maxDistance(node.left);
        // 获得右子树的高度及最大距离信息
        Info right = maxDistance(node.right);
        // 获得当前节点的高度
        int height = Math.max(left.height, right.height) + 1;
        // 比较左子树的最大距离、右子树的最大距离、左右子树的最大距离
        int maxDistance = Math.max(Math.max(left.maxDistance, right.maxDistance), left.height + right.height + 1);
        return new Info(height, maxDistance);
    }
}
