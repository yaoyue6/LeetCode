package com.yaoyue.leetcode.tree;

import com.yaoyue.leetcode.tree.base.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 好叶子节点对的数量
 * @author: WangDongXu (15224931482)
 * @date: 2020/12/14 13:13
 **/
public class LeetCode1530 {

    @Test
    public void test() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        int a = countPairs(node1, 3);
        System.out.println(a);
    }

    List<String> leaf = new ArrayList<>();

    /**
     * 给你二叉树的根节点 root 和一个整数 distance。如果二叉树中两个叶节点之间的 最短路径长度 小于或者等于 distance，那它们就可以构成一组 好叶子节点对。
     * 返回树中 好叶子节点对的数量。
     * @param root
     * @param distance
     * @return
     */
    public int countPairs(TreeNode root, int distance) {
        // 中序遍历
        infixOrder(root, "");
        int num = 0;
        // TODO: 2020/12/14 时间复杂度过高，待优化
        for (int i = 0; i < leaf.size(); i++) {
            for (int j = i + 1; j < leaf.size(); j++) {
                int k = 0;
                for (k = 0; k < Math.min(leaf.get(i).length(), leaf.get(j).length()); k++) {
                    if (leaf.get(i).charAt(k) != leaf.get(j).charAt(k)) {
                        break;
                    }
                }
                if(leaf.get(i).length() + leaf.get(j).length() - 2 * k <= distance) {
                    num++;
                }
            }
        }
        return num;
    }

    public void infixOrder(TreeNode node, String path) {
        if(node == null) {
            return;
        }
        if(node.left == null && node.right == null) {
            leaf.add(path);
            return;
        }
        infixOrder(node.left, path + "0");
        infixOrder(node.right, path + "1");
    }

    /**
     * 解题思路：先查找叶子节点，并标记叶子节点的路径，之后进行比较，查找路径中的不一致，并进行判断是否是好叶子节点对
     */
}
