package com.yaoyue.leetcode.tree;

import com.yaoyue.leetcode.tree.base.TreeNode;

/**
 * @description: 从前序与中序遍历序列构造二叉树
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/18 19:56
 **/
public class LeetCode105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    /**
     * 通过分治算法解决问题
     * @param preorder 前序遍历结果
     * @param preStart 前序遍历起始下标
     * @param preEnd 前序遍历终止下标
     * @param inorder 中序遍历结果
     * @param inStart 中序遍历起始下标
     * @param inEnd 中序遍历终止下标
     * @return
     */
    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if(preStart == preEnd) {
            return null;
        }
        int rootVal = preorder[preStart];
        TreeNode node = new TreeNode(rootVal);

        int index = 0;

        // 优化思路：预先使用HashMap保存根节点在中序遍历中的位置
        for(int i = inStart; i < inEnd; i++) {
            if(inorder[i] == rootVal) {
                index = i;
                break;
            }
        }

        // 左子树的节点数
        int leftNum = index - inStart;

        // 注意边界，前序遍历左半边起始位置 + 1，需要空出来父节点，中序遍历左右半边中间空出来1位，空出来父节点
        node.left = buildTree(preorder, preStart + 1, preStart + leftNum + 1, inorder, inStart, index);
        node.right = buildTree(preorder, preStart + leftNum + 1, preEnd, inorder, index + 1, inEnd);
        return node;
    }
}
