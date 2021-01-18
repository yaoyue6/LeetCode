package com.yaoyue.leetcode.tree;

import com.yaoyue.leetcode.tree.base.TreeNode;

/**
 * @description: 树的子结构
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/18 10:39
 **/
public class Offer26 {

    /**
     * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
     *  B是A的子结构， 即 A中有出现和B相同的结构和节点值。
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null || B == null) {
            return false;
        }
        // 先判断当前节点，再判断左子节点和右子节点，只要任一为true，则true
        return isSub(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    /**
     * 从当前节点开始验证，直到B节点遍历完毕
     * @param nodeA
     * @param nodeB
     * @return
     */
    public boolean isSub(TreeNode nodeA, TreeNode nodeB) {
        if(nodeB == null) {
            return true;
        }
        if(nodeA == null || nodeA.val != nodeB.val) {
            return false;
        }
        return isSub(nodeA.left, nodeB.left) && isSub(nodeA.right, nodeB.right);
    }
}
