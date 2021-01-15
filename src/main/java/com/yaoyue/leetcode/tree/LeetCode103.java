package com.yaoyue.leetcode.tree;

import com.yaoyue.leetcode.tree.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description: 二叉树的锯齿形层序遍历
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/15 14:23
 **/
public class LeetCode103 {

    /**
     * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }

        TreeNode node = null;
        Queue<TreeNode> queue1 = new LinkedList<>();
        int index = 0;
        queue1.add(root);
        while(!queue1.isEmpty()) {
            Queue<TreeNode> queue2 = new LinkedList<>();
            List<Integer> list = new ArrayList<>();
            index++;
            while(!queue1.isEmpty()) {
                node = queue1.poll();
                if(index % 2 == 0) {
                    list.add(0, node.val);
                } else {
                    list.add(node.val);
                }
                if(node.left != null) {
                    queue2.add(node.left);
                }
                if(node.right != null) {
                    queue2.add(node.right);
                }
            }
            result.add(list);
            queue1 = queue2;
        }
        return result;
    }
}
