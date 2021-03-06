package com.yaoyue.leetcode.tree;

import com.yaoyue.leetcode.tree.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description: 从上到下打印二叉树
 * @author: WangDongXu (15224931482)
 * @date: 2020/12/7 15:24
 **/
public class Offer32I {

    /**
     * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
     * @param root
     * @return
     */
    public int[] levelOrder(TreeNode root) {
        if(root == null) {
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        list.add(root.val);

        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node.left != null) {
                list.add(node.left.val);
                queue.add(node.left);
            }
            if(node.right != null) {
                list.add(node.right.val);
                queue.add(node.right);
            }
        }

        int[] result = new int[list.size()];
        for(int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    /**
     * 解题思路：通过队列添加节点，之后再删除头节点，添加头结点的左子节点和右子节点
     */

    /**
     * 迭代层级遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        queue1.add(root);
        TreeNode node = null;
        while(!queue1.isEmpty()) {
            Queue<TreeNode> queue2 = new LinkedList<>();
            List<Integer> list = new ArrayList<>();
            while(!queue1.isEmpty()) {
                node = queue1.poll();
                list.add(node.val);
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
