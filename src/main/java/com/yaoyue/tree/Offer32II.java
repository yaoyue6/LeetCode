package com.yaoyue.tree;

import com.yaoyue.tree.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description: 从上到下打印二叉树 II
 * @author: WangDongXu (15224931482)
 * @date: 2020/12/7 16:06
 **/
public class Offer32II {

    /**
     * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();

            // 为什么倒序添加？在循环时会不停从队列中删除数据，因此队列的长度不固定，如果正序添加，需要先定义队列的长度，之后再进行循环删除
            for(int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                // 生成当前层的数组
                list.add(node.val);
                // 添加下一层的节点
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(list);
        }
        return result;
    }

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder2(TreeNode root) {
        if(root == null) {
            return result;
        }

        bfs(0, root);
        return result;
    }

    public void bfs(int depth, TreeNode node) {
        if (node == null) {
            return;
        }
        if (result.size() == depth) {
            result.add(new ArrayList<Integer>());
        }
        result.get(depth).add(node.val);
        bfs(depth + 1, node.left);
        bfs(depth + 1, node.right);
    }

    /**
     * 解题思路：通过list查找添加同层数据解题
     */
}
