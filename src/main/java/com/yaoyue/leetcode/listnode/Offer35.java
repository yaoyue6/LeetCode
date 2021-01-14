package com.yaoyue.leetcode.listnode;

/**
 * @description: 复杂链表的复制
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/14 17:31
 **/
public class Offer35 {

    public static void main(String[] args) {
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;

        copyRandomList(node1);
    }

    /**
     *
     * @param head
     * @return
     */
    public static Node copyRandomList(Node head) {
        if(head == null) {
            return null;
        }
        Node temp = head.next;
        Node newHead = new Node(head.val);
        newHead.next = head.next;
        newHead.random = head.random;
        Node cur = newHead;

        while(temp != null) {
            // 复制节点
            Node node = new Node(temp.val);
            node.next = temp.next;
            node.random = temp.random;
            // 将节点加入新链表中
            cur.next = node;
            // 移动新链表节点
            cur = cur.next;
            temp = temp.next;
        }
        return newHead;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
