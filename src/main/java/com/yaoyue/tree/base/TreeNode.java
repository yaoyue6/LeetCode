package com.yaoyue.tree.base;

/**
 * @description: 二叉树节点
 * @author: WangDongXu (15224931482)
 * @date: 2020/12/4 17:10
 **/
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
