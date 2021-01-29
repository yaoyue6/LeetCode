package com.yaoyue.leetcode.listnode;

import com.yaoyue.leetcode.listnode.base.ListNode;

/**
 * @description: 合并k个排序数组
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/26 17:35
 **/
public class LeetCode23 {

    /**
     * 分治算法
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }
        return mergeLists(lists, 0, lists.length - 1);
    }

    public ListNode mergeLists(ListNode[] lists, int left, int right) {
        if(left >= right) {
            return lists[left];
        }
        int middle = (left + right) / 2;
        ListNode l1 = mergeLists(lists, left, middle);
        ListNode l2 = mergeLists(lists, middle + 1, right);
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
