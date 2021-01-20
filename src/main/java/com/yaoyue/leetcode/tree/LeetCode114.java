package com.yaoyue.leetcode.tree;

import com.yaoyue.leetcode.tree.base.TreeNode;

import java.util.Stack;

/**
 * @description: 二叉树展开为链表
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/20 17:23
 **/
public class LeetCode114 {

    /**
     * 迭代解法，直接前序遍历，之后将当前节点连接上一层节点的右子树，左子树置为null，最后将当前节点赋值给上一层节点
     * @param root
     */
    public void flatten1(TreeNode root) {
        if(root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        TreeNode temp = null;
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(node.right != null) {
                stack.push(node.right);
            }
            if(node.left != null) {
                stack.push(node.left);
            }
            if(temp != null) {
                temp.right = node;
                temp.left = null;
            }
            temp = node;
        }
    }



    TreeNode pre;

    /**
     * 递归解法，解题思路：采用右左中的遍历方式，从最后一个节点向上进行拼接链表
     * @param root
     */
    public void flatten2(TreeNode root) {
        if(root == null) {
            return;
        }

        flatten2(root.right);
        flatten2(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }
}
