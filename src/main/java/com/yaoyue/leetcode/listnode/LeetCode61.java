package com.yaoyue.leetcode.listnode;

import com.yaoyue.leetcode.listnode.base.ListNode;

/**
 * @description: 旋转链表
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/14 15:20
 **/
public class LeetCode61 {

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        System.out.println((3-4) % 3);
        System.out.println(rotateRight(head, 3));
    }

    /**
     * 快慢指针解题
     * @param head
     * @param k
     * @return
     */
    public static ListNode rotateRight(ListNode head, int k) {
        if(k == 0 || head == null || head.next == null) {
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;
        while(k > 0) {
            if(fast == null) {
                fast = head;
            }
            fast = fast.next;
            k--;
        }

        // 如果移动的次数和链表长度一致，则不变
        if(fast == null) {
            return head;
        }

        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        ListNode next = slow.next;
        slow.next = null;
        fast.next = head;
        return next;
    }
}
