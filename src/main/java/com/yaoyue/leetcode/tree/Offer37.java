package com.yaoyue.leetcode.tree;

import com.yaoyue.leetcode.tree.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Offer37 {

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        head.left = node1;
        head.right = node2;
        node2.left = new TreeNode(4);
        node2.right = new TreeNode(5);
//        node2.left = new TreeNode(6);
//        node2.right = new TreeNode(7);
        System.out.println(serialize(head));
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        if(root == null) {
            return null;
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        TreeNode node = null;
        queue1.add(root);
        while(!queue1.isEmpty()) {
            Queue<TreeNode> queue2 = new LinkedList<>();
            while(!queue1.isEmpty()) {
                node = queue1.poll();
                list.add(String.valueOf(node.val));
                if(node.left != null) {
                    queue2.add(node.left);
                } else{
                    list.add(null);
                }
                if(node.right != null) {
                    queue2.add(node.right);
                } else {
                    list.add(null);
                }
            }
            queue1 = queue2;
        }

        StringBuilder bf = new StringBuilder();
        for (String str : list) {
            bf.append(str + ",");
        }
        return bf.toString().substring(0, bf.length() -1);
    }

    // Decodes your encoded data to tree.
//    public TreeNode deserialize(String data) {
//
//    }
}
