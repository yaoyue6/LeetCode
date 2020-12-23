package com.yaoyue.listnode.base;

/**
 * @description: 
 * @author: WangDongXu (15224931482)
 * @date: 2020/11/26 21:19
 **/
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
