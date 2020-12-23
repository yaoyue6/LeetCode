package com.yaoyue.tree;

import com.yaoyue.tree.base.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @description: N叉树的前序遍历
 * @author: WangDongXu (15224931482)
 * @date: 2020/12/4 17:31
 **/
public class LeetCode589 {

    List<Integer> list = new ArrayList<>();

    /**
     * 给定一个 N 叉树，返回其节点值的前序遍历。
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        if(root == null) {
            return list;
        }
        list.add(root.val);
        for(Node node : root.children) {
            preorder(node);
        }
        return list;
    }

    /**
     * 解题思路：
     *  先遍历添加当前节点，之后依次添加孩子节点
     */

    /**
     *
     * @param root
     * @return
     */
    public List<Integer> preOrder(Node root) {
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();

        if(root == null) {
            return list;
        }

        stack.push(root);
        while(!stack.empty()) {
            Node node = stack.pop();
            list.add(node.val);
            Collections.reverse(node.children);
            for(Node treeNode : node.children) {
                stack.push(treeNode);
            }
        }
        return list;
    }

    /**
     * 解题思路：通过栈倒序
     */
}
