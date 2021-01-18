package com.yaoyue.practice.tree;

import com.yaoyue.practice.tree.base.TreeNode;

/**
 * @description: a和b节点的最低公共祖先
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/17 16:30
 **/
public class TreeNodeTest07 {

    public class Info {
        /**
         * 当前子树是否含有第1个节点
         */
        public boolean find1;
        /**
         * 当前子树是否含有第2个节点
         */
        public boolean find2;
        /**
         * 两节点的最低公共祖先
         */
        public TreeNode ans;

        public Info(boolean find1, boolean find2, TreeNode ans) {
            this.find1 = find1;
            this.find2 = find2;
            this.ans = ans;
        }
    }

    public TreeNode smallCommonNode(TreeNode root, TreeNode o1, TreeNode o2) {
        return findSmallCommonNode(root, o1, o2).ans;
    }

    /**
     * 获取两节点的最低公共节点
     * @param node
     * @return
     */
    public Info findSmallCommonNode(TreeNode node, TreeNode o1, TreeNode o2) {
        if (node == null) {
            return new Info(false, false, null);
        }

        // 获取左子树反馈的信息
        Info left = findSmallCommonNode(node.left, o1, o2);
        // 获取右子树反馈的信息
        Info right = findSmallCommonNode(node.right, o1, o2);

        // 判断两节点的位置
        boolean find1 = left.find1 || right.find1 || node.val == o1.val ? true : false;
        boolean find2 = left.find2 || right.find2 || node.val == o2.val ? true : false;

        // 公共节点
        TreeNode ans = null;
        // 1、两节点均在左子树，则公共节点在左子树
        if (left.ans != null) {
            ans = left.ans;
        }
        // 2、两节点均在右子树，则公共节点在右子树
        if (right.ans != null) {
            ans = right.ans;
        }
        if (ans == null) {
            if (find1 && find2) {
                ans = node;
            }
        }
        return new Info(find1, find2, ans);
    }

    /**
     * 公共节点的可能性：
     *  1、两节点均在左子树，则公共节点在左子树
     *  2、两节点均在右子树，则公共节点在右子树
     *  3、一个节点在左子树，一个节点在右子树，则当前节点是公共节点
     *  4、两节点均不在当前节点的子树，则返回null
     *  5、一个节点在当前节点的子树，则返回null
     */
}
