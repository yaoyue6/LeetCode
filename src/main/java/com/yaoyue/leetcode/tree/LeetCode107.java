package com.yaoyue.leetcode.tree;

import com.yaoyue.leetcode.tree.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 二叉树的层次遍历 II
 * @author: WangDongXu (15224931482)
 * @date: 2020/12/10 17:16
 **/
public class LeetCode107 {

    List<List<Integer>> list = new ArrayList<>();

    /**
     * 给定一个二叉树，返回其节点值自底向上的层次遍历。（即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) {
            return list;
        }

        levelOrder(root, 0);
        return list;
    }

    public void levelOrder(TreeNode node, int k) {
        if(node == null) {
            return;
        }
        if (k == list.size()) {
            list.add(0, new ArrayList<Integer>());
        }
        list.get(list.size() - k - 1).add(node.val);
        levelOrder(node.left, k + 1);
        levelOrder(node.right, k + 1);
    }
}
