package com.yaoyue.leetcode.tree;

import com.yaoyue.leetcode.tree.base.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @description: 删点成林
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/18 16:35
 **/
public class LeetCode1110 {

    List<TreeNode> nodes = new ArrayList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        // 转化为HashSet，方便判断节点是否是待删除节点
        Set<Integer> set = new HashSet<>();
        for(int num : to_delete) {
            set.add(num);
        }
        // 如果当前节点是待删除节点，则不添加当前节点
        if(!set.contains(root.val)) {
            nodes.add(root);
        }
        buildForest(root, set);
        return nodes;
    }

    public TreeNode buildForest(TreeNode node, Set<Integer> set) {
        if(node == null) {
            return null;
        }

        // 不能定义新节点来操作，新节点独立于原树，因此不会对原树有影响
        node.left = buildForest(node.left, set);
        node.right = buildForest(node.right, set);

        // 如果当前节点为待删除节点，且当前节点的左/右子树不为空，则添加其左/右子树
        if(set.contains(node.val)) {
            if(node.left != null) {
                nodes.add(node.left);
            }
            if(node.right != null) {
                nodes.add(node.right);
            }
            node = null;
        }
        // 回溯返回当前节点
        return node;
    }
}
