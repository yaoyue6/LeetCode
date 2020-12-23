package com.yaoyue.tree;

import com.yaoyue.tree.base.TreeNode;

/**
 * @description: 路径总和
 * @author: WangDongXu (15224931482)
 * @date: 2020/12/8 21:31
 **/
public class LeetCode112 {

    /**
     * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) {
            return false;
        }
        if(root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    /**
     * 解题思路：依次向下遍历，直到叶子节点，判断剩余的值是否与叶子节点的值相等
     */
}
