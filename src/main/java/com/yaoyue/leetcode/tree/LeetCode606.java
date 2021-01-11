package com.yaoyue.leetcode.tree;

import com.yaoyue.leetcode.tree.base.TreeNode;

/**
 * @description: 根据二叉树创建字符串
 * @author: WangDongXu (15224931482)
 * @date: 2020/12/9 10:11
 **/
public class LeetCode606 {

    /**
     * 你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
     * 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
     * @param root
     * @return
     */
    public String tree2str(TreeNode root) {
        // 程序终止条件
        if (root == null) {
            return "";
        }
        // 第1种情况
        if (root.left == null && root.right == null) {
            return root.val + "";
        }
        // 第2种情况
        if (root.right == null) {
            return root.val + "(" + tree2str(root.left) + ")";
        }
        // 第3、4种情况
        return root.val + "(" + tree2str(root.left) + ")(" + tree2str(root.right) + ")";
    }

    /**
     * 解题思路：存在四种情况：1.左右节点均不存在 2.左节点存在，右节点不存在 3.左节点不存在，右节点存在 4.左右节点均存在
     */
}
