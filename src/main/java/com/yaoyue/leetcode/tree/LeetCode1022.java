package com.yaoyue.leetcode.tree;

import com.yaoyue.leetcode.tree.base.TreeNode;
import org.junit.Test;

/**
 * @description: 从根到叶的二进制数之和
 * @author: WangDongXu (15224931482)
 * @date: 2020/12/8 21:46
 **/
public class LeetCode1022 {

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(0);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(0);
        TreeNode node6 = new TreeNode(1);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        int i = sumRootToLeaf(root);
        System.out.println(i);
    }

    int sum = 0;

    /**
     * 给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
     * 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。返回这些数字之和。题目数据保证答案是一个 32 位 整数。
     * @param root
     * @return
     */
    public int sumRootToLeaf(TreeNode root) {
        sum(root, 0);
        return sum;
    }

    public void sum(TreeNode node, int num) {
        if(node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            sum += num * 2 + node.val;
            return;
        }

        sum(node.left, num * 2 + node.val);
        sum(node.right, num * 2 + node.val);
    }

    /**
     * 解题思路：从根节点开始遍历，之后进行值的累加 * 2 + 当前节点的值，到达叶子节点时，进行处理，加上叶子节点的值
     */
}
