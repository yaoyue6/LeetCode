package com.yaoyue.tree.base;

import java.util.List;

/**
 * @description: N叉树
 * @author: WangDongXu (15224931482)
 * @date: 2020/12/4 17:32
 **/
public class Node {

    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
