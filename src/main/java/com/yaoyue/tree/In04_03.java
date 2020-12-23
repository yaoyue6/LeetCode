package com.yaoyue.tree;

import com.yaoyue.tree.base.ListNode;
import com.yaoyue.tree.base.TreeNode;

/**
 * @description: 特定深度节点链表
 * @author: WangDongXu (15224931482)
 * @date: 2020/12/11 16:17
 **/
public class In04_03 {

    ListNode[] listNode;

    /**
     * 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表
     * （比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
     * @param tree
     * @return
     */
    public ListNode[] listOfDepth(TreeNode tree) {
        // 获取二叉树的深度
        int height = height(tree);

        listNode = new ListNode[height];

        // 构建链表集合
        buildTree(tree, 0);
        return listNode;
    }

    public void buildTree(TreeNode node, int depth) {
        if(node == null) {
            return;
        }

        ListNode next = new ListNode(node.val);
        if (listNode[depth] != null) {
            // 逆向添加节点，最后的节点即为头节点
            next.next = listNode[depth];
        }
        listNode[depth] = next;

        // 逆序遍历，为了方便添加节点
        buildTree(node.right, depth + 1);
        buildTree(node.left, depth + 1);
    }

    public int height(TreeNode node) {
        if(node == null) {
            return 0;
        }
        return Math.max(height(node.left), height(node.right)) + 1;
    }
}
