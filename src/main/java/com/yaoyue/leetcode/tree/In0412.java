package com.yaoyue.leetcode.tree;

import com.yaoyue.leetcode.tree.base.TreeNode;

/**
 * @description: 求和路径
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/18 15:42
 **/
public class In0412 {
    int count = 0;

    public int pathSum(TreeNode root, int sum) {
        if(root == null) {
            return count;
        }
        // 从根节点开始遍历
        preOrder(root, sum);
        // 从左子树开始遍历
        pathSum(root.left, sum);
        // 从右子树开始遍历
        pathSum(root.right, sum);
        return count;
    }

    public void preOrder(TreeNode node, int sum) {
        if(node == null) {
            return;
        }
        if(sum == node.val) {
            count++;
        }
        // 依次向左右递归
        preOrder(node.left, sum - node.val);
        preOrder(node.right, sum - node.val);
    }
}
