package com.yaoyue.practice.tree;

import com.yaoyue.practice.tree.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description: 层次遍历二叉树
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/14 22:14
 **/
public class TreeNodeTest02 {

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
        levelOrderBottom1(head);
    }

    public static void level(TreeNode head) {
        if(head == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            System.out.println(node.val);
        }
    }

    public static List<List<Integer>> levelOrderBottom1(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue1 = new LinkedList<>();
        queue1.add(root);
        TreeNode node = null;
        while (!queue1.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            // 辅助队列，用来存储每层的节点
            Queue<TreeNode> queue2 = new LinkedList<>();
            while (!queue1.isEmpty()) {
                // 弹出队列中的头结点
                node = queue1.poll();
                list.add(node.val);
                // 将每层节点存储入队列
                if (node.left != null) {
                    queue2.add(node.left);
                }
                if (node.right != null) {
                    queue2.add(node.right);
                }
            }
            result.add(0, list);
            // 将上一层节点队列赋值给当前队列
            queue1 = queue2;
        }
        return result;
    }
}
