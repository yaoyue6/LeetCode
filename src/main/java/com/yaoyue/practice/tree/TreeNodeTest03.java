package com.yaoyue.practice.tree;

import com.yaoyue.practice.tree.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 二叉树的序列化与反序列化
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/15 20:19
 **/
public class TreeNodeTest03 {

    /**
     * 构建序列化队列
     * @param node
     * @return
     */
    public Queue<String> preSerial(TreeNode node) {
        Queue<String> queue = new LinkedList<>();
        pres(queue, node);
        return queue;
    }

    public void pres(Queue<String> queue, TreeNode node) {
        if(node == null) {
            return;
        }
        queue.add(String.valueOf(node.val));
        pres(queue, node.left);
        pres(queue, node.right);
    }

    /**
     * 反序列化为树
     * @param queue
     * @return
     */
    public TreeNode buildByQueuePre(Queue<String> queue) {
        if(queue.isEmpty()) {
            return null;
        }
        return preb(queue);
    }

    public TreeNode preb(Queue<String> queue) {
        if(queue.isEmpty()) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(queue.poll()));
        node.left = preb(queue);
        node.right = preb(queue);
        return node;
    }
}
