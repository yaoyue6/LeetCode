package com.yaoyue.leetcode.tree;

import com.yaoyue.leetcode.tree.base.TreeNode;

/**
 * @description: 二叉树的最近公共祖先
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/19 21:14
 **/
public class LeetCode236 {

    public class Info {
        public TreeNode node;
        public boolean find1;
        public boolean find2;

        public Info(TreeNode node, boolean find1, boolean find2) {
            this.node = node;
            this.find1 = find1;
            this.find2 = find2;
        }
    }

    /**
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return commonAncestor(root, p, q).node;
    }

    public Info commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return new Info(null, false, false);
        }

        Info left = commonAncestor(root.left, p, q);
        Info right = commonAncestor(root.right, p, q);

        boolean find1 = (left.find1 || right.find1 || root.val == p.val) ? true : false;
        boolean find2 = (left.find2 || right.find2 || root.val == q.val) ? true : false;
        TreeNode node = null;

        if(left.node != null) {
            node = left.node;
        }
        if(right.node != null) {
            node = right.node;
        }
        if(node == null) {
            if(find1 && find2) {
                node = root;
            }
        }

        return new Info(node, find1, find2);
    }
}
