package com.yaoyue.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description: N 叉树的层序遍历
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/15 13:37
 **/
public class LeetCode429 {

    /**
     * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }

        Queue<Node> queue1 = new LinkedList<>();
        Node node = null;
        queue1.add(root);
        while(!queue1.isEmpty()) {
            Queue<Node> queue2 = new LinkedList<>();
            List<Integer> list = new ArrayList<>();
            while(!queue1.isEmpty()) {
                node = queue1.poll();
                list.add(node.val);
                // 循环子节点数组，添加下一层节点
                for(Node temp : node.children) {
                    queue2.add(temp);
                }
            }
            result.add(list);
            queue1 = queue2;
        }
        return result;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};