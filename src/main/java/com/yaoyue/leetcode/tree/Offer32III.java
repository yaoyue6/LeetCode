package com.yaoyue.leetcode.tree;

import com.yaoyue.leetcode.tree.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description: 从上到下打印二叉树 III
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/15 14:14
 **/
public class Offer32III {

    /**
     * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        TreeNode node = null;
        Queue<TreeNode> queue1 = new LinkedList<>();
        queue1.add(root);
        // 标记所在层数
        int index = 0;
        while(!queue1.isEmpty()) {
            index++;
            Queue<TreeNode> queue2 = new LinkedList<>();
            List<Integer> list = new ArrayList<>();
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
