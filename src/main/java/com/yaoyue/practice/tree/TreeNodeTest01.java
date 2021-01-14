package com.yaoyue.practice.tree;

import com.yaoyue.practice.tree.base.TreeNode;

import java.util.Stack;

/**
 * @description: 前中后序迭代遍历二叉树
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/14 22:15
 **/
public class TreeNodeTest01 {

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
        System.out.println("前序遍历：");
        preOrder(head);
        System.out.println("中序遍历：");
        infixOrder(head);
        System.out.println("后序遍历：");
        nextOrder(head);
    }

    /**
     * 迭代实现前序遍历
     * @param head
     */
    public static void preOrder(TreeNode head) {
        if(head == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();

        TreeNode node = head;
        stack.push(node);
        while(!stack.isEmpty()) {
            head = stack.pop();
            System.out.println(head.val);
            if (head.right != null) {
                stack.push(head.right);
            }
            if(head.left != null) {
                stack.push(head.left);
            }
        }
    }

    /**
     * 迭代实现中序遍历
     * @param head
     */
    public static void infixOrder(TreeNode head) {
        if(head == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();

        TreeNode node = head;

        while(!stack.isEmpty() || node != null) {
            // 第1个逻辑：一直将左子节点添加到栈中
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                // 第2个逻辑：将当前节点弹出，之后进入右子节点
                node = stack.pop();
                System.out.println(node.val);
                node = node.right;
            }
        }
    }

    /**
     * 迭代实现后序遍历
     * @param head
     */
    public static void nextOrder(TreeNode head) {
        if(head == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> result = new Stack<>();

        TreeNode node = head;
        stack.push(node);
        while(!stack.isEmpty()) {
            head = stack.pop();
            result.add(head);

            if(head.left != null) {
                stack.push(head.left);
            }
            if (head.right != null) {
                stack.push(head.right);
            }
        }
        while(!result.isEmpty()) {
            System.out.println(result.pop().val);
        }
    }
}
