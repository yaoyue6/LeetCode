package com.yaoyue.leetcode.tree;

import com.yaoyue.leetcode.tree.base.TreeNode;

import java.util.ArrayList;

/**
 * @description: 二叉树根节点到叶子节点和为指定值的路径
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/26 14:35
 **/
public class Offer8 {

    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> pathSum (TreeNode root, int sum) {
        process(root, sum, 0);
        return result;
    }

    public void process(TreeNode node, int sum, int count) {
        if(node == null) {
            return;
        }
        list.add(node.val);
        count += node.val;
        if(node.left == null && node.right == null) {
            if(sum == count) {
                result.add(new ArrayList<>(list));
            }
        } else {
            // 不能改变原值，因为回溯返回时会出错
            process(node.left, sum, count);
            process(node.right, sum, count);
        }

        list.remove(list.size() - 1);
    }
}
