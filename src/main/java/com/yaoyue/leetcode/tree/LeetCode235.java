package com.yaoyue.leetcode.tree;

import com.yaoyue.leetcode.tree.base.TreeNode;

/**
 * @description: 二叉搜索树的最近公共祖先
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/20 10:34
 **/
public class LeetCode235 {

    /**
     * 自顶向下递归解题
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }

        // 如果在左子树，向左递归
        if(root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor1(root.left, p, q);
        }

        // 如果在右子树，向右递归
        if(root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor1(root.right, p, q);
        }
        return root;
    }

    /**
     * 迭代解题
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }

        while((root.val > p.val && root.val > q.val) || (root.val < p.val && root.val < q.val)) {
            root = root.val > p.val ? root.left : root.right;
        }
        return root;
    }
}
