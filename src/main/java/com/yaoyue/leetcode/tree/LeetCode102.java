package com.yaoyue.leetcode.tree;

import com.yaoyue.leetcode.tree.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description: 二叉树的层序遍历
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/15 11:23
 **/
public class LeetCode102 {

    /**
     * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }

        // 辅助队列1，进行遍历
        Queue<TreeNode> queue1 = new LinkedList<>();
        // 添加头结点
        queue1.add(root);
        TreeNode node = null;
        while(!queue1.isEmpty()) {
            // 辅助队列2，存储下一层节点
            Queue<TreeNode> queue2 = new LinkedList<>();
            // 存储每层节点
            List<Integer> list = new ArrayList<>();
            while(!queue1.isEmpty()) {
                node = queue1.poll();
                list.add(node.val);
                // 添加下一层的左子节点
                if(node.left != null) {
                    queue2.add(node.left);
                }
                // 添加下一层的右子节点
                if(node.right != null) {
                    queue2.add(node.right);
                }
            }
            // 添加每层的结果集
            result.add(list);
            // 赋值下一层节点队列
            queue1 = queue2;
        }
        return result;
    }
}
