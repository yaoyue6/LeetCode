package com.yaoyue.practice.tree;

import com.yaoyue.practice.tree.base.TreeNode;

/**
 * @description: 最大的二叉搜索子树
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/16 21:45
 **/
public class TreeNodeTest05 {

    public class Info {
        /**
         * 子树中二叉搜索树节点的数目
         */
        public int size;
        /**
         * 是否都是二叉搜索树
         */
        public boolean isAllBST;
        /**
         * 子树中节点的最小值
         */
        public int min;
        /**
         * 子树中节点的最大值
         */
        public int max;

        public Info(int size, boolean isAllBST, int min, int max) {
            this.size = size;
            this.isAllBST = isAllBST;
            this.min = min;
            this.max = max;
        }
    }

    public int maxBSTChildren(TreeNode root) {
        return getMaxBSTChildren(root).size;
    }

    public Info getMaxBSTChildren(TreeNode node) {
        if (node == null) {
            return null;
        }

        // 获得左子树的信息
        Info left = getMaxBSTChildren(node.left);
        // 获得右子树的信息
        Info right = getMaxBSTChildren(node.right);

        // 构建当前节点信息

        // 处理最大值和最小值信息
        int min = node.val;
        int max = node.val;

        if (left != null) {
            min = Math.min(left.min, node.val);
            max = Math.max(left.max, node.val);
        }
        if (right != null) {
            min = Math.min(right.min, node.val);
            max = Math.max(right.max, node.val);
        }

        // 处理最大二叉搜索子树size
        int size = 0;
        if (left != null) {
            size = Math.max(left.size, size);
        }
        if (right != null) {
            size = Math.max(right.size, size);
        }

        // 处理是否均是二叉搜索树
        boolean isAllBST = false;

        // 全为二叉搜索树有四种情况：1、左子树均为二叉搜索树；2、右子树均为二叉搜索树；3、左子树的最大值小于当前节点的值；4、右子树的最小值大于当前节点的值
        if ((left == null ? true : left.isAllBST) && (right == null ? true : right.isAllBST) && (left == null ? true : left.max < node.val) && (right == null ? true : right.min > node.val)) {
            isAllBST = true;
            // 此时均是二叉搜索树，因此获得二叉搜索树的全部节点数，如果为空，默认0，否则，左子树节点数 + 右子树节点数 + 1
            size = (left == null ? 0 : left.size) + (right == null ? 0 : right.size) + 1;
        }
        return new Info(size, isAllBST, max, min);
    }
}
