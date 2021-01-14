package com.yaoyue.leetcode.listnode;

import com.yaoyue.leetcode.listnode.base.ListNode;

/**
 * @description: 重排链表
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/14 18:47
 **/
public class LeetCode143 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
        reorderList(head);
    }

    public static void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) {
            return;
        }

        ListNode cur = head;
        ListNode fast = head;
        ListNode slow = head;
        ListNode temp = new ListNode();
        ListNode pre = temp;

        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }

        while(slow != null) {
            ListNode next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }

        fast = head;
        ListNode node = temp;
        while(fast.val != slow.val) {
            node.next = fast;
            fast.next = slow;
            fast = fast.next;
            slow = slow.next;
            node = node.next.next;
        }
    }
}
