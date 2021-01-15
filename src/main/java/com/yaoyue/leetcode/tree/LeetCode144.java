package com.yaoyue.leetcode.tree;

import com.yaoyue.leetcode.tree.base.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description: 二叉树的前序遍历
 * @author: WangDongXu (15224931482)
 * @date: 2020/12/9 16:06
 **/
public class LeetCode144 {

    List<Integer> list = new ArrayList<>();

    /**
     * 递归解法
     * @param root
     * @return
     */
    public List<Integer> preOrderTraversal1(TreeNode root) {
        if(root == null) {
            return list;
        }
        list.add(root.val);
        preOrderTraversal1(root.left);
        preOrderTraversal1(root.right);
        return list;
    }

    /**
     * 迭代解法，使用栈来模拟系统栈来实现解题
     * @param root
     * @return
     */
    public List<Integer> preOrderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if(node.right != null) {
                stack.push(node.right);
            }
            if(node.left != null) {
                stack.push(node.left);
            }
        }
        return list;
    }
}
