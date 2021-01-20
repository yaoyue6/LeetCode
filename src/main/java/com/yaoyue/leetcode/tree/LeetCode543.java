package com.yaoyue.leetcode.tree;

import com.yaoyue.leetcode.tree.base.TreeNode;

/**
 * @description: 二叉树的直径
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/20 14:52
 **/
public class LeetCode543 {

    int maxDistance;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDistance = 1;
        findMaxDistance(root);
        return maxDistance - 1;
    }

    public int findMaxDistance(TreeNode node) {
        if(node == null) {
            return 0;
        }

        int left = findMaxDistance(node.left);
        int right = findMaxDistance(node.right);

        // 每次均返回子树的高度
        int height = Math.max(left, right) + 1;
        // 当前有两种可能：1、不经过当前节点，最大距离在子树上；2、刚好经过当前节点
        // 如果最大距离在子树上，则为之前保存的maxDistance，如果经过当前节点，则为left的最大高度 + right的最大高度 + 当前节点
        maxDistance = Math.max(maxDistance, left + right + 1);
        return height;
    }
}
