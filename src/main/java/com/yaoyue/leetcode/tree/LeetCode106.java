package com.yaoyue.leetcode.tree;

import com.yaoyue.leetcode.tree.base.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 从中序遍历和后序遍历构建二叉树
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/19 15:05
 **/
public class LeetCode106 {

    Map<Integer, Integer> map = new HashMap<>();
    int[] post;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        post = postorder;
        return buildTree(0, inorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode buildTree(int inStart, int inEnd, int postStart, int postEnd) {
        if(postStart > postEnd || inStart > inEnd) {
            return null;
        }

        TreeNode node = new TreeNode(post[postEnd]);

        int index = map.get(node.val);
        int leftNum = index - inStart;
        node.left = buildTree(inStart, index - 1, postStart, postStart + leftNum - 1);
        node.right = buildTree(index + 1, inEnd, postStart + leftNum, postEnd - 1);
        return node;
    }
}
