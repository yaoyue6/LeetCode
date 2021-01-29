package com.yaoyue.leetcode.tree;

import com.yaoyue.leetcode.tree.base.TreeNode;

/**
 * @description: 二叉搜索树第K小元素
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/25 17:16
 **/
public class LeetCode230 {

    int target = 0, k = 0;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        process(root);
        return target;
    }

    public void process(TreeNode node) {
        if(node == null) {
            return;
        }

        process(node.left);
        k--;
        if(k == 0) {
            target = node.val;
            return;
        }
        process(node.right);
    }
}
