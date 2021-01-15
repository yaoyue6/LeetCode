package com.yaoyue.leetcode.tree;

import com.yaoyue.leetcode.tree.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    /**
     * dfs递归解法
     * @param node
     * @param k
     */
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

    /**
     * bfs迭代解法
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom1(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }

        Queue<TreeNode> queue1 = new LinkedList<>();
        queue1.add(root);
        TreeNode node = null;
        while(!queue1.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            // 辅助队列，用来存储每层的节点，由于每次都会新创建队列，所以不需要担心会重复添加
            Queue<TreeNode> queue2 = new LinkedList<>();
            while(!queue1.isEmpty()) {
                // 弹出队列中的头结点
                node = queue1.poll();
                list.add(node.val);
                // 将下一层节点存储入队列
                if(node.left != null) {
                    queue2.add(node.left);
                }
                if(node.right != null) {
                    queue2.add(node.right);
                }
            }
            result.add(0, list);
            // 将下一层节点队列赋值给队列
            queue1 = queue2;
        }
        return result;
    }
}
