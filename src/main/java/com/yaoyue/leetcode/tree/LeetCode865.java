package com.yaoyue.leetcode.tree;

import com.yaoyue.leetcode.tree.base.TreeNode;

/**
 * @description: 具有所有最深节点的最小子树
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/18 15:11
 **/
public class LeetCode865 {

    int maxDepth = 1;
    TreeNode ans;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        deepParentNode(root, 1);
        return ans;
    }

    public int deepParentNode(TreeNode node, int depth) {
        if(node == null) {
            return depth;
        }
        int left = deepParentNode(node.left, depth + 1);
        int right = deepParentNode(node.right, depth + 1);

        int currentDepth = Math.max(left, right);
        if(left == right && currentDepth >= maxDepth) {
            ans = node;
            maxDepth = currentDepth;
        }
        return currentDepth;
    }
}
