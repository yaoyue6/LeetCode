package com.yaoyue.leetcode.tree;

import com.yaoyue.leetcode.tree.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 层数最深叶子节点的和
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/15 14:50
 **/
public class LeetCode1302 {

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        head.left = node1;
        head.right = node2;
        node1.left = new TreeNode(4);
        node1.right = new TreeNode(5);
        node2.left = new TreeNode(6);
        node2.right = new TreeNode(7);
        System.out.println(deepestLeavesSum(head));
    }

    /**
     * 迭代实现
     * @param root
     * @return
     */
    public static int deepestLeavesSum(TreeNode root) {
        int sum = 0;
        if(root == null) {
            return sum;
        }

        Queue<TreeNode> queue1 = new LinkedList<>();
        TreeNode node = null;
        queue1.add(root);
        while(!queue1.isEmpty()) {
            sum = 0;
            Queue<TreeNode> queue2 = new LinkedList<>();
            while(!queue1.isEmpty()) {
                node = queue1.poll();
                sum += node.val;
                if(node.left != null) {
                    queue2.add(node.left);
                }
                if(node.right != null) {
                    queue2.add(node.right);
                }
            }
            queue1 = queue2;
        }
        return sum;
    }

    int sum = 0;
    int deepest = 0;

    /**
     * 递归解法
     * @param root
     * @return
     */
    public int deepestLeavesSum1(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

    public void dfs(TreeNode node, int level) {
        if(node == null) {
            return;
        }
        if(node.left == null && node.right == null) {
            if(level == deepest) {
                sum += node.val;
            } else if(level > deepest) {
                // 此时之前的节点不是最深层节点，因此重置最深层的和以及最深层的层数
                sum = node.val;
                deepest = level;
            }
        }
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }
}
