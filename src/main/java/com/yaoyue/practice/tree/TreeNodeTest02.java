package com.yaoyue.practice.tree;

import com.yaoyue.practice.tree.base.TreeNode;

import java.util.LinkedList;
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
        level(head);
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
}
