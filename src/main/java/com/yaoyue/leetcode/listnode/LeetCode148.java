package com.yaoyue.leetcode.listnode;

import com.yaoyue.leetcode.listnode.base.ListNode;

/**
 * @description: 排序链表
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/26 17:10
 **/
public class LeetCode148 {

    /**
     * 分治算法解题
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        return mergeListNode(head, null);
    }

    public ListNode mergeListNode(ListNode head, ListNode tail) {
        if(head == tail) {
            return head;
        }

        if (head.next == tail) {
            head.next = null;
            return head;
        }

        // 利用快慢指针确定中点
        ListNode fast = head;
        ListNode slow = head;

        // 直接判断fast != tail && fast.next != tail，时间会超出限制
        while(fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if(fast != tail) {
                fast = fast.next;
            }
        }

        ListNode mid = slow;

        // 向左递归
        ListNode l1 = mergeListNode(head, mid);
        // 向右递归
        ListNode l2 = mergeListNode(mid, tail);
        return merge(l1, l2);
    }

    /**
     * 合并两个排序链表
     * @param l1
     * @param l2
     * @return
     */
    public ListNode merge(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode node = l1.val > l2.val ? l2 : l1;
        ListNode cur = node;
        l1 = l1 == cur ? l1.next : l1;
        l2 = l2 == cur ? l2.next : l2;
        while(l1 != null && l2 != null) {
            if(l1.val > l2.val) {
                cur.next = l2;
                l2 = l2.next;
            } else {
                cur.next = l1;
                l1 = l1.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return node;
    }
}
